package org.metaborg.sdf2table.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Priorities.PosPriorityLevel;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.PriorityLevel.PosProduction;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoString;
import org.spoofax.terms.TermFactory;
import org.strategoxt.lang.Context;
import org.strategoxt.strc.pp_stratego_string_0_0;

import com.google.common.collect.Lists;

public class Parenthesizer {

    private static IStrategoTerm importModule(String name, TermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("Import", 1), tf.makeString(name));
    }

    private static IStrategoTerm importModuleWildCard(String name, TermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("ImportWildcard", 1), tf.makeString(name));
    }

    private static IStrategoTerm call(String name, TermFactory tf, IStrategoTerm args) {
        if(args == null) {
            return tf.makeAppl(tf.makeConstructor("CallNoArgs", 1), svar(name, tf));
        }
        return tf.makeAppl(tf.makeConstructor("Call", 2), svar(name, tf), tf.makeList(args));
    }

    private static IStrategoTerm defineStrategy(String name, TermFactory tf, IStrategoTerm term) {
        return tf.makeAppl(tf.makeConstructor("SDefNoArgs", 2), tf.makeString(name), term);
    }

    private static IStrategoTerm svar(String name, TermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("SVar", 1), tf.makeString(name));
    }

    private static IStrategoTerm var(String name, TermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString(name));
    }

    private static IStrategoTerm defineRule(String name, TermFactory tf, IStrategoTerm pre, IStrategoTerm post,
        IStrategoTerm matching, int pos) {
        if(pre == null || post == null || matching == null)
            return null;

        return tf.makeAppl(tf.makeConstructor("RDefNoArgs", 2), tf.makeString(name),
            tf.makeAppl(tf.makeConstructor("Rule", 3), pre, post,
                tf.makeAppl(tf.makeConstructor("BA", 2), matching, var("t_" + pos, tf))));
    }

    private static IStrategoTerm makeChoice(TermFactory tf, IStrategoTerm match, IStrategoTerm else_term) {
        return tf.makeAppl(tf.makeConstructor("Choice", 2), match, else_term);
    }

    private static IStrategoTerm makeSignature(TermFactory tf, String cons, List<String> sorts, String sort) {
        return tf.makeAppl(tf.makeConstructor("OpDecl", 2), tf.makeString(cons), tf.makeAppl(
            tf.makeConstructor("FunType", 2), makeConstTypeNoArgsList(tf, sorts), makeConstTypeNoArgs(tf, sort)));
    }

    private static IStrategoTerm makeConstTypeNoArgs(TermFactory tf, String sort) {
        return tf.makeAppl(tf.makeConstructor("ConstType", 1),
            tf.makeAppl(tf.makeConstructor("SortNoArgs", 1), tf.makeString(sort)));
    }

    private static IStrategoTerm makeConstTypeNoArgsList(TermFactory tf, List<String> sorts) {
        List<IStrategoTerm> terms = Lists.newLinkedList();
        for(String sort : sorts) {
            terms.add(makeConstTypeNoArgs(tf, sort));
        }
        return tf.makeList(terms);
    }

    private static IStrategoTerm match(TermFactory tf, SyntaxProduction prod) {
        if(prod.constructor() == null || prod.constructor().isEmpty())
            return null;

        int size = productionSize(prod);

        IStrategoTerm args[] = new IStrategoTerm[size];
        for(int i = 0; i < size; ++i) {
            args[i] = tf.makeAppl(tf.makeConstructor("Wld", 0));
        }

        return tf.makeAppl(tf.makeConstructor("Match", 1), tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(prod.constructor()), tf.makeList(args))));
    }

    private static IStrategoTerm source(TermFactory tf, SyntaxProduction prod) {
        if(prod.constructor() == null || prod.constructor().isEmpty())
            return null;

        int size = productionSize(prod);

        IStrategoTerm args[] = new IStrategoTerm[size];
        for(int i = 0; i < size; ++i) {
            args[i] = var("t_" + i, tf);
        }

        return tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(prod.constructor()), tf.makeList(args)));
    }

    private static IStrategoTerm parenthetical(TermFactory tf, IStrategoTerm var) {
        return tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString("Parenthetical"), tf.makeList(var)));

    }

    private static int productionSize(SyntaxProduction prod) {
        int size = 0;
        for(Symbol s : prod.symbols()) {
            if(s.type() == Symbol.Type.CONTEXT_FREE && !s.isLayout())
                ++size;
        }

        return size;
    }

    private static IStrategoTerm destination(TermFactory tf, SyntaxProduction prod, int pos) {
        if(prod.constructor() == null || prod.constructor().isEmpty())
            return null;

        int size = productionSize(prod);

        IStrategoTerm args[] = new IStrategoTerm[size];
        for(int i = 0; i < size; ++i) {
            args[i] = var("t_" + i, tf);
            if(pos < 0 || pos == i) {
                args[i] = parenthetical(tf, args[i]);
            }
        }
        
        return tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(prod.constructor()), tf.makeList(args)));
    }

    public static String prettyPrint(IStrategoTerm parenthesized) {
        final Context context = new Context();
        org.strategoxt.strc.Main.init(context);
        
        IStrategoTerm term = pp_stratego_string_0_0.instance.invoke(context, parenthesized);

        if(term == null || term.getTermType() != IStrategoTerm.STRING)
            return "";

        return ((StrategoString) term).stringValue();
    }

    public static IStrategoTerm parenthesize(Syntax grammar, String name, TermFactory tf) {
        final String module_name = "pp/" + name + "-parenthesize";
        final String rule_name = name + "Parenthesize";

        IStrategoList listOfImports =
            tf.makeList(importModule("libstratego-lib", tf), importModuleWildCard("signatures", tf));

        // Imports
        IStrategoTerm imports = tf.makeAppl(tf.makeConstructor("Imports", 1), tf.makeList(listOfImports));

        // Strategies
        IStrategoTerm strategies = tf.makeAppl(tf.makeConstructor("Strategies", 1),
            tf.makeList(tf.makeList(
                defineStrategy("io-" + name + "-parenthesize", tf,
                    call("io-wrap", tf, call("parenthesize-" + name, tf, null))),
                defineStrategy("parenthesize-" + name, tf, call("innermost", tf, call(rule_name, tf, null))))));

        // Rules
        List<IStrategoTerm> rule_list = new ArrayList<>();

        for(SyntaxProduction prod : grammar.productions()) {
            IStrategoTerm src = source(tf, prod);

            int pos = 0;
            for(int i = 0; i < prod.size(); ++i) {
                Symbol s = prod.symbol(i);

                if(s.type() == Symbol.Type.CONTEXT_FREE && !s.isLayout()) {
                    Set<SyntaxProduction> set = new HashSet<>();

                    IStrategoTerm pattern_matching = tf.makeAppl(tf.makeConstructor("Fail", 0));

                    for(PosPriorityLevel prio : prod.priorities().priorityLevels()) {
                        if(prio.position() < 0 || prio.position() == i) {
                            for(PriorityLevel l : prio.level().lowerLevels()) {

                                for(PosProduction pprod : l.productions()) {
                                    SyntaxProduction p = pprod.production();

                                    if(set.add(p)) {
                                        IStrategoTerm m = match(tf, p);

                                        if(m != null)
                                            pattern_matching = makeChoice(tf, m, pattern_matching);
                                    }
                                }
                            }
                        }
                    }

                    if(!pattern_matching.match(tf.makeAppl(tf.makeConstructor("Fail", 0)))) {
                        IStrategoTerm rule =
                            defineRule(rule_name, tf, src, destination(tf, prod, pos), pattern_matching, pos);

                        if(rule != null)
                            rule_list.add(rule);
                    }
                    ++pos;
                }
            }
        }

        IStrategoTerm rules = tf.makeAppl(tf.makeConstructor("Rules", 1), tf.makeList(tf.makeList(rule_list)));


        // Signature
        IStrategoTerm signature = tf.makeAppl(tf.makeConstructor("Signature", 1), tf.makeList(tf.makeList(tf.makeAppl(
            tf.makeConstructor("Constructors", 1),
            tf.makeList(tf.makeList(makeSignature(tf, "Parenthetical", Lists.newArrayList("Unknown"), "Unknown")))))));


        return tf.makeAppl(tf.makeConstructor("Module", 2), tf.makeString(module_name),
            tf.makeList(imports, strategies, rules, signature));
    }
}
