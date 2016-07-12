package org.metaborg.sdf2table.grammar;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.parsetable.ContextualProduction;
import org.metaborg.sdf2table.parsetable.Label;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

/**
 * Grammar production.
 * 
 */
public class SyntaxProduction extends Production{
	/**
	 * Some Stratego constructors for the ATerm translation.
	 */
	private static final StrategoConstructor CONS_LABEL = new StrategoConstructor("label", 2);
	private static final StrategoConstructor CONS_PROD = new StrategoConstructor("prod", 3);
	private static final StrategoConstructor CONS_NO_ATTRS = new StrategoConstructor("no-attrs", 0);
	private static final StrategoConstructor CONS_ATTRS = new StrategoConstructor("attrs", 1);
	private static final StrategoConstructor CONS_ATTR_LEFT = new StrategoConstructor("left", 0);
	private static final StrategoConstructor CONS_ATTR_RIGHT = new StrategoConstructor("right", 0);
	private static final StrategoConstructor CONS_ATTR_BRACKET = new StrategoConstructor("bracket", 0);
	private static final StrategoConstructor CONS_ATTR_REJECT = new StrategoConstructor("reject", 0);
	private static final StrategoConstructor CONS_ATTR_PREFER = new StrategoConstructor("prefer", 0);
	private static final StrategoConstructor CONS_ATTR_LONGEST_MATCH = new StrategoConstructor("longest-match", 0);
	
	private static final StrategoConstructor CONS_TERM = new StrategoConstructor("term", 1);
	private static final StrategoConstructor CONS_CONS = new StrategoConstructor("cons", 1);
	
	/**
	 * Symbol synthesized by the production.
	 */
	NonTerminal _symbol;
	
	/**
	 * Constructor name, if any.
	 */
	String _cons = null;
	
	/**
	 * Attributes of the production.
	 */
	Set<Attribute> _attributes;
	
	/**
	 * List of symbols of the production. From left to right.
	 */
	List<Symbol> _rhs;
	
	Label _label = null;
	Set<ContextualProduction> _cprods = null;
	
	/**
	 * List the priorities where this production is the direct ascendant.
	 */
	//Set<Priority> _priorities = new HashSet<>();
	Priorities _priorities = new Priorities(this);
	
	Set<Symbol> _left;
	Set<Symbol> _right;
	
	/**
	 * String representation of the production.
	 * <p>
	 * This attribute is computed when {@link #toString()} is first called to avoid multiple computation of the same value.
	 * <p>
	 * The string value is also used to compute the {@link #hashCode()}.
	 */
	String _str;
	
	/**
	 * Main constructor.
	 * @param symbol The symbol produced by the production.
	 * @param cons The name of the constructor. May be null is the production have no constructor defined.
	 * @param rhs A list of symbols that compose the production, from left to right.
	 * @param attributes A list of attributes.
	 */
	public SyntaxProduction(NonTerminal symbol, String cons, List<Symbol> rhs, Set<Attribute> attributes){
		_symbol = symbol;
		_rhs = rhs;
		_cons = cons;
		_attributes = attributes;
		
		_label = null;
	}
	
	public void addContextualProduction(ContextualProduction p){
		if(_cprods == null){
			_cprods = new HashSet<>();
		}
		
		_cprods.add(p);
	}
	
	public Set<ContextualProduction> contextualProductions(){
		return _cprods;
	}
	
	/**
	 * Get the list of priorities.
	 * @return The list the priorities where this production is the direct ascendant.
	 */
	public Priorities priorities(){		
		return _priorities;
	}
	
	public Label label(){
		if(_label == null)
			_label = ParseTable.newLabel(this);
		return _label;
	}
	
	public SyntaxProduction syntaxProduction(){
		return this;
	}
	
	public boolean containsTerminal(){
		for(Symbol s : _rhs){
			if(s instanceof Terminal)
				return true;
		}
		return false;
	}
	
	/**
	 * @return The last symbol of the production, or null if the production is empty.
	 */
	public Symbol lastSymbol(){
		if(_rhs.isEmpty())
			return null;
		return _rhs.get(_rhs.size()-1);
	}
	
	/**
	 * Declare priority.
	 * <p>
	 * This method should not be directly used.
	 * @param prio
	 */
	/*public boolean addPriority(Priority prio){
		return _priorities.add(prio);
	}*/
	
	/**
	 * List of attributes.
	 * @return A list of attributes.
	 */
	public Set<Attribute> attributes(){
		return _attributes;
	}
	
	/**
	 * Synthesized symbol.
	 * @return The symbol resulting of the production.
	 */
	public NonTerminal product(){
		return _symbol;
	}
	
	public int size(){
		return _rhs.size();
	}
	
	public boolean isEmpty(){
		return _rhs.isEmpty();
	}
	
	public boolean isEpsilon(){
		for(Symbol s : _rhs){
			if(!s.isLayout()){
				return false;
			}
		}
		return true;
	}
	
	public Symbol symbol(int position){
		return _rhs.get(position);
	}
	
	/**
	 * Symbols defining the production.
	 * @return A list of symbols defining the production, from left to right.
	 */
	public List<Symbol> symbols(){
		return _rhs;
	}
	
	/**
	 * Production constructor.
	 * @return The name of the constructor is any, null otherwise.
	 */
	public String constructor(){
		return _cons;
	}
	
	public boolean potentialLeftDeepConflict(PriorityLevel l){
		Set<SyntaxProduction> set = new HashSet<>();
		return doPotentialLeftDeepConflict(l, set);
	}
	
	public boolean potentialRightDeepConflict(PriorityLevel l){
		Set<SyntaxProduction> set = new HashSet<>();
		return doPotentialRightDeepConflict(l, set);
	}
	
	private boolean doPotentialLeftDeepConflict(PriorityLevel l, Set<SyntaxProduction> set){
		if((left() != null && left().nonEpsilon()) || set.contains(this))
			return false;
		/*if(l.production().priorities().deepConflicts(this, l.position()))
			return true;*/
		if(l.conflicts(this))
			return true;
		
		set.add(this);
		
		for(int i = 0; i < size(); ++i){
			Symbol s = symbol(i);
			
			if(s != null && s instanceof NonTerminal){
				NonTerminal n = (NonTerminal)s;
				for(Production p : n.productions()){
					SyntaxProduction sp = p.syntaxProduction();
					
					if(!directConflicts(sp, i) && sp.doPotentialLeftDeepConflict(l, set)){
						return true;
					}
				}
				
				if(n.nonEpsilon())
					break;
			}else{
				break;
			}
		}
		
		return false;
	}
	
	private boolean doPotentialRightDeepConflict(PriorityLevel l, Set<SyntaxProduction> set){
		if((right() != null && right().nonEpsilon()) || set.contains(this))
			return false;
		/*if(l.production().priorities().deepConflicts(this, l.position()))
			return true;*/
		if(l.conflicts(this))
			return true;
		
		set.add(this);
		
		for(int i = size()-1; i >= 0; --i){
			Symbol s = symbol(i);
			
			if(s != null && s instanceof NonTerminal){
				NonTerminal n = (NonTerminal)s;
				
				for(Production p : n.productions()){
					SyntaxProduction sp = p.syntaxProduction();
					
					if(!directConflicts(sp, i) && sp.doPotentialRightDeepConflict(l, set)){
						return true;
					}
				}
				
				if(n.nonEpsilon())
					break;
			}else{
				break;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this)
			return true;
		if(o != null && o instanceof SyntaxProduction){
			SyntaxProduction p = (SyntaxProduction)o;
			if(p._symbol.equals(_symbol) && p._rhs.size() == _rhs.size() && p._attributes.size() == _attributes.size()){
				for(int i = 0; i < _rhs.size(); ++i){
					if(!_rhs.get(i).equals(p._rhs.get(i)))
						return false;
				}

				/*for(int i = 0; i < _attributes.size(); ++i){
					if(!_attributes.get(i).equals(p._attributes.get(i)))
						return false;
				}*/
				_attributes.equals(p._attributes);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean merge(SyntaxProduction p){
		if(p._symbol.equals(_symbol) && p._rhs.size() == _rhs.size()){
			for(int i = 0; i < _rhs.size(); ++i){
				if(!_rhs.get(i).equals(p._rhs.get(i)))
					return false;
			}
			
			_attributes.addAll(p.attributes());
			
			return true;
		}
		
		return false;
	}
	
	public String shortString(){
		if(_cons != null && !_cons.isEmpty())
			return _symbol.toString()+"."+_cons;
		return toString();
	}
	
	@Override
	public String toString(){
		if(_str == null){
			_str = "";
			for(Symbol s : _rhs)
				_str += s.toString()+" ";
			_str += "→ "+_symbol.toString();
			if(_cons != null && !_cons.isEmpty())
				_str += "."+_cons;
			if(!_attributes.isEmpty()){
				int i = 0;
				_str += " {";
				for(Attribute attr : _attributes){
					if(i > 0)
						_str += ",";
					switch(attr){
					case ASSOC_LEFT:
						_str += "left";
						break;
					case ASSOC_RIGHT:
						_str += "right";
						break;
					case BRACKET:
						_str += "bracket";
						break;
					case REJECT:
						_str += "reject";
						break;
					case PREFER:
						_str += "prefer";
						break;
					case LONGEST_MATCH:
						_str += "longest-match";
						break;
					}
					++i;
				}
				_str += "}";
			}
		}
		
		return _str;
	}
	
	@Override
    public int hashCode() {
        return toString().hashCode();
    }
	
	public IStrategoTerm toATerm(int id){
		IStrategoTerm[] list = new IStrategoTerm[_rhs.size()];
		for(int i = 0; i < _rhs.size(); ++i)
			list[i] = _rhs.get(i).toATerm();
		
		IStrategoTerm attrs = null;
		if(_attributes.isEmpty() && (_cons == null || _cons.isEmpty())){
			attrs = new StrategoAppl(CONS_NO_ATTRS, new IStrategoTerm[]{}, null, 0);
		}else{
			IStrategoTerm[] attr_list = new IStrategoTerm[_attributes.size()+1];
			
			int i = 0;
			for(Attribute attr : _attributes){
				switch(attr){
				case ASSOC_LEFT:
					attr_list[i] = new StrategoAppl(CONS_ATTR_LEFT, new IStrategoTerm[]{}, null, 0);
					break;
				case ASSOC_RIGHT:
					attr_list[i] = new StrategoAppl(CONS_ATTR_RIGHT, new IStrategoTerm[]{}, null, 0);
					break;
				case BRACKET:
					attr_list[i] = new StrategoAppl(CONS_ATTR_BRACKET, new IStrategoTerm[]{}, null, 0);
					break;
				case REJECT:
					attr_list[i] = new StrategoAppl(CONS_ATTR_REJECT, new IStrategoTerm[]{}, null, 0);
					break;
				case PREFER:
					attr_list[i] = new StrategoAppl(CONS_ATTR_PREFER, new IStrategoTerm[]{}, null, 0);
					break;
				case LONGEST_MATCH:
					attr_list[i] = new StrategoAppl(
							CONS_TERM,
							new IStrategoTerm[]{
									new StrategoAppl(CONS_ATTR_LONGEST_MATCH, new IStrategoTerm[]{}, null, 0)
							},
							null,
							0
						);
					break;
				}
				++i;
			}
			
			if(_cons != null && !_cons.isEmpty()){
				attr_list[attr_list.length-1] = new StrategoAppl(
						CONS_TERM,
						new IStrategoTerm[]{
								new StrategoAppl(
										CONS_CONS,
										new IStrategoTerm[]{new StrategoString(_cons, null, 0)},
										null,
										0)
						},
						null,
						0);
			}
			
			attrs = new StrategoAppl(CONS_ATTRS, new IStrategoTerm[]{Utilities.strategoListFromArray(attr_list)}, null, 0);
		}
		
		return new StrategoAppl(
				CONS_LABEL,
				new IStrategoTerm[]{
						new StrategoAppl(
							CONS_PROD,
							new IStrategoTerm[]{
									Utilities.strategoListFromArray(list),
									_symbol.toATerm(),
									attrs
							},
							null,
							0
						),
						new StrategoInt(id, null, 0)
				},
				null,
				0
				);
	}
	
	public static SyntaxProduction fromATerm(IStrategoTerm term, Syntax syntax){
		if(term instanceof IStrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			boolean with_cons = false;
			if(app.getName().equals("SdfProduction") || (with_cons = true && app.getName().equals("SdfProductionWithCons"))){
				NonTerminal symbol;
				String cons = "";
				List<Symbol> sym_list = new ArrayList<>();
				StrategoAppl tattrs;
				
				if(with_cons){
					// SdfProductionWithCons(SortCons(<type>), Constructor("<cons>"), ...)
					symbol = (NonTerminal)Symbol.fromStrategoTerm(app.getSubterm(0).getSubterm(0), syntax.symbols());
					cons = ((StrategoString)app.getSubterm(0).getSubterm(1).getSubterm(0)).stringValue();
				}else{
					symbol = (NonTerminal)Symbol.fromStrategoTerm(app.getSubterm(0), syntax.symbols());
				}
				
				// Read right hand side of the equation: Rhs([<symbols>])
				StrategoList rhs = (StrategoList)app.getSubterm(1).getSubterm(0);
				for(IStrategoTerm t : rhs){
					sym_list.add(Symbol.fromStrategoTerm(t, syntax.symbols()));
				}
				
				// Read attributes
				tattrs = (StrategoAppl)app.getSubterm(2);
				Set<Attribute> attrs = EnumSet.noneOf(Attribute.class);
				switch(tattrs.getName()){
				case "NoAttrs":
					break;
				case "Attrs": // TODO handle all production attributes
					StrategoList talist = (StrategoList)tattrs.getSubterm(0);
					for(IStrategoTerm ta : talist){
						StrategoAppl a = (StrategoAppl)ta;
						switch(a.getName()){
						case "Assoc":
							StrategoAppl assoc = (StrategoAppl)a.getSubterm(0);
							switch(assoc.getName()){
							case "Left":
								attrs.add(Attribute.ASSOC_LEFT);
								break;
							case "Right":
								attrs.add(Attribute.ASSOC_RIGHT);
								break;
							default:
								System.err.println("Unknown associativity: `"+assoc.getName()+"'.");
								break;
							}
							break;
						case "Bracket":
							attrs.add(Attribute.BRACKET);
							break;
						case "Reject":
							attrs.add(Attribute.REJECT);
							break;
						case "Prefer":
							attrs.add(Attribute.PREFER);
							break;
						case "Term":
							ta = ta.getSubterm(0);
							if(ta instanceof StrategoAppl && ((StrategoAppl)ta).getName().equals("Default")){
								ta = ta.getSubterm(0);
								if(ta instanceof StrategoAppl && ((StrategoAppl)ta).getName().equals("Fun")){
									ta = ta.getSubterm(0);
									if(ta instanceof StrategoAppl && ((StrategoAppl)ta).getName().equals("Unquoted")){
										StrategoString str = (StrategoString)ta.getSubterm(0);
										if(str.stringValue().equals("longest-match")){
											attrs.add(Attribute.LONGEST_MATCH);
											break;
										}
									}
								}
							}
						default:
							System.err.println("Unknown attribute type: `"+a.getName()+"'.");
							break;
						}
					}
					break;
				default:
					System.err.println("Malformed Stratego term : Attributes expected.");
					return null;
				}
				
				return syntax.uniqueProduction(new SyntaxProduction(symbol, cons, sym_list, attrs));
			}
		}
		return null;
	}
}
