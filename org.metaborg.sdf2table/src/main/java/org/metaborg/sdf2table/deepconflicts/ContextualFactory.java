package org.metaborg.sdf2table.deepconflicts;

import java.io.Serializable;
import java.util.*;

import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.parsetable.ParseTable;

public class ContextualFactory implements Serializable {

    private static final long serialVersionUID = -5796688665070378982L;

    private final Map<ContextKey, Context> contexts;
    private final Map<ContextualProductionKey, ContextualProduction> contextualProductions;
    private final Map<ContextualSymbolKey, ContextualSymbol> contextualSymbols;

    public ContextualFactory() {
        contexts = new HashMap<>();
        contextualProductions = new HashMap<>();
        contextualSymbols = new HashMap<>();
    }

    public Context createContext(int c, ContextType type, ContextPosition position,
        final Map<Integer, Integer> leftmostContextsMapping, final Map<Integer, Integer> rightmostContextsMapping) {
        ContextKey contextFields =
            new ContextKey(c, type, position, leftmostContextsMapping, rightmostContextsMapping);

        if(contexts.containsKey(contextFields)) {
            return contexts.get(contextFields);
        }

        Context context = new Context(c, type, position, leftmostContextsMapping, rightmostContextsMapping);
        contexts.put(contextFields, context);

        return context;
    }

    public ContextualProduction createContextualProduction(Production origProduction, ISymbol lhs, List<ISymbol> rhs,
        int origProductionLabel, ContextualFactory cf) {
        ContextualProductionKey contextualProductionFields = new ContextualProductionKey(origProduction, lhs, origProductionLabel, cf, rhs);

        if(contextualProductions.containsKey(contextualProductionFields)) {
            return contextualProductions.get(contextualProductionFields);
        }

        ContextualProduction cp = new ContextualProduction(origProduction, lhs, rhs, origProductionLabel, cf);
        contextualProductions.put(contextualProductionFields, cp);

        return cp;
    }

    public ContextualProduction createContextualProduction(Production origProduction, Set<Context> contexts,
        Set<Integer> args, int origProductionLabel, ContextualFactory cf) {
        List<ISymbol> rhs = new ArrayList<>();

        for(int i = 0; i < origProduction.arity(); i++) {
            if(args.contains(i)) {
                rhs.add(createContextualSymbol(origProduction.getRhs().get(i), contexts, this));
            } else {
                rhs.add(origProduction.rightHand().get(i));
            }
        }

        return this.createContextualProduction(origProduction, origProduction.leftHand(), rhs, origProductionLabel, cf);
    }

    public ContextualProduction createContextualProduction(Production origProduction, Set<Context> contexts,
        Queue<ContextualSymbol> contextualSymbols, Set<ContextualSymbol> processedSymbols, int origProductionLabel,
        ParseTable pt) {
        ISymbol lhs = createContextualSymbol(origProduction.getLhs(), contexts, this);
        List<ISymbol> rhs = new ArrayList<>(origProduction.getRhs());


        // FIXME propagate context considering nullable symbols
        for(Context c : contexts) {
            if(c.getType() == ContextType.DEEP) {
                ISymbol nonTerminalContext = pt.productionLabels().inverse().get(c.getContext()).leftHand();

                // verify all symbols in rhs to consider leftRecursivePosition() or rightRecursivePosition()
                // that are not 0 or |rhs|
                for(int i = 0; i < origProduction.arity(); i++) {
                    /*
                     * if Ctx (B.C) is leftmost and X1 =*> B ... then new_X1 = {Ctx}X1
                     * 
                     * if Ctx (B.C) is rightmost and XN =*> ... B then new_XN = XN{Ctx}
                     */
                    if((i == 0 && c.getPosition().equals(ContextPosition.LEFTMOST)
                        && pt.normalizedGrammar().getLeftDerivable().get(origProduction.rightHand().get(i)).contains(nonTerminalContext))
                        || (i == origProduction.arity() - 1 && c.getPosition().equals(ContextPosition.RIGHTMOST) && pt
                            .normalizedGrammar().getRightDerivable().get(origProduction.rightHand().get(i)).contains(nonTerminalContext))) {
                        ContextualSymbol newSymbol;
                        if(rhs.get(i) instanceof ContextualSymbol) {
                            newSymbol = ((ContextualSymbol) rhs.get(i)).addContext(c);
                        } else {
                            newSymbol = createContextualSymbol((Symbol) rhs.get(i), c, this);
                        }
                        rhs.set(i, newSymbol);
                    }
                }
            } else if(c.getType() == ContextType.DANGLING) {
                // verify all symbols in rhs to consider leftRecursivePosition() or rightRecursivePosition()
                // that are not 0 or |rhs|
                for(int i = 0; i < origProduction.arity(); i++) {
                    if((i == 0 && i == origProduction.leftRecursivePosition())
                        || (i == origProduction.arity() - 1 && i == origProduction.rightRecursivePosition())) {
                        ContextualSymbol newSymbol;
                        if(rhs.get(i) instanceof ContextualSymbol) {
                            newSymbol = ((ContextualSymbol) rhs.get(i)).addContext(c);
                        } else {
                            newSymbol = createContextualSymbol((Symbol) rhs.get(i), c, this);
                        }
                        rhs.set(i, newSymbol);
                    }
                }

            }

        }

        for(ISymbol s : rhs) {
            if(s instanceof ContextualSymbol) {
                ContextualSymbol new_symbol = (ContextualSymbol) s;
                // need to process new contextual symbols
                if((contextualSymbols != null && processedSymbols != null) && !processedSymbols.contains(new_symbol)
                    && !contextualSymbols.contains(new_symbol)) {
                    contextualSymbols.add(new_symbol);
                }
            }
        }

        ContextualProductionKey contextualProductionFields = new ContextualProductionKey(origProduction, lhs, origProductionLabel, this, rhs);

        if(contextualProductions.containsKey(contextualProductionFields)) {
            return contextualProductions.get(contextualProductionFields);
        }

        ContextualProduction cp = new ContextualProduction(origProduction, lhs, rhs, origProductionLabel, this);
        contextualProductions.put(contextualProductionFields, cp);

        return cp;
    }

    public ContextualSymbol createContextualSymbol(Symbol s, Set<Context> contexts, ContextualFactory cf) {
        // use Set instead of List to account for the Set<Contexts>
        ContextualSymbolKey contextualSymbolFields = new ContextualSymbolKey(Collections.singleton(s), contexts);

        if(contextualSymbols.containsKey(contextualSymbolFields)) {
            ContextualSymbol cs = contextualSymbols.get(contextualSymbolFields);

            for(Context context : contexts) {
                if(context.getType() == ContextType.DEEP || context.getType() == ContextType.DANGLING) {
                    cs.setDeepContextBitmap(cs.deepContexts() | context.getContextBitmap());
                }
            }
            return cs;
        }

        ContextualSymbol cs = new ContextualSymbol(s, contexts, this);
        contextualSymbols.put(contextualSymbolFields, cs);

        return cs;
    }

    public ContextualSymbol createContextualSymbol(Symbol s, Context context, ContextualFactory cf) {
        // use Set instead of List to account for the Set<Contexts>
        ContextualSymbolKey contextualSymbolFields = new ContextualSymbolKey(Collections.singleton(s), Collections.singleton(context));

        if(contextualSymbols.containsKey(contextualSymbolFields)) {
            ContextualSymbol cs = contextualSymbols.get(contextualSymbolFields);
            cs.setDeepContextBitmap(cs.deepContexts() | context.getContextBitmap());
            return contextualSymbols.get(contextualSymbolFields);
        }

        ContextualSymbol cs = new ContextualSymbol(s, context, this);
        contextualSymbols.put(contextualSymbolFields, cs);

        return cs;
    }

    public ContextualSymbol createContextualSymbol(Symbol s, Set<Context> contexts, long deepContextBitmap,
        ContextualFactory cf) {
        ContextualSymbolKey contextualSymbolFields = new ContextualSymbolKey(Collections.singleton(s), contexts);

        if(contextualSymbols.containsKey(contextualSymbolFields)) {
            ContextualSymbol cs = contextualSymbols.get(contextualSymbolFields);
            cs.setDeepContextBitmap(deepContextBitmap);
            return contextualSymbols.get(contextualSymbolFields);
        }

        ContextualSymbol cs = new ContextualSymbol(s, contexts, deepContextBitmap, this);
        contextualSymbols.put(contextualSymbolFields, cs);

        return cs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContextualFactory that = (ContextualFactory) o;
        return Objects.equals(contexts, that.contexts) && Objects.equals(contextualProductions, that.contextualProductions) && Objects.equals(contextualSymbols, that.contextualSymbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contexts, contextualProductions, contextualSymbols);
    }

    private static final class ContextKey {
        private final int c;
        private final ContextType type;
        private final ContextPosition position;
        private final Map<Integer, Integer> leftmostContextsMapping;
        private final Map<Integer, Integer> rightmostContextsMapping;

        public ContextKey(int c, ContextType type, ContextPosition position, Map<Integer, Integer> leftmostContextsMapping, Map<Integer, Integer> rightmostContextsMapping) {
            this.c = c;
            this.type = type;
            this.position = position;
            this.leftmostContextsMapping = leftmostContextsMapping;
            this.rightmostContextsMapping = rightmostContextsMapping;
        }

        @Override
        public String toString() {
            return "ContextKey{" +
                    "c=" + c +
                    ", type=" + type +
                    ", position=" + position +
                    ", leftmostContextsMapping=" + leftmostContextsMapping +
                    ", rightmostContextsMapping=" + rightmostContextsMapping +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContextKey that = (ContextKey) o;
            return c == that.c && type == that.type && position == that.position && Objects.equals(leftmostContextsMapping, that.leftmostContextsMapping) && Objects.equals(rightmostContextsMapping, that.rightmostContextsMapping);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, type, position, leftmostContextsMapping, rightmostContextsMapping);
        }
    }

    private static final class ContextualProductionKey {
        private final Production origProduction;
        private final ISymbol lhs;
        private final int origProductionLabel;
        private final ContextualFactory cf;
        private final List<ISymbol> rhs;

        public ContextualProductionKey(Production origProduction, ISymbol lhs, int origProductionLabel, ContextualFactory cf, List<ISymbol> rhs) {
            this.origProduction = origProduction;
            this.lhs = lhs;
            this.origProductionLabel = origProductionLabel;
            this.cf = cf;
            this.rhs = rhs;
        }

        @Override
        public String toString() {
            return "ContextualContextKey{" +
                    "origProduction=" + origProduction +
                    ", lhs=" + lhs +
                    ", origProductionLabel=" + origProductionLabel +
                    ", cf=" + cf +
                    ", rhs=" + rhs +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContextualProductionKey that = (ContextualProductionKey) o;
            return origProductionLabel == that.origProductionLabel && Objects.equals(origProduction, that.origProduction) && Objects.equals(lhs, that.lhs) && cf == that.cf && Objects.equals(rhs, that.rhs);
        }

        @Override
        public int hashCode() {
            return Objects.hash(origProduction, lhs, origProductionLabel, System.identityHashCode(cf), rhs);
        }
    }

    private static final class ContextualSymbolKey {
        private final Set<Symbol> es;
        private final Set<Context> contexts;

        public ContextualSymbolKey(Set<Symbol> es, Set<Context> contexts) {
            this.es = es;
            this.contexts = contexts;
        }

        @Override
        public String toString() {
            return "ContextualSymbolKey{" +
                    "es=" + es +
                    ", contexts=" + contexts +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContextualSymbolKey that = (ContextualSymbolKey) o;
            return Objects.equals(es, that.es) && Objects.equals(contexts, that.contexts);
        }

        @Override
        public int hashCode() {
            return Objects.hash(es, contexts);
        }
    }
}
