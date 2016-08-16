package org.metaborg.sdf2table.parsetable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.grammar.UndefinedSymbolException;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;

public class ContextualProduction extends Production{
	SyntaxProduction _source;
	ContextualSymbol _symbol;
	List<Symbol> _rhs;
	Set<ContextualSymbol> _dependants = new HashSet<>();
	static final Set<ContextualProduction> _to_validate = new HashSet<>();
	int _id = -1;
	int _hash_code = -1;
	
	boolean _declared = false;
	boolean _valid = false;
	
	Label _label = null;
	
	private ContextualProduction(SyntaxProduction source, ContextualSymbol symbol, List<Symbol> rhs){
		_source = source;
		_symbol = symbol;
		_rhs = rhs;
		
		for(Symbol s : rhs){
			if(s instanceof ContextualSymbol){
				ContextualSymbol cs = ((ContextualSymbol)s);
				cs.addDependant(this);
			}
		}
	}
	
	public static ContextualProduction unique(SyntaxProduction source, ContextualSymbol symbol, List<Symbol> rhs){
		ContextualProduction u = new ContextualProduction(source, symbol, rhs);
		u.declare();
		
		return u;
	}
	
	static public void validateAll(){
		for(ContextualProduction p : _to_validate){
			p.validate();
		}
		_to_validate.clear();
	}
	
	public void validate(){
		if(!_valid){
			for(Symbol s : _rhs){
				if(!s.isTerminal() && (!(s instanceof ContextualSymbol) || !((ContextualSymbol)s).isValid()))
					return;
			}
			_valid = true;
			//
			for(ContextualSymbol dep : _dependants){
				dep.validate();
			}
			_dependants = null;
		}
	}
	
	public Label label(){
		if(_label == null)
			_label = ParseTable.newLabel(this); 
		return _label;
		//return _source.label();
	}
	
	public boolean isValid() {
		return _valid;
	}
	
	public void addDependant(ContextualSymbol dep){
		_dependants.add(dep);
	}
	
	public void declare(){
		if(_declared)
			return;
		ParseTable.declareContextualProduction(this);
		_source.addContextualProduction(this);
		_to_validate.add(this);
		_declared = true;
	}
	
	public String shortString(){
		if(constructor() != null && !constructor().isEmpty())
			return _symbol.toString()+"."+constructor();
		return toString();
	}
	
	@Override
	public String toString(){
		String _str = "";
		for(Symbol s : _rhs)
			_str += s.toString()+" ";
		_str += "→ "+_symbol.toString();
		if(constructor() != null && !constructor().isEmpty())
			_str += "."+constructor();
		if(!attributes().isEmpty()){
			int i = 0;
			_str += " {";
			for(Attribute attr : attributes()){
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
		
		return _str;
	}
	
	@Override
    public int hashCode() {
		if(_hash_code == -1)
			_hash_code = toString().hashCode();
		return _hash_code;
	}
	
	public String constructor(){
		return _source.constructor();
	}
	
	public boolean containsTerminal(){
		return _source.containsTerminal();
	}
	
	@Override
	public NonTerminal product() {
		return _symbol;
	}
	
	@Override
	public int size() {
		return _rhs.size();
	}
	
	public boolean isEmpty(){
		return _rhs.isEmpty();
	}
	
	public boolean isEpsilon(){
		return _source.isEpsilon();
	}
	
	@Override
	public Symbol symbol(int position) {
		return _rhs.get(position);
	}
	
	@SuppressWarnings("unchecked")
	public List<Symbol> symbols(){
		return (List<Symbol>)(Object)_rhs;
	}
	
	public Set<Attribute> attributes(){
		return _source.attributes();
	}
	
	public SyntaxProduction syntaxProduction(){
		return _source;
	}

	@Override
	public void contextualize(ContextualSymbol cs, Set<ContextualProduction> set) throws UndefinedSymbolException{
		//
	}
}
