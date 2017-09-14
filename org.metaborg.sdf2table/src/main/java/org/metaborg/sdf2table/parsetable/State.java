package org.metaborg.sdf2table.parsetable;

import java.util.Set;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.grammar.CharacterClassNumeric;
import org.metaborg.sdf2table.grammar.CharacterClassSeq;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Symbol;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class State implements Comparable<State> {

    IParseTable pt;

    private final int label;
    private Set<GoTo> gotos;
    private final Set<LRItem> kernel;
    private Set<LRItem> items;
    private SetMultimap<Symbol, LRItem> symbol_items;
    private SetMultimap<CharacterClass, Action> lr_actions;

    private StateStatus status = StateStatus.VISIBLE;

    public Set<State> states = Sets.newHashSet();

    public State(IProduction p, IParseTable pt) {
        items = Sets.newHashSet();
        gotos = Sets.newHashSet();
        kernel = Sets.newHashSet();
        symbol_items = HashMultimap.create();
        lr_actions = HashMultimap.create();

        this.pt = pt;
        label = this.pt.totalStates();
        this.pt.stateLabels().put(label, this);
        this.pt.incTotalStates();

        LRItem item = new LRItem(p, 0, pt);
        kernel.add(item);
        pt.kernelMap().put(kernel, this);


    }

    public State(Set<LRItem> kernel, IParseTable pt) {
        items = Sets.newHashSet();
        gotos = Sets.newHashSet();
        symbol_items = HashMultimap.create();
        lr_actions = HashMultimap.create();

        this.kernel = Sets.newHashSet();
        this.kernel.addAll(kernel);
        pt.kernelMap().put(kernel, this);

        this.pt = pt;
        label = this.pt.totalStates();
        this.pt.stateLabels().put(label, this);
        this.pt.incTotalStates();
    }

    public void closure() {
        for(LRItem item : kernel) {
//            if(item.getDotPosition() < item.getProd().rightHand().size()) {
//                pt.symbolStatesMapping().put(item.getProd().rightHand().get(item.getDotPosition()), this);
//            }
            item.process(items, symbol_items, this);
        }
    }

    public void doShift() {
        for(Symbol s_at_dot : symbol_items.keySet()) {
            if(s_at_dot instanceof CharacterClass) {
                Set<LRItem> new_kernel = Sets.newHashSet();
                Set<GoTo> new_gotos = Sets.newHashSet();
                Set<Shift> new_shifts = Sets.newHashSet();
                for(LRItem item : symbol_items.get(s_at_dot)) {
                    Shift shift = new Shift((CharacterClass) s_at_dot);
                    new_kernel.add(item.shiftDot());
                    if(!(item.getProd().equals(pt.initialProduction()) && item.getDotPosition() == 1)) {
                        new_shifts.add(shift);
                    }
                    new_gotos.add(new GoTo((CharacterClass) s_at_dot, pt));
                }
                if(!new_kernel.isEmpty()) {
                    checkKernel(new_kernel, new_gotos, new_shifts);
                }
            } else {

                // if s_at_dot is a contextual symbol A with a shallow context ctx
                // and it is the same symbol as the lhs of the context
                // remove the shallow context, expand with the original symbol except for the context production

                for(IProduction p : pt.normalizedGrammar().getSymbolProductionsMapping().get(s_at_dot)) {

                    // p might be a contextual production
                    if(pt.normalizedGrammar().getProdContextualProdMapping().get(p) != null) {
                        p = pt.normalizedGrammar().getProdContextualProdMapping().get(p);
                    }

                    Set<LRItem> new_kernel = Sets.newHashSet();
                    Set<GoTo> new_gotos = Sets.newHashSet();
                    Set<Shift> new_shifts = Sets.newHashSet();
                    for(LRItem item : symbol_items.get(s_at_dot)) {
                        // if item.prod does not conflict with p
                        if(!LRItem.isPriorityConflict(item, p, pt.normalizedGrammar().priorities())) {
                            new_kernel.add(item.shiftDot());
                            new_gotos.add(new GoTo(pt.productionLabels().get(p), pt));
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
        // add a reduce action reduce([0-256] / follow(A), p_i)
        for(LRItem item : items) {

            if(item.getDotPosition() == item.getProd().rightHand().size()) {
                int prod_label = pt.productionLabels().get(item.getProd());

                if(item.getProd().leftHand().followRestriction().isEmpty()) {
                    addReduceAction(item.getProd(), prod_label, CharacterClass.maxCC, null);
                } else {
                    CharacterClass final_range = CharacterClass.maxCC;
                    for(Symbol s : item.getProd().leftHand().followRestriction()) {
                        if(s instanceof CharacterClassSeq) {
                            Symbol cc_restriction = ((CharacterClassSeq) s).getHead();
                            Set<Symbol> lookahead_symbols = ((CharacterClassSeq) s).getTail();
                            CharacterClass[] lookahead_array = new CharacterClass[lookahead_symbols.size()];
                            int i = 0;
                            for(Symbol lookahead_symbol : lookahead_symbols) {
                                lookahead_array[i] = new CharacterClass(lookahead_symbol);
                                i++;
                            }
                            CharacterClass lookahead = CharacterClass.union(lookahead_array);
                            CharacterClass reduction_range =
                                CharacterClass.intersection(CharacterClass.maxCC, new CharacterClass(cc_restriction));
                            if(!reduction_range.equals(CharacterClass.emptyCC)) {
                                final_range = final_range.difference(reduction_range);
                                addReduceAction(item.getProd(), prod_label, reduction_range, lookahead);
                            }
                        } else {
                            final_range = final_range.difference(new CharacterClass(s));
                        }
                    }
                    addReduceAction(item.getProd(), prod_label, final_range, null);
                }
            }
            // <Start> = <START> . EOF
            if(item.getProd().equals(pt.initialProduction()) && item.getDotPosition() == 1) {
                lr_actions.put(new CharacterClass(new CharacterClassNumeric(256)), new Accept());
            }
        }
    }


    private void addReduceAction(IProduction prod, Integer label, CharacterClass cc, CharacterClass lookahead) {
        CharacterClass final_range = cc;

        for(CharacterClass range : lr_actions.keySet()) {
            if(final_range.equals(CharacterClass.emptyCC)) {
                break;
            }
            CharacterClass intersection = CharacterClass.intersection(final_range, range);
            if(!intersection.equals(CharacterClass.emptyCC)) {
                if(intersection.equals(range)) {
                    lr_actions.put(intersection, new Reduce(prod, label, range, lookahead));
                    final_range = final_range.difference(intersection);
                }
            }
        }

        if(!final_range.equals(CharacterClass.emptyCC)) {
            lr_actions.put(final_range, new Reduce(prod, label, final_range, lookahead));
        }
    }

    private void checkKernel(Set<LRItem> new_kernel, Set<GoTo> new_gotos, Set<Shift> new_shifts) {
        if(pt.kernelMap().containsKey(new_kernel)) {
            int stateNumber = pt.kernelMap().get(new_kernel).getLabel();
            // set recently added shift and goto actions to new state
            for(Shift shift : new_shifts) {
                shift.setState(stateNumber);

                this.lr_actions.put(shift.cc, shift);
                // this.lr_actions.add(new LRAction(shift.cc, shift));
            }
            for(GoTo g : new_gotos) {
                g.setState(stateNumber);
                this.gotos.add(g);
            }
        } else {
            State new_state = new State(new_kernel, pt);
            for(Shift shift : new_shifts) {
                shift.setState(new_state.getLabel());
                this.lr_actions.put(shift.cc, shift);
                // this.lr_actions.add(new LRAction(shift.cc, shift));
            }
            for(GoTo g : new_gotos) {
                g.setState(new_state.getLabel());
                this.gotos.add(g);
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
        for(GoTo g : gotos) {
            if(i != 0)
                buf += "\n     , ";
            buf += g;
            i++;
        }
        if(!lr_actions.isEmpty()) {
            buf += "\nActions: ";
        }
        i = 0;
        for(CharacterClass cc : lr_actions.keySet()) {
            if(i != 0)
                buf += "\n       , ";
            buf += cc + ": ";
            int j = 0;
            for(Action a : lr_actions.get(cc)) {
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

    public Set<LRItem> getItems() {
        return items;
    }

    public StateStatus status() {
        return status;
    }

    public void setStatus(StateStatus status) {
        this.status = status;
    }

    public SetMultimap<CharacterClass, Action> actions() {
        return lr_actions;
    }

    public Set<GoTo> gotos() {
        return gotos;
    }

    public void markDirty() {
        this.items.clear();
        this.symbol_items.clear();
        this.lr_actions.clear();
        this.setStatus(StateStatus.DIRTY);
    }


}
