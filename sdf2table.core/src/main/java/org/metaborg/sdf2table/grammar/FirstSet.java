package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.symbol.TerminalContainer;

public class FirstSet extends TerminalContainer{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 7938233559578582879L;
	
	Set<FirstSet> _dependencies = new HashSet<FirstSet>();
	
	public void addDependency(FirstSet set){
		if(set != this)
			_dependencies.add(set);
	}
	
	public void compute(){
		if(!_dependencies.isEmpty()){
			for(FirstSet dep : _dependencies){
				dep.compute();
				add(dep);
			}
			_dependencies.clear();
		}
	}
}
