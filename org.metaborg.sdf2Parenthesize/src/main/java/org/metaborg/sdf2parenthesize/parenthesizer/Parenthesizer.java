package org.metaborg.sdf2parenthesize.parenthesizer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.grammar.ConstructorAttribute;
import org.metaborg.sdf2table.grammar.ContextFreeSymbol;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IPriority;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.NormGrammar;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.parsetable.Context;
import org.metaborg.sdf2table.parsetable.ContextPosition;
import org.metaborg.sdf2table.parsetable.ContextType;
import org.metaborg.sdf2table.parsetable.ContextualProduction;
import org.metaborg.sdf2table.parsetable.ContextualSymbol;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.StrategoString;
import org.spoofax.terms.TermFactory;
import org.strategoxt.strc.pp_stratego_string_0_0;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class Parenthesizer {

    private static final ILogger logger = LoggerUtils.logger(Parenthesizer.class);
    private final static ITermFactory tf = new TermFactory();

    public static IStrategoTerm generateParenthesizer(String moduleName, File outputFile, NormGrammar grammar) {
        // add pp/
        final String name = moduleName;
        moduleName = "pp/" + moduleName + "-parenthesize";
        final String rule_name = name + "Parenthesize";

        // FIXME import all subfolders

        List<IStrategoTerm> importsList = Lists.newArrayList();
        importsList.add(importModule("libstratego-lib"));

        Set<String> paths = Sets.newHashSet();
        for(File f : grammar.getFilesRead()) {
            String path = f.getParent();
            if(path.split("/normalized/").length == 2) {
                String subfolder = path.split("/normalized/")[1];
                if(paths.contains(subfolder)) {
                    continue;
                }
                paths.add(subfolder);
                importsList.add(importModuleWildCard("signatures/" + subfolder));
            }
        }

        importsList.add(importModuleWildCard("signatures"));

        // Imports
        IStrategoTerm imports = tf.makeAppl(tf.makeConstructor("Imports", 1), tf.makeList(importsList));

        // Strategies
        IStrategoTerm ioStrategy = defineStrategy("io-" + name + "-parenthesize",
            createStrategoTermCall("io-wrap", createStrategoTermCall("parenthesize-" + name, null)));

        IStrategoTerm parenthesizeStrategy = defineStrategy("parenthesize-" + name,
            createStrategoTermCall("innermost", createStrategoTermCall(rule_name, null)));

        // Rules
        List<IStrategoTerm> shallowConflictRuleList = Lists.newArrayList();


        for(IProduction prod : grammar.getHigherPriorityProductions().keySet()) {
            String constructor = getConstructor(prod, grammar);
            if(constructor != null) {
                SetMultimap<Integer, IProduction> conflicts = HashMultimap.create();
                for(IPriority prio : grammar.getHigherPriorityProductions().get(prod)) {
                    for(Integer arg : grammar.priorities().get(prio)) {
                        if(arg != -1 && arg != Integer.MAX_VALUE && arg != Integer.MIN_VALUE) {
                            if(getConstructor(prio.lower(), grammar) != null) {
                                conflicts.put(arg, prio.lower());
                            }
                        }
                    }
                }
                for(Integer arg : conflicts.keySet()) {
                    // create stratego rule
                    // LangParenthesize :
                    // cons(arg0, ..., argN) -> cons(arg0, ..., Parenthetical(argX), ..., argN)
                    // where <(?ConflictingConstructor + fail)> argX

                    IStrategoTerm inputTerm =
                        tf.makeAppl(tf.makeConstructor("NoAnnoList", 1), createStrategoTermOp(constructor, prod));

                    IStrategoTerm outputTerm = tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
                        createStrategoParenthesizedTermOp(constructor, prod, normalizeArg(arg, prod)));

                    IStrategoTerm arg_term =
                        tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + normalizeArg(arg, prod)));
                    IStrategoTerm matches = createMatches(Queues.newArrayDeque(conflicts.get(arg)), grammar);

                    IStrategoTerm condition = tf.makeAppl(tf.makeConstructor("BA", 2), matches, arg_term);

                    IStrategoTerm ruleBody =
                        tf.makeAppl(tf.makeConstructor("Rule", 3), inputTerm, outputTerm, condition);
                    IStrategoTerm ruleDef = tf.makeAppl(tf.makeConstructor("RDefNoArgs", 2),
                        tf.makeString(name + "Parenthesize"), ruleBody);
                    shallowConflictRuleList.add(ruleDef);
                }
            }
        }


        List<IStrategoTerm> deepConflictRuleList = Lists.newArrayList();
        for(ContextualProduction prod : grammar.getProdContextualProdMapping().inverse().keySet()) {
            String constructor = getConstructor(prod.getOrigProduction(), grammar);
            if(constructor != null) {
                SetMultimap<Integer, IProduction> leftConflicts = HashMultimap.create();
                SetMultimap<Integer, IProduction> rightConflicts = HashMultimap.create();
                for(int i = 0; i < prod.rightHand().size(); i++) {
                    Symbol s = prod.rightHand().get(i);
                    if(s instanceof ContextualSymbol) {
                        for(Context ctx : ((ContextualSymbol) s).getContexts()) {
                            if(ctx.getType() == ContextType.DEEP
                                && (ctx.getPosition() == ContextPosition.LEFTANDRIGHTMOST
                                    || ctx.getPosition() == ContextPosition.LEFTMOST)
                                && getConstructor(ctx.getContext(), grammar) != null) {
                                leftConflicts.put(i, ctx.getContext());
                            }
                            if(ctx.getType() == ContextType.DEEP
                                && (ctx.getPosition() == ContextPosition.LEFTANDRIGHTMOST
                                    || ctx.getPosition() == ContextPosition.RIGHTMOST)
                                && getConstructor(ctx.getContext(), grammar) != null) {
                                rightConflicts.put(i, ctx.getContext());
                            }
                        }
                    }
                }

                for(Integer arg : leftConflicts.keySet()) {
                    IStrategoTerm inputTerm = tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
                        createStrategoTermOp(constructor, prod.getOrigProduction()));

                    IStrategoTerm outputTerm =
                        tf.makeAppl(tf.makeConstructor("NoAnnoList", 1), createStrategoTermOpResult(constructor,
                            prod.getOrigProduction(), normalizeArg(arg, prod.getOrigProduction())));

                    IStrategoTerm condition =
                        tf.makeAppl(
                            tf.makeConstructor("Assign",
                                2),
                            tf.makeAppl(
                                tf.makeConstructor("Var",
                                    1),
                                tf.makeString("t_" + normalizeArg(arg, prod.getOrigProduction()) + "'")),
                            tf.makeAppl(tf.makeConstructor("App", 2), tf.makeAppl(tf.makeConstructor("Choice", 2),
                                tf.makeAppl(tf.makeConstructor("Call", 2), tf.parseFromString("SVar(\"LeftContext\")"),
                                    tf.makeList(
                                        createMatchesNoFail(Queues.newArrayDeque(leftConflicts.get(arg)), grammar))),
                                tf.makeAppl(tf.makeConstructor("Fail", 0))),
                                tf.makeAppl(tf.makeConstructor("Var", 1),
                                    tf.makeString("t_" + normalizeArg(arg, prod.getOrigProduction())))));


                    IStrategoTerm ruleBody =
                        tf.makeAppl(tf.makeConstructor("Rule", 3), inputTerm, outputTerm, condition);

                    IStrategoTerm ruleDef = tf.makeAppl(tf.makeConstructor("RDefNoArgs", 2),
                        tf.makeString(name + "Parenthesize-deep"), ruleBody);

                    deepConflictRuleList.add(ruleDef);
                }

                for(Integer arg : rightConflicts.keySet()) {
                    IStrategoTerm inputTerm = tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
                        createStrategoTermOp(constructor, prod.getOrigProduction()));

                    IStrategoTerm outputTerm =
                        tf.makeAppl(tf.makeConstructor("NoAnnoList", 1), createStrategoTermOpResult(constructor,
                            prod.getOrigProduction(), normalizeArg(arg, prod.getOrigProduction())));

                    IStrategoTerm condition = tf.makeAppl(tf.makeConstructor("Assign", 2),
                        tf.makeAppl(tf.makeConstructor("Var", 1),
                            tf.makeString("t_" + normalizeArg(arg, prod.getOrigProduction()) + "'")),
                        tf.makeAppl(tf.makeConstructor("App", 2),
                            tf.makeAppl(
                                tf.makeConstructor("Choice", 2),
                                tf.makeAppl(tf.makeConstructor("Call", 2), tf.parseFromString("SVar(\"RightContext\")"),
                                    tf.makeList(
                                        createMatchesNoFail(Queues.newArrayDeque(rightConflicts.get(arg)), grammar))),
                                tf.makeAppl(tf.makeConstructor("Fail", 0))),
                            tf.makeAppl(tf.makeConstructor("Var", 1),
                                tf.makeString("t_" + normalizeArg(arg, prod.getOrigProduction())))));

                    IStrategoTerm ruleBody =
                        tf.makeAppl(tf.makeConstructor("Rule", 3), inputTerm, outputTerm, condition);

                    IStrategoTerm ruleDef = tf.makeAppl(tf.makeConstructor("RDefNoArgs", 2),
                        tf.makeString(name + "Parenthesize-deep"), ruleBody);

                    deepConflictRuleList.add(ruleDef);
                }

            }
        }



        if(shallowConflictRuleList.isEmpty()) {
            ioStrategy = defineStrategy("io-" + name + "-parenthesize",
                createStrategoTermCall("io-wrap", createStrategoTermId()));

            parenthesizeStrategy = defineStrategy("parenthesize-" + name, createStrategoTermId());
        }

        if(!deepConflictRuleList.isEmpty()) {
            parenthesizeStrategy = defineStrategy("parenthesize-" + name,
                tf.makeAppl(tf.makeConstructor("Seq", 2),
                    createStrategoTermCall("innermost", createStrategoTermCall(rule_name, null)),
                    createStrategoTermCall("innermost", createStrategoTermCall(rule_name + "-deep", null))));
        }

        // Signature Constructor
        IStrategoTerm signature = tf.makeAppl(tf.makeConstructor("Signature", 1),
            tf.makeList(tf.makeAppl(tf.makeConstructor("Constructors", 1),
                tf.makeList(defineSignature("Parenthetical", Lists.newArrayList("Unknown"), "Unknown")))));

        IStrategoTerm strategies =
            tf.makeAppl(tf.makeConstructor("Strategies", 1), tf.makeList(ioStrategy, parenthesizeStrategy));
        IStrategoTerm sections;
        if(shallowConflictRuleList.isEmpty()) {
            sections = tf.makeList(imports, strategies, signature);
        } else {
            IStrategoTerm shallowRules =
                tf.makeAppl(tf.makeConstructor("Rules", 1), tf.makeList(shallowConflictRuleList));
            if(deepConflictRuleList.isEmpty()) {
                sections = tf.makeList(imports, strategies, shallowRules, signature);
            } else {
                IStrategoTerm deepRules =
                    tf.makeAppl(tf.makeConstructor("Rules", 1), tf.makeList(deepConflictRuleList));
                sections = tf.makeList(imports, strategies, shallowRules, deepRules,
                    createStrategoTermCheckContextRules(), signature);
            }
        }

        IStrategoTerm result = tf.makeAppl(tf.makeConstructor("Module", 2), tf.makeString(moduleName), sections);

        if(outputFile != null) {
            outputToFile(prettyPrintStratego(result), outputFile);
        }


        return result;
    }

    private static IStrategoTerm importModule(String name) {
        return tf.makeAppl(tf.makeConstructor("Import", 1), tf.makeString(name));
    }

    private static IStrategoTerm importModuleWildCard(String name) {
        return tf.makeAppl(tf.makeConstructor("ImportWildcard", 1), tf.makeString(name));
    }

    private static IStrategoTerm defineStrategy(String name, IStrategoTerm term) {
        return tf.makeAppl(tf.makeConstructor("SDefNoArgs", 2), tf.makeString(name), term);
    }

    private static IStrategoTerm createMatches(Queue<IProduction> prods, NormGrammar grammar) {
        if(prods.isEmpty()) {
            return tf.makeAppl(tf.makeConstructor("Fail", 0));
        }
        IStrategoTerm match = createStrategoTermMatch(prods.poll(), grammar);
        return tf.makeAppl(tf.makeConstructor("Choice", 2), match, createMatches(prods, grammar));

    }

    private static IStrategoTerm createMatchesNoFail(Queue<IProduction> prods, NormGrammar grammar) {
        if(prods.size() == 1) {
            return createStrategoTermMatch(prods.poll(), grammar);
        }
        IStrategoTerm match = createStrategoTermMatch(prods.poll(), grammar);
        return tf.makeAppl(tf.makeConstructor("Choice", 2), match, createMatches(prods, grammar));
    }

    private static IStrategoTerm createStrategoTermMatch(IProduction prod, NormGrammar grammar) {
        return tf.makeAppl(tf.makeConstructor("Match", 1), tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            createStrategoTermOpWld(getConstructor(prod, grammar), prod)));
    }

    private static IStrategoTerm createStrategoParenthesizedTermOp(String constructor, IProduction prod, int arg) {
        return tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(constructor),
            createStrategoTermParenthesizedVars(prod, arg));
    }

    private static IStrategoTerm createStrategoTermParenthesizedVars(IProduction prod, int arg) {
        List<IStrategoTerm> vars = Lists.newArrayList();
        for(int i = 0; i < getArity(prod); i++) {
            if(i == arg) {
                vars.add(createStrategoTermParentheticalTerm(i));
            } else {
                vars.add(tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + i)));
            }
        }
        return tf.makeList(vars);
    }

    private static IStrategoTerm createStrategoTermParentheticalTerm(int arg) {
        return tf.makeAppl(tf.makeConstructor("NoAnnoList", 1),
            tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString("Parenthetical"),
                tf.makeList(tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + arg)))));
    }

    private static IStrategoTerm createStrategoTermOp(String constructor, IProduction prod) {
        return tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(constructor), createStrategoTermVars(prod));
    }

    private static IStrategoTerm createStrategoTermOpResult(String constructor, IProduction prod, Integer arg) {
        return tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(constructor),
            createStrategoTermVarsResult(prod, arg));
    }

    private static IStrategoTerm createStrategoTermVarsResult(IProduction prod, Integer arg) {
        List<IStrategoTerm> vars = Lists.newArrayList();
        for(int i = 0; i < getArity(prod); i++) {
            if(i == arg) {
                vars.add(tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + i + "'")));
            } else {
                vars.add(tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + i)));
            }
        }
        return tf.makeList(vars);
    }

    private static IStrategoTerm createStrategoTermVars(IProduction prod) {
        List<IStrategoTerm> vars = Lists.newArrayList();
        for(int i = 0; i < getArity(prod); i++) {
            vars.add(tf.makeAppl(tf.makeConstructor("Var", 1), tf.makeString("t_" + i)));
        }
        return tf.makeList(vars);
    }

    private static IStrategoTerm createStrategoTermOpWld(String constructor, IProduction prod) {
        if(constructor == null)
            System.out.println();
        return tf.makeAppl(tf.makeConstructor("Op", 2), tf.makeString(constructor), createStrategoTermVarsWld(prod));
    }

    private static IStrategoTerm createStrategoTermVarsWld(IProduction prod) {
        List<IStrategoTerm> vars = Lists.newArrayList();
        for(int i = 0; i < getArity(prod); i++) {
            vars.add(tf.makeAppl(tf.makeConstructor("Wld", 0)));
        }
        return tf.makeList(vars);
    }

    private static IStrategoTerm createStrategoTermCall(String name, IStrategoTerm args) {
        if(args == null) {
            return tf.makeAppl(tf.makeConstructor("CallNoArgs", 1), createStrategoTermSvar(name));
        }
        return tf.makeAppl(tf.makeConstructor("Call", 2), createStrategoTermSvar(name), tf.makeList(args));
    }

    private static IStrategoTerm createStrategoTermSvar(String name) {
        return tf.makeAppl(tf.makeConstructor("SVar", 1), tf.makeString(name));
    }

    private static IStrategoTerm createStrategoTermId() {
        return tf.makeAppl(tf.makeConstructor("Id", 0));
    }

    private static IStrategoTerm defineSignature(String cons, List<String> sorts, String sort) {
        return tf.makeAppl(tf.makeConstructor("OpDecl", 2), tf.makeString(cons),
            tf.makeAppl(tf.makeConstructor("FunType", 2), createStrategoTermConstTypeNoArgsList(sorts),
                createStrategoTermConstTypeNoArgs(sort)));
    }

    private static IStrategoTerm createStrategoTermConstTypeNoArgs(String sort) {
        return tf.makeAppl(tf.makeConstructor("ConstType", 1),
            tf.makeAppl(tf.makeConstructor("SortNoArgs", 1), tf.makeString(sort)));
    }

    private static IStrategoTerm createStrategoTermConstTypeNoArgsList(List<String> sorts) {
        List<IStrategoTerm> terms = Lists.newLinkedList();
        for(String sort : sorts) {
            terms.add(createStrategoTermConstTypeNoArgs(sort));
        }
        return tf.makeList(terms);
    }

    private static IStrategoTerm createStrategoTermCheckContextRules() {
        List<IStrategoTerm> checkContextRuleList = Lists.newArrayList();

        /* @formatter:off         
        
         RULE 1: 
         RightContext(s) :
            t@cons#(args*) -> cons#(args'*)
              where
                <not(?[])> cons;
                <not(?Parenthetical(_))> t;
                args'* := <at-last(RightContext(s) <+ fail)> args*
         
         @formatter:on */

        IStrategoTerm srcRightContext1 =
            tf.parseFromString("As(Var(\"t\"), NoAnnoList(Explode(Var(\"cons\"), Var(ListVar(\"args*\")))))");
        IStrategoTerm targetRightContext1 =
            tf.parseFromString("NoAnnoList(Explode(Var(\"cons\"), Var(ListVar(\"args'*\"))))");
        IStrategoTerm conditionRightContext1 = tf.makeAppl(tf.makeConstructor("Seq", 2),
            tf.parseFromString("BA(Not(Match(NoAnnoList(List([])))), Var(\"cons\"))"),
            tf.makeAppl(tf.makeConstructor("Seq", 2),
                tf.parseFromString("BA(Not(Match(NoAnnoList(Op(\"Parenthetical\", [Wld()])))), Var(\"t\"))"),
                tf.makeAppl(tf.makeConstructor("Assign", 2), tf.parseFromString("Var(ListVar(\"args'*\"))"),
                    tf.makeAppl(tf.makeConstructor("App", 2),
                        tf.parseFromString(
                            "Call(SVar(\"at-last\"), [LChoice(Call(SVar(\"RightContext\"), [CallNoArgs(SVar(\"s\"))]), Fail())])"),
                        tf.parseFromString("Var(ListVar(\"args*\"))")))));

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("RightContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("Rule", 3), srcRightContext1, targetRightContext1, conditionRightContext1)));

        /* @formatter:off   
        
        RULE 2:       
          RightContext(s) :
            [t] -> [<RightContext(s)> t]
        
        @formatter:on */

        IStrategoTerm srcRightContext2 = tf.parseFromString("NoAnnoList(List([Var(\"t\")]))");
        IStrategoTerm targetRightContext2 = tf.parseFromString(
            "NoAnnoList(List([App(Call(SVar(\"RightContext\"), [CallNoArgs(SVar(\"s\"))]),Var(\"t\"))]))");

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("RightContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("RuleNoCond", 2), srcRightContext2, targetRightContext2)));

        /* @formatter:off   
        
        RULE 3:       
          RightContext(s) :
            t -> Parenthetical(t)
              where <not(is-list)> t;
                    <s> t
        
         @formatter:on */

        IStrategoTerm srcRightContext3 = tf.parseFromString("Var(\"t\")");
        IStrategoTerm targetRightContext3 = tf.parseFromString("NoAnnoList(Op(\"Parenthetical\", [Var(\"t\")]))");
        IStrategoTerm conditionRightContext3 = tf.makeAppl(tf.makeConstructor("Seq", 2),
            tf.parseFromString("BA(Not(CallNoArgs(SVar(\"is-list\"))), Var(\"t\"))"),
            tf.parseFromString("BA(CallNoArgs(SVar(\"s\")), Var(\"t\"))"));

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("RightContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("Rule", 3), srcRightContext3, targetRightContext3, conditionRightContext3)));

        /* @formatter:off         
        
        RULE 1: 
        LeftContext(s) :
          t@cons#(args*) -> cons#(args'*)
            where
              <not(?[])> cons;
              <not(?Parenthetical(_))> t;
              head := <?[<(LeftContext(s) <+ fail)> | hs]> args*;
              args'* := [head | hs]
        
        @formatter:on */

        IStrategoTerm srcLeftContext1 =
            tf.parseFromString("As(Var(\"t\"), NoAnnoList(Explode(Var(\"cons\"), Var(ListVar(\"args*\")))))");
        IStrategoTerm targetLeftContext1 =
            tf.parseFromString("NoAnnoList(Explode(Var(\"cons\"), Var(ListVar(\"args'*\"))))");
        IStrategoTerm conditionLeftContext1 = tf.makeAppl(tf.makeConstructor("Seq", 2),
            tf.parseFromString("BA(Not(Match(NoAnnoList(List([])))), Var(\"cons\"))"),
            tf.makeAppl(tf.makeConstructor("Seq", 2),
                tf.parseFromString("BA(Not(Match(NoAnnoList(Op(\"Parenthetical\", [Wld()])))), Var(\"t\"))"),
                tf.makeAppl(tf.makeConstructor("Seq", 2),
                    tf.parseFromString(
                        "Assign(Var(\"head\"), App(Match(NoAnnoList(ListTail([RootApp(LChoice(Call(SVar(\"LeftContext\"), [CallNoArgs(SVar(\"s\"))]), Fail()))],Var(\"hs\")))),Var(ListVar(\"args*\"))))"),
                    tf.parseFromString(
                        "Assign(Var(ListVar(\"args'*\")), NoAnnoList(ListTail([Var(\"head\")], Var(\"hs\"))))"))));

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("LeftContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("Rule", 3), srcLeftContext1, targetLeftContext1, conditionLeftContext1)));

        /* @formatter:off   
       
       RULE 2:       
         LeftContext(s) :
           [t] -> [<LeftContext(s)> t]
       
       @formatter:on */

        IStrategoTerm srcLeftContext2 = tf.parseFromString("NoAnnoList(List([Var(\"t\")]))");
        IStrategoTerm targetLeftContext2 = tf.parseFromString(
            "NoAnnoList(List([App(Call(SVar(\"LeftContext\"), [CallNoArgs(SVar(\"s\"))]),Var(\"t\"))]))");

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("LeftContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("RuleNoCond", 2), srcLeftContext2, targetLeftContext2)));

        /* @formatter:off   
       
       RULE 3:       
         LeftContext(s) :
           t -> Parenthetical(t)
             where <not(is-list)> t;
                   <s> t
       
        @formatter:on */

        IStrategoTerm srcLeftContext3 = tf.parseFromString("Var(\"t\")");
        IStrategoTerm targetLeftContext3 = tf.parseFromString("NoAnnoList(Op(\"Parenthetical\", [Var(\"t\")]))");
        IStrategoTerm conditionLeftContext3 = tf.makeAppl(tf.makeConstructor("Seq", 2),
            tf.parseFromString("BA(Not(CallNoArgs(SVar(\"is-list\"))), Var(\"t\"))"),
            tf.parseFromString("BA(CallNoArgs(SVar(\"s\")), Var(\"t\"))"));

        checkContextRuleList.add(tf.makeAppl(tf.makeConstructor("RDef", 3), tf.makeString("LeftContext"),
            tf.parseFromString("[DefaultVarDec(\"s\")]"),
            tf.makeAppl(tf.makeConstructor("Rule", 3), srcLeftContext3, targetLeftContext3, conditionLeftContext3)));



        return tf.makeAppl(tf.makeConstructor("Rules", 1), tf.makeList(checkContextRuleList));
    }

    private static String getConstructor(IProduction prod, NormGrammar grammar) {
        for(IAttribute attr : grammar.getProductionAttributesMapping().get(prod)) {
            if(attr instanceof ConstructorAttribute) {
                return ((ConstructorAttribute) attr).getConstructor();
            }
        }
        return null;
    }

    private static Integer getArity(IProduction prod) {
        int arity = 0;
        for(Symbol s : prod.rightHand()) {
            if(s instanceof ContextFreeSymbol && !s.toString().equals("LAYOUT?-CF")) {
                arity++;
            }
        }
        return arity;
    }

    private static int normalizeArg(Integer arg, IProduction prod) {
        int normArg = 0;

        for(Symbol s : prod.rightHand()) {
            if(arg == 0) {
                return normArg;
            }

            if(s instanceof ContextFreeSymbol && !s.toString().equals("LAYOUT?-CF")) {
                normArg++;
            }
            arg--;
        }

        return 0;
    }

    private static void outputToFile(String outputString, File output) {
        if(output != null) {
            output.getParentFile().mkdirs();
            try {
                output.createNewFile();
                FileWriter out = null;
                out = new FileWriter(output);
                out.write(outputString);
                out.close();
            } catch(IOException e) {
                logger.error("Could not write parse table", e);
            }
        }

    }

    private static String prettyPrintStratego(IStrategoTerm term) {
        final org.strategoxt.lang.Context context = new org.strategoxt.lang.Context();
        org.strategoxt.strc.Main.init(context);

        IStrategoTerm termPP = pp_stratego_string_0_0.instance.invoke(context, term);

        if(termPP == null || termPP.getTermType() != IStrategoTerm.STRING)
            return "";

        return ((StrategoString) termPP).stringValue();
    }


}
