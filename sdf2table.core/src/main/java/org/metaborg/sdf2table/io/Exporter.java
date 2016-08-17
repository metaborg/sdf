package org.metaborg.sdf2table.io;

import org.metaborg.sdf2table.grammar.Production;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoString;

public class Exporter{
	private static final StrategoConstructor CONS_ASSOC = new StrategoConstructor("assoc", 1);
	private static final StrategoConstructor CONS_LEFT = new StrategoConstructor("left", 0);
	private static final StrategoConstructor CONS_RIGHT = new StrategoConstructor("right", 0);
	private static final StrategoConstructor CONS_NON_ASSOC = new StrategoConstructor("non-assoc", 0);
	private static final StrategoConstructor CONS_BRACKET = new StrategoConstructor("bracket", 0);
	private static final StrategoConstructor CONS_REJECT = new StrategoConstructor("reject", 0);
	private static final StrategoConstructor CONS_PREFER = new StrategoConstructor("prefer", 0);
	private static final StrategoConstructor CONS_AVOID = new StrategoConstructor("avoid", 0);
	
	private static final StrategoConstructor CONS_TERM = new StrategoConstructor("term", 1);
	
	private static final StrategoConstructor CONS_DEPRECATED = new StrategoConstructor("deprecated", 1);
	private static final StrategoConstructor CONS_LAYOUT = new StrategoConstructor("layout", 1);
	private static final StrategoConstructor CONS_IGNORE_LAYOUT = new StrategoConstructor("ignore-layout", 0);
	private static final StrategoConstructor CONS_ENFORCE_NEWLINE = new StrategoConstructor("enforce-newline", 0);
	private static final StrategoConstructor CONS_LONGEST_MATCH = new StrategoConstructor("longest-match", 0);
	private static final StrategoConstructor CONS_CASE_INSENSITIVE = new StrategoConstructor("case-isensitive", 0);
	private static final StrategoConstructor CONS_PLACEHOLDER = new StrategoConstructor("placeholder", 0);
	private static final StrategoConstructor CONS_PLACEHOLDER_INSERTION = new StrategoConstructor("placeholder-insertion", 0);
	private static final StrategoConstructor CONS_LITERAL_COMPLETION = new StrategoConstructor("literal-completion", 0);
	
	private static IStrategoTerm attrTerm(IStrategoTerm term){
		return new StrategoAppl(
				CONS_TERM,
				new IStrategoTerm[]{
						term
				},
				null,
				0
		);
	}
	
	private static IStrategoTerm attrAssoc(StrategoConstructor cons){
		return new StrategoAppl(
				CONS_ASSOC,
				new IStrategoTerm[]{
						new StrategoAppl(
								CONS_ASSOC,
								new IStrategoTerm[]{
										cons
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	public static IStrategoTerm exportAttribute(Production.Attribute attr){
		switch(attr.type()){
		case ASSOC:
			Production.Associativity assoc = (Production.Associativity)attr;
			switch(assoc.assoc()){
			case LEFT:
				return attrAssoc(CONS_LEFT);
			case RIGHT:
				return attrAssoc(CONS_RIGHT);
			case NON_ASSOC:
				return attrAssoc(CONS_NON_ASSOC);
			}
			break;
		case DEPRECATED:
			Production.Deprecated dep = (Production.Deprecated)attr;
			return attrTerm(new StrategoAppl(CONS_DEPRECATED, new IStrategoTerm[]{new StrategoString(dep.message(), null, 0)}, null, 0));
		case LAYOUT_CONSTRAINT:
			Production.LayoutConstraint cons = (Production.LayoutConstraint)attr;
			return attrTerm(new StrategoAppl(CONS_LAYOUT, new IStrategoTerm[]{new StrategoString(cons.constraint(), null, 0)}, null, 0));
		case BRACKET:
			return new StrategoAppl(CONS_BRACKET, new IStrategoTerm[]{}, null, 0);
		case REJECT:
			return new StrategoAppl(CONS_REJECT, new IStrategoTerm[]{}, null, 0);
		case PREFER:
			return new StrategoAppl(CONS_PREFER, new IStrategoTerm[]{}, null, 0);
		case AVOID:
			return new StrategoAppl(CONS_AVOID, new IStrategoTerm[]{}, null, 0);
		case IGNORE_LAYOUT:
			return attrTerm(new StrategoAppl(CONS_IGNORE_LAYOUT, new IStrategoTerm[]{}, null, 0));
		case ENFORCE_NEWLINE:
			return attrTerm(new StrategoAppl(CONS_ENFORCE_NEWLINE, new IStrategoTerm[]{}, null, 0));
		case LONGEST_MATCH:
			return attrTerm(new StrategoAppl(CONS_LONGEST_MATCH, new IStrategoTerm[]{}, null, 0));
		case CASE_INSENSITIVE:
			return attrTerm(new StrategoAppl(CONS_CASE_INSENSITIVE, new IStrategoTerm[]{}, null, 0));
		case PLACEHOLDER:
			return attrTerm(new StrategoAppl(CONS_PLACEHOLDER, new IStrategoTerm[]{}, null, 0));
		case PLACEHOLDER_INSERTION:
			return attrTerm(new StrategoAppl(CONS_PLACEHOLDER_INSERTION, new IStrategoTerm[]{}, null, 0));
		case LITERAL_COMPLETION:
			return attrTerm(new StrategoAppl(CONS_LITERAL_COMPLETION, new IStrategoTerm[]{}, null, 0));
		default:
			break;
		}
		
		return null;
	}
}
