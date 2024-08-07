package org.metaborg.parsetable;

import static org.spoofax.terms.util.TermUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.metaborg.parsetable.actions.*;
import org.metaborg.parsetable.characterclasses.CharacterClassReader;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.productions.Production;
import org.metaborg.parsetable.productions.ProductionReader;
import org.metaborg.parsetable.productions.ProductionType;
import org.metaborg.parsetable.query.ActionsPerCharacterClass;
import org.metaborg.parsetable.states.IMutableState;
import org.metaborg.parsetable.states.IStateFactory;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoNamed;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class ParseTableReaderDelegate {

    private final IActionsFactory actionsFactory;
    private final IStateFactory stateFactory;

    private final CharacterClassReader characterClassReader;
    private final ProductionReader productionReader;

    ParseTableReaderDelegate(IActionsFactory actionsFactory, IStateFactory stateFactory,
        CharacterClassReader characterClassReader, ProductionReader productionReader) {
        this.actionsFactory = actionsFactory;
        this.stateFactory = stateFactory;
        this.characterClassReader = characterClassReader;
        this.productionReader = productionReader;
    }

    /*
     * Reads a parse table from a term. The format consists of a tuple of 5: (1) version number (checked outside
     * delegate), (2) start state id, (3) list of productions (i.e. labels), (4) list of states and (5) list of
     * priorities (not used since priorities are now encoded in the parse table itself during parser generation and do
     * not have to be implemented separately during parsing).
     */
    public IParseTable read(IStrategoTerm pt) throws ParseTableReadException {
        int startStateId = toJavaIntAt(pt, 1);
        IStrategoList productionsTermList = toListAt(pt, 2);
        IStrategoList statesTermList = toListAt(pt.getSubterm(3), 0);

        IProduction[] productions = readProductions(productionsTermList);

        IMutableState[] states = readStates(statesTermList, productions);

        markRejectableStates(states);

        return new ParseTable(states, startStateId, productionsToList(productions),
            hasLayoutConstraint(productionsTermList));
    }

    private List<IProduction> productionsToList(IProduction[] productions) {
        return Arrays.asList(Arrays.copyOfRange(productions, 257, productions.length));
    }

    private boolean hasLayoutConstraint(IStrategoList productionsTermList) {
        // FIXME is there a better way to check for layout constraints in the parse table?
        return productionsTermList.toString().contains("term(layout(");
    }

    private IProduction[] readProductions(IStrategoList productionsTermList) throws ParseTableReadException {
        int productionCount = productionsTermList.getSubtermCount();

        IProduction[] productions = new Production[257 + productionCount];

        for(IStrategoTerm productionWithIdTerm : productionsTermList) {
            IProduction production = productionReader.read(productionWithIdTerm);

            productions[production.id()] = production;
        }

        return productions;
    }

    private IMutableState[] readStates(IStrategoList statesTermList, IProduction[] productions)
        throws ParseTableReadException {
        int stateCount = statesTermList.getSubtermCount();

        IGoto[][] stateGotos = new IGoto[stateCount][];
        ActionsPerCharacterClass[][] stateActions = new ActionsPerCharacterClass[stateCount][];

        for(IStrategoTerm stateTerm : statesTermList) {
            IStrategoNamed stateTermNamed = (IStrategoNamed) stateTerm;

            int stateId = toJavaIntAt(stateTermNamed, 0);

            IStrategoList gotosTermList = toListAt(stateTermNamed, 1);
            IStrategoList actionsTermList = toListAt(stateTermNamed, 2);

            stateGotos[stateId] = readGotos(gotosTermList);
            stateActions[stateId] = readActions(actionsTermList, productions);
        }

        Set<Integer> recoveryStateIds = IntStream.range(0, stateCount)
            .filter(stateId -> containsOnlyRecoveryReduces(stateActions[stateId])).boxed().collect(Collectors.toSet());

        IMutableState[] states = new IMutableState[stateCount];

        for(int stateId = 0; stateId < stateCount; stateId++) {
            states[stateId] = stateFactory.from(stateId, stateGotos[stateId], stateActions[stateId], recoveryStateIds);
        }

        return states;
    }

    static boolean containsOnlyRecoveryReduces(ActionsPerCharacterClass[] actions) {
        return Arrays.stream(actions)
            .allMatch(actionsPerCharacterClass -> actionsPerCharacterClass.actions.stream()
                .allMatch(action -> (action.actionType() == ActionType.REDUCE
                    || action.actionType() == ActionType.REDUCE_LOOKAHEAD)
                    && ((IReduce) action).production().isRecovery()));
    }

    private IGoto[] readGotos(IStrategoList gotosTermList) {
        int gotoCount = gotosTermList.size();

        IGoto[] gotos = new IGoto[gotoCount];

        int i = 0;
        for(IStrategoTerm subterm : gotosTermList) {
            IStrategoNamed gotoTermNamed = (IStrategoNamed) subterm;

            IStrategoList productionsTermList = toListAt(gotoTermNamed, 0);
            int[] productionIds = readGotoProductions(productionsTermList);

            int gotoStateId = toJavaIntAt(gotoTermNamed, 1);

            gotos[i++] = new Goto(productionIds, gotoStateId);
        }

        return gotos;
    }

    private int[] readGotoProductions(IStrategoList productionsTermList) {
        int productionCount = productionsTermList.size();

        int[] productionIds = new int[productionCount];

        int i = 0;
        for(IStrategoTerm productionIdsTerm : productionsTermList) {

            if(isInt(productionIdsTerm)) {
                int productionId = toJavaInt(productionIdsTerm);

                productionIds[i++] = productionId;
            }

            // productionIdsTerm can also be a range representing character classes. That is a remainder of parse
            // table generation (representing transitions between states). We can ignore them here since parsing only
            // looks up gotos after a reduction and than uses the production that is used for the reduction the retrieve
            // the goto action, not a character.
        }

        return productionIds;
    }

    private ActionsPerCharacterClass[] readActions(IStrategoList characterClassActionsTermList,
        IProduction[] productions) throws ParseTableReadException {
        int characterClassesWithActionsCount = characterClassActionsTermList.size();

        List<ActionsPerCharacterClass> actionsPerCharacterClasses = new ArrayList<>(characterClassesWithActionsCount);

        for(IStrategoTerm characterClassActionsTerm : characterClassActionsTermList) {
            IStrategoNamed characterClassActionsTermNamed = (IStrategoNamed) characterClassActionsTerm;

            IStrategoList characterClassTermList = toListAt(characterClassActionsTermNamed, 0);
            IStrategoList actionsTermList = toListAt(characterClassActionsTermNamed, 1);

            ICharacterClass characterClass = characterClassReader.read(characterClassTermList);
            IAction[] actions = readActionsForCharacterClass(actionsTermList, productions);

            actionsPerCharacterClasses.add(new ActionsPerCharacterClass(characterClass, actions));
        }

        return actionsPerCharacterClasses.toArray(new ActionsPerCharacterClass[0]);
    }

    private IAction[] readActionsForCharacterClass(IStrategoList actionsTermList, IProduction[] productions)
        throws ParseTableReadException {
        int actionCount = actionsTermList.size();

        IAction[] actions = new IAction[actionCount];

        int i = 0;
        for(IStrategoTerm subterm : actionsTermList) {
            IStrategoAppl actionTermAppl = (IStrategoAppl) subterm;
            IAction action = null;

            if(actionTermAppl.getName().equals("reduce")) { // Reduce
                int arity = toJavaIntAt(actionTermAppl, 0);
                int productionId = toJavaIntAt(actionTermAppl, 1);
                ProductionType productionType = Production.typeFromInt(toJavaIntAt(actionTermAppl, 2));

                IProduction production = productions[productionId];

                if(actionTermAppl.getConstructor().getArity() == 3) { // Reduce without lookahead
                    action = actionsFactory.getReduce(production, productionType, arity);
                } else if(actionTermAppl.getConstructor().getArity() == 4) { // Reduce with lookahead
                    ICharacterClass[] followRestriction =
                        readReduceLookaheadFollowRestriction(actionTermAppl.getSubterm(3).getSubterm(0));

                    action = actionsFactory.getReduceLookahead(production, productionType, arity, followRestriction);
                }
            } else if(actionTermAppl.getName().equals("accept")) { // Accept
                action = actionsFactory.getAccept();
            } else if(actionTermAppl.getName().equals("shift")) { // Shift
                int shiftStateId = toJavaIntAt(actionTermAppl, 0);

                action = actionsFactory.getShift(shiftStateId);
            } else {
                throw new IllegalStateException("invalid action type");
            }

            actions[i++] = action;
        }

        return actions;
    }

    private ICharacterClass[] readReduceLookaheadFollowRestriction(IStrategoTerm followRestrictionTerm)
        throws ParseTableReadException {
        if("follow-restriction".equals(((IStrategoNamed) followRestrictionTerm).getName())) {
            IStrategoList followRestrictionCharacterClassList = toListAt(followRestrictionTerm, 0);

            int lookaheadLength = followRestrictionCharacterClassList.size();

            // The length of this list equals the length of the lookahead
            ICharacterClass[] followRestrictionCharacterClasses = new ICharacterClass[lookaheadLength];

            int i = 0;
            for(IStrategoTerm characterClassTerm : followRestrictionCharacterClassList) {
                followRestrictionCharacterClasses[i++] =
                    characterClassReader.read((IStrategoList) characterClassTerm.getSubterm(0));
            }

            return followRestrictionCharacterClasses;
        } else
            throw new ParseTableReadException("invalid follow restriction");
    }

    // Mark states that are reachable by a reject production as rejectable. "Reachable" means the parser could
    // transition into such state by means of a goto action after reducing a production.
    public static void markRejectableStates(IMutableState[] states) {
        final Set<Integer> rejectProductionIds =
            Stream.of(states).filter(Objects::nonNull)
                .flatMap(state -> StreamSupport.stream(state.actions().spliterator(), false))
                .filter(ParseTableReaderDelegate::isReduceOrReduceLookahead).map(IReduce.class::cast).filter(IReduce::isRejectProduction)
                .map(IReduce::production).map(IProduction::id).collect(Collectors.toSet());

        final Set<Integer> rejectableStateIds =
            Stream.of(states).filter(Objects::nonNull)
                .flatMap(state -> rejectProductionIds.stream().filter(state::hasGoto).map(state::getGotoId))
                .collect(Collectors.toSet());

        // A state is marked as rejectable if it is reachable by at least one reject production.
        rejectableStateIds.forEach(gotoId -> states[gotoId].markRejectable());
    }

    private static boolean isReduceOrReduceLookahead(IAction action) {
        return action.actionType() == ActionType.REDUCE || action.actionType() == ActionType.REDUCE_LOOKAHEAD;
    }

}
