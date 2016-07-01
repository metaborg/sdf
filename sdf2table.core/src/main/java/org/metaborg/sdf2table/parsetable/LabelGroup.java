package org.metaborg.sdf2table.parsetable;

import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Trigger;

public class LabelGroup extends Label implements Trigger{
	
	Set<Label> _labels = new HashSet<>();

	public LabelGroup(Label one){
		super(one.agent().asProduction());
		_labels.add(one);
	}
	
	public LabelGroup(LabelGroup g){
		super(g.agent().asProduction());
		_labels.addAll(g._labels);
	}
	
	public Label copy(){
		return ParseTable.newLabelGroup(this);
	}
	
	public boolean add(Label l){
		return _labels.add(l);
	}
	
	@Override
	public boolean contains(IProduction prod) {
		return agent().equals(prod.asProduction());
	}
	
	@Override
	public boolean isTerminal(){
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
