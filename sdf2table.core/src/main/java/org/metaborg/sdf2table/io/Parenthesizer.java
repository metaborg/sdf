package org.metaborg.sdf2table.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Priorities.PosPriorityLevel;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.PriorityLevel.PosProduction;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoString;
import org.strategoxt.lang.Context;
import org.strategoxt.strc.pp_stratego_string_0_0;

public class Parenthesizer{
	static final StrategoConstructor CONS_MODULE = new StrategoConstructor("Module", 2);
	static final StrategoConstructor CONS_IMPORTS = new StrategoConstructor("Imports", 1);
	static final StrategoConstructor CONS_IMPORT = new StrategoConstructor("Import", 1);
	static final StrategoConstructor CONS_STRATEGIES = new StrategoConstructor("Strategies", 1);
	static final StrategoConstructor CONS_SDEFNOARGS = new StrategoConstructor("SDefNoArgs", 2);
	static final StrategoConstructor CONS_CALL = new StrategoConstructor("Call", 2);
	static final StrategoConstructor CONS_CALLNOARGS = new StrategoConstructor("CallNoArgs", 1);
	static final StrategoConstructor CONS_SVAR = new StrategoConstructor("SVar", 1);
	static final StrategoConstructor CONS_RULES = new StrategoConstructor("Rules", 1);
	static final StrategoConstructor CONS_RDEFNOARGS = new StrategoConstructor("RDefNoArgs", 2);
	static final StrategoConstructor CONS_RULE = new StrategoConstructor("Rule", 1);
	static final StrategoConstructor CONS_CHOICE = new StrategoConstructor("Choice", 2);
	static final StrategoConstructor CONS_MATCH = new StrategoConstructor("Match", 1);
	static final StrategoConstructor CONS_NOANNOLIST = new StrategoConstructor("NoAnnoList", 1);
	static final StrategoConstructor CONS_OP = new StrategoConstructor("Op", 2);
	static final StrategoConstructor CONS_VAR = new StrategoConstructor("Var", 1);
	static final StrategoConstructor CONS_BA = new StrategoConstructor("BA", 2);
	static final StrategoConstructor CONS_WLD = new StrategoConstructor("Wld", 0);
	static final StrategoConstructor CONS_FAIL = new StrategoConstructor("Fail", 0);
	static final StrategoConstructor CONS_SIGNATURE = new StrategoConstructor("Signature", 1);
	
	static final StrategoAppl APPL_WLD = new StrategoAppl(
			CONS_WLD,
			new IStrategoTerm[]{},
			null,
			0
	);
	
	static final StrategoAppl APPL_FAIL = new StrategoAppl(
			CONS_FAIL,
			new IStrategoTerm[]{},
			null,
			0
	);
	
	private static IStrategoTerm importModule(String name){
		return new StrategoAppl(
				CONS_IMPORT,
				new IStrategoTerm[]{
						new StrategoString(name, null, 0)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm call(String name, IStrategoTerm ...args){
		if(args.length == 0){
			return new StrategoAppl(
					CONS_CALLNOARGS,
					new IStrategoTerm[]{
							svar(name)
					},
					null,
					0
			);
		}
		return new StrategoAppl(
				CONS_CALL,
				new IStrategoTerm[]{
						svar(name),
						Utilities.strategoListFromArray(args)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm defineStrategy(String name, IStrategoTerm term){
		return new StrategoAppl(
				CONS_SDEFNOARGS,
				new IStrategoTerm[]{
						new StrategoString(name, null, 0),
						term
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm svar(String name){
		return new StrategoAppl(
				CONS_SVAR,
				new IStrategoTerm[]{
						new StrategoString(name, null, 0)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm var(String name){
		return new StrategoAppl(
				CONS_VAR,
				new IStrategoTerm[]{
						new StrategoString(name, null, 0)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm defineRule(String name, IStrategoTerm pre, IStrategoTerm post, IStrategoTerm matching, int pos){
		if(pre == null || post == null || matching == null)
			return null;
		
		return new StrategoAppl(
				CONS_RDEFNOARGS,
				new IStrategoTerm[]{
						new StrategoString(name, null, 0),
						new StrategoAppl(
								CONS_RULE,
								new IStrategoTerm[]{
										pre,
										post,
										new StrategoAppl(
												CONS_BA,
												new IStrategoTerm[]{
														matching,
														var("t_"+pos)
												},
												null,
												0
										)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm makeChoice(IStrategoTerm match, IStrategoTerm else_term){
		return new StrategoAppl(
				CONS_CHOICE,
				new IStrategoTerm[]{
						match,
						else_term
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm match(SyntaxProduction prod){
		if(prod.constructor() == null || prod.constructor().isEmpty())
			return null;
		
		int size = productionSize(prod);
		
		IStrategoTerm args[] = new IStrategoTerm[size];
		for(int i = 0; i < size; ++i){
			args[i] = APPL_WLD;
		}
		
		return new StrategoAppl(
				CONS_MATCH,
				new IStrategoTerm[]{
						new StrategoAppl(
								CONS_NOANNOLIST,
								new IStrategoTerm[]{
										new StrategoAppl(
												CONS_OP,
												new IStrategoTerm[]{
														new StrategoString(prod.constructor(), null, 0),
														Utilities.strategoListFromArray(args)
												},
												null,
												0
										)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm source(SyntaxProduction prod){
		if(prod.constructor() == null || prod.constructor().isEmpty())
			return null;
		
		int size = productionSize(prod);
		
		IStrategoTerm args[] = new IStrategoTerm[size];
		for(int i = 0; i < size; ++i){
			args[i] = var("t_"+i);
		}
		
		return new StrategoAppl(
				CONS_NOANNOLIST,
				new IStrategoTerm[]{
						new StrategoAppl(
								CONS_OP,
								new IStrategoTerm[]{
										new StrategoString(prod.constructor(), null, 0),
										Utilities.strategoListFromArray(args)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm parenthetical(IStrategoTerm var){
		return new StrategoAppl(
				CONS_NOANNOLIST,
				new IStrategoTerm[]{
						new StrategoAppl(
								CONS_OP,
								new IStrategoTerm[]{
										new StrategoString("Parenthetical", null, 0),
										Utilities.strategoListFromArray(var)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	private static int productionSize(SyntaxProduction prod){
		int size = 0;
		for(Symbol s : prod.symbols()){
			if(s.type() == Symbol.Type.CONTEXT_FREE && !s.isLayout())
				++size;
		}
		
		return size;
	}
	
	private static IStrategoTerm destination(SyntaxProduction prod, int pos){
		if(prod.constructor() == null || prod.constructor().isEmpty())
			return null;
		
		int size = productionSize(prod);
		
		IStrategoTerm args[] = new IStrategoTerm[size];
		for(int i = 0; i < size; ++i){
			args[i] = var("t_"+i);
			if(pos < 0 || pos == i){
				args[i] = parenthetical(args[i]);
			}
		}
		
		return new StrategoAppl(
				CONS_NOANNOLIST,
				new IStrategoTerm[]{
						new StrategoAppl(
								CONS_OP,
								new IStrategoTerm[]{
										new StrategoString(prod.constructor(), null, 0),
										Utilities.strategoListFromArray(args)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	public static String prettyPrint(IStrategoTerm parenthesized){
		final Context context = new Context();
        org.strategoxt.strc.Main.init(context);
        IStrategoTerm term = pp_stratego_string_0_0.instance.invoke(context, parenthesized);
        
        if(term.getTermType() != IStrategoTerm.STRING)
        	return "";
        	
		return ((StrategoString)term).stringValue();
	}
	
	public static IStrategoTerm parenthesize(Syntax grammar, String name){
		final String module_name = "pp/"+name+"-parenthesize";
		final String rule_name = name+"Parenthesize";
		
		// Imports
		IStrategoTerm imports = new StrategoAppl(
				CONS_IMPORTS,
				new IStrategoTerm[]{
						Utilities.strategoListFromArray(
								importModule("libstratego-lib"),
								importModule("signatures/"+name+"-sig")
						)
				},
				null,
				0
		);
		
		// Strategies
		IStrategoTerm strategies = new StrategoAppl(
				CONS_STRATEGIES,
				new IStrategoTerm[]{
						Utilities.strategoListFromArray(
								defineStrategy("io-"+name+"-parenthesize", call("io-wrap", call("parenthesize-"+name))),
								defineStrategy("parenthesize-"+name, call("innermost", call(rule_name)))
						)
				},
				null,
				0
		);
		
		// Rules
		List<IStrategoTerm> rule_list = new ArrayList<>();
		
		for(SyntaxProduction prod : grammar.productions()){
			IStrategoTerm src = source(prod);
			
			int pos = 0;
			for(int i = 0; i < prod.size(); ++i){
				Symbol s = prod.symbol(i);
				
				if(s.type() == Symbol.Type.CONTEXT_FREE && !s.isLayout()){
					Set<SyntaxProduction> set = new HashSet<>();
					
					IStrategoTerm pattern_matching = APPL_FAIL;
					
					for(PosPriorityLevel prio : prod.priorities().priorityLevels()){
						if(prio.position() < 0 || prio.position() == i){
							for(PriorityLevel l : prio.level().lowerLevels()){
								
								for(PosProduction pprod : l.productions()){
									SyntaxProduction p = pprod.production();
									
									if(set.add(p)){
										IStrategoTerm m = match(p);
										
										if(m != null)
											pattern_matching = makeChoice(m, pattern_matching);
									}
								}
								
							}
						}
					}
					
					if(pattern_matching != APPL_FAIL){
						IStrategoTerm rule = defineRule(rule_name, src, destination(prod, pos), pattern_matching, pos);
						
						if(rule != null)
							rule_list.add(rule);
					}
					
					++pos;
				}
			}
		}
		
		IStrategoTerm rules = new StrategoAppl(
				CONS_RULES,
				new IStrategoTerm[]{
						Utilities.strategoListFromCollection(rule_list)
				},
				null,
				0
		);
		
		// Signature
		IStrategoTerm signature = new StrategoAppl(
				CONS_SIGNATURE,
				new IStrategoTerm[]{
						Utilities.strategoListFromArray()
				},
				null,
				0
		);
		
		return new StrategoAppl(
				CONS_MODULE,
				new IStrategoTerm[]{
						new StrategoString(module_name, null, 0),
						Utilities.strategoListFromArray(imports, strategies, rules, signature)
				},
				null,
				0
		);
	}
}
