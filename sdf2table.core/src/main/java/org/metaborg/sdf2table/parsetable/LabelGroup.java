package org.metaborg.sdf2table.parsetable;

import java.util.HashSet;

import org.metaborg.sdf2table.grammar.Trigger;

public class LabelGroup extends Label implements Trigger{
	
	HashSet<Label> _labels = new HashSet<>();

	public LabelGroup(Label one){
		super(one.agent().asProduction());
		_labels.add(one);
	}
	
	public boolean add(Label l){
		return _labels.add(l);
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
		String str = "";
		for(Label l : _labels){
			if(!str.isEmpty())
				str += "\n";
			str += l.graphviz();
		}
		
		return str;
	}

}
