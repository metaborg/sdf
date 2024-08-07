package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.query.*;
import org.metaborg.parsetable.states.IMutableState;
import org.metaborg.parsetable.states.IState;
import org.metaborg.sdf2table.grammar.CharacterClassSymbol;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.util.collection.LinkedSetMultimap;

public class State implements IMutableState, Comparable<State>, Serializable {

    private static final long serialVersionUID = 7118071460461287164L;

    ParseTable pt;

    private final int label;
    private final Set<Goto> gotos;
    private final Map<Integer, IGoto> gotosMapping;
    private final Set<LRItem> kernel;
    private final Set<LRItem> items;
    private final LinkedSetMultimap<Symbol, LRItem> symbol_items;
    private final LinkedSetMultimap<ICharacterClass, Action> lr_actions;
    IActionsForCharacter actionsForCharacter;
    private boolean rejectable;

    private StateStatus status = StateStatus.VISIBLE;

    public State(IProduction initialProduction, ParseTable pt) {
        this(Collections.singleton(new LRItem(initialProduction, 0, pt)), pt);
    }

    public State(Set<LRItem> kernel, ParseTable pt) {
        items = new LinkedHashSet<>();
        gotos = new LinkedHashSet<>();
        gotosMapping = new HashMap<>();
        symbol_items = new LinkedSetMultimap<>();
        lr_actions = new LinkedSetMultimap<>();
        this.rejectable = false;

        this.kernel = new LinkedHashSet<>();
        this.kernel.addAll(kernel);
        pt.kernelMap().put(kernel, this);

        this.pt = pt;
        label = this.pt.totalStates();
        this.pt.stateLabels().put(label, this);
        this.pt.incTotalStates();
    }

    public void closure() {
        for(LRItem item : kernel) {
            // if(item.getDotPosition() < item.getProd().arity()) {
            // pt.symbolStatesMapping().put(item.getProd().rightHand().get(item.getDotPosition()), this);
            // }
            item.process(items, symbol_items, this);
        }
    }

    public void doShift() {
        for(Symbol s_at_dot : symbol_items.keySet()) {
            if(s_at_dot instanceof CharacterClassSymbol) {
                Set<LRItem> new_kernel = new LinkedHashSet<LRItem>();
                Set<Goto> new_gotos = new LinkedHashSet<Goto>();
                Set<Shift> new_shifts = new LinkedHashSet<Shift>();
                for(LRItem item : symbol_items.get(s_at_dot)) {
                    Shift shift = new Shift(((CharacterClassSymbol) s_at_dot).getCC());
                    new_kernel.add(item.shiftDot());
                    if(!(item.getProd().equals(pt.initialProduction()) && item.getDotPosition() == 1)) {
                        new_shifts.add(shift);
                    }
                }
                if(!new_kernel.isEmpty()) {
                    checkKernel(new_kernel, new_gotos, new_shifts);
                }
            } else {
                for(IProduction p : pt.normalizedGrammar().getSymbolProductionsMapping().get(s_at_dot)) {

                    // p might be a contextual production
                    if(pt.normalizedGrammar().getProdContextualProdMapping().get(p) != null) {
                        p = pt.normalizedGrammar().getProdContextualProdMapping().get(p);
                    }

                    Set<LRItem> new_kernel = new LinkedHashSet<LRItem>();
                    Set<Goto> new_gotos = new LinkedHashSet<Goto>();
                    Set<Shift> new_shifts = new LinkedHashSet<Shift>();
                    for(LRItem item : symbol_items.get(s_at_dot)) {
                        // if item.prod does not conflict with p
                        if(!item.isPriorityConflict(p)) {
                            new_kernel.add(item.shiftDot());
                            new_gotos.add(new Goto(pt.productionLabels().get(p), pt));
                        }
                    }
                    if(!new_kernel.isEmpty()) {
                        checkKernel(new_kernel, new_gotos, new_shifts);
                    }
                }
            }
        }
    }

    public void doReduces() {
        // for each item p_i : A = A0 ... AN .
        // add a reduce action reduce([0-MAX_CHAR,eof] / follow(A), p_i)
        for(LRItem item : items) {

            if(item.getDotPosition() == item.getProd().arity()) {
                int prod_label = pt.productionLabels().get(item.getProd());

                ISymbol leftHandSymbol = item.getProd().leftHand();
                ICharacterClass fr = leftHandSymbol.followRestriction();
                if((fr == null || fr.isEmpty()) && leftHandSymbol.followRestrictionLookahead() == null) {
                    addReduceAction(item.getProd(), prod_label, CharacterClassFactory.FULL_RANGE, null);
                } else {
                    ICharacterClass final_range = CharacterClassFactory.FULL_RANGE;
                    // Not based on first and follow sets thus, only considering the follow restrictions
                    if(fr != null && !fr.isEmpty()) {
                        final_range = final_range.difference(leftHandSymbol.followRestriction());
                    }
                    for(ICharacterClass[] s : leftHandSymbol.followRestrictionLookahead()) {
                        final_range = final_range.difference(s[0]);

                        // create reduce Lookahead actions
                        ICharacterClass[] lookahead = Arrays.copyOfRange(s, 1, s.length);
                        addReduceAction(item.getProd(), prod_label, s[0], lookahead);
                    }
                    addReduceAction(item.getProd(), prod_label, final_range, null);
                }
            }
            // <Start> = <START> . <EOF>
            if(item.getProd().equals(pt.initialProduction()) && item.getDotPosition() == 1) {
                lr_actions.put(CharacterClassFactory.EOF_SINGLETON, new Accept(CharacterClassFactory.EOF_SINGLETON));
            }
        }
    }

    private void addReduceAction(IProduction p, Integer label, ICharacterClass cc, ICharacterClass[] lookahead) {
        ICharacterClass final_range = cc;
        ParseTableProduction prod = pt.productionsMapping().get(p);

        LinkedSetMultimap<ICharacterClass, Action> newLR_actions = new LinkedSetMultimap<>();

        for(ICharacterClass range : lr_actions.keySet()) {
            if(final_range.isEmpty()) {
                break;
            }
            ICharacterClass intersection = final_range.intersection(range);
            if(!intersection.isEmpty()) {
                if(intersection.equals(range)) {
                    if(lookahead != null) {
                        newLR_actions.put(intersection, new ReduceLookahead(prod, label, intersection, lookahead));
                    } else {
                        newLR_actions.put(intersection, new Reduce(prod, label, intersection));
                    }
                    final_range = final_range.difference(intersection);
                }
            }
        }

        lr_actions.putAll(newLR_actions);

        if(!final_range.isEmpty()) {
            if(lookahead != null) {
                lr_actions.put(final_range, new ReduceLookahead(prod, label, final_range, lookahead));
            } else {
                lr_actions.put(final_range, new Reduce(prod, label, final_range));
            }
        }
    }

    private void checkKernel(Set<LRItem> new_kernel, Set<Goto> new_gotos, Set<Shift> new_shifts) {
        if(pt.kernelMap().containsKey(new_kernel)) {
            int stateNumber = pt.kernelMap().get(new_kernel).getLabel();
            // set recently added shift and goto actions to new state
            for(Shift shift : new_shifts) {
                shift.setState(stateNumber);

                this.lr_actions.put(shift.cc, shift);
                // this.lr_actions.add(new LRAction(shift.cc, shift));
            }
            for(Goto g : new_gotos) {
                g.setState(stateNumber);
                this.gotos.add(g);
                this.gotosMapping.put(g.label, g);
            }
        } else {
            State new_state = new State(new_kernel, pt);
            for(Shift shift : new_shifts) {
                shift.setState(new_state.getLabel());
                this.lr_actions.put(shift.cc, shift);
                // this.lr_actions.add(new LRAction(shift.cc, shift));
            }
            for(Goto g : new_gotos) {
                g.setState(new_state.getLabel());
                this.gotos.add(g);
                this.gotosMapping.put(g.label, g);
            }
            pt.stateQueue().add(new_state);
        }
    }

    @Override public String toString() {
        String buf = "";
        int i = 0;
        buf += "State " + getLabel();
        if(!gotos.isEmpty()) {
            buf += "\nGotos: ";
        }
        for(IGoto g : gotos) {
            if(i != 0)
                buf += "\n     , ";
            buf += g;
            i++;
        }
        if(!lr_actions.isEmpty()) {
            buf += "\nActions: ";
        }
        i = 0;
        for(ICharacterClass cc : lr_actions.keySet()) {
            if(i != 0)
                buf += "\n       , ";
            buf += cc + ": ";
            int j = 0;
            for(IAction a : lr_actions.get(cc)) {
                if(j != 0)
                    buf += ", ";
                buf += a;
                j++;
            }
            i++;
        }
        if(!items.isEmpty()) {
            buf += "\nItems: ";

            i = 0;
            for(LRItem it : items) {
                if(i != 0)
                    buf += "\n       ";
                buf += it.toString();
                i++;
            }
        } else {
            buf += "\nItems: ";

            i = 0;
            for(LRItem it : kernel) {
                if(i != 0)
                    buf += "\n       ";
                buf += it.toString();
                i++;
            }
        }

        return buf;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kernel == null) ? 0 : kernel.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        if(kernel == null) {
            if(other.kernel != null)
                return false;
        } else if(!kernel.equals(other.kernel))
            return false;
        return true;
    }

    @Override public int compareTo(State o) {
        return this.getLabel() - o.getLabel();
    }

    public int getLabel() {
        return label;
    }

    public Set<LRItem> getKernel() {
        return kernel;
    }

    public Set<LRItem> getItems() {
        return items;
    }

    public StateStatus status() {
        return status;
    }

    public void setStatus(StateStatus status) {
        this.status = status;
    }

    public void markDirty() {
        this.items.clear();
        this.symbol_items.clear();
        this.lr_actions.clear();
        this.setStatus(StateStatus.DIRTY);
    }

    public Set<Goto> gotos() {
        return gotos;
    }

    @Override public Iterable<IAction> actions() {
        return org.metaborg.util.iterators.Iterables2.toHashSet(lr_actions.values());
    }

    public LinkedSetMultimap<ICharacterClass, Action> actionsMapping() {
        return lr_actions;
    }

    @Override public boolean isRejectable() {
        return rejectable;
    }

    public void markRejectable() {
        this.rejectable = true;
    }

    @Override public int id() {
        return label;
    }

    @Override public Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        return actionsForCharacter.getApplicableActions(actionQuery, parsingMode);
    }

    @Override public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        return actionsForCharacter.getApplicableReduceActions(actionQuery, parsingMode);
    }

    @Override
    public boolean hasGoto(int productionId) {
        return gotosMapping.containsKey(productionId);
    }

    @Override public int getGotoId(int productionId) {
        return gotosMapping.get(productionId).gotoStateId();
    }

    @Override public int getGotoId(int productionId, int defaultValue) {
        IGoto iGoto = gotosMapping.get(productionId);
        return iGoto == null ? defaultValue : iGoto.gotoStateId();
    }

    public void calculateActionsForCharacter() {
        // TODO: this should take into account which states only contain recovery reduces
        actionsForCharacter = new ActionsForCharacterDisjointSorted(readActions(), Collections.emptySet());
    }

    private ActionsPerCharacterClass[] readActions() {
        Set<ICharacterClass> characterClasses = lr_actions.keySet();

        ActionsPerCharacterClass[] actionsPerCharacterClasses = new ActionsPerCharacterClass[characterClasses.size()];

        int i = 0;
        for(ICharacterClass cc : characterClasses) {
            actionsPerCharacterClasses[i++] =
                new ActionsPerCharacterClass(cc, lr_actions.get(cc).toArray(new IAction[0]));
        }

        return actionsPerCharacterClasses;
    }


}
