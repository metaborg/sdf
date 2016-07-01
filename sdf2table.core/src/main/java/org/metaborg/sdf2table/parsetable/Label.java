package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.core.Exportable;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class Label implements Trigger, Exportable{
	static int _count = 0;
	
	public static void reset(){
		_count = 0;
	}
	
	public static int nextId(){
		return 257+_count++;
	}
	
	int _id = -1;
	private IProduction _agent;

	Label(IProduction p){
		_agent = p;
	}
	
	/**
	 * Unique identifier of the production.
	 * <p>
	 * This identifier is generated when this method is called for the first time.
	 * @return An integer associated with this production.
	 */
	public int id(){
		if(_id == -1)
			_id = nextId();
		return _id;
	}
	
	IProduction agent(){
		return _agent;
	}

	@Override
	public boolean isTerminal() {
		return false;
	}

	@Override
	public Trigger inter(Trigger other) {
		if(equals(other))
			return this;
		return null;
	}

	@Override
	public Trigger except(Trigger other) {
		if(equals(other))
			return null;
		return this;
	}

	@Override
	public String graphviz(){
		return _agent.graphviz();
	}
	
	public Label copy(){
		return this;
	}
	
	public IStrategoTerm toATerm(){
		return _agent.asProduction().toATerm(id());
	}

	public boolean contains(IProduction prod) {
		return _agent.equals(prod);
	}
}
