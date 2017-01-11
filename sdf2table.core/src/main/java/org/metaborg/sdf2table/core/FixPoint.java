package org.metaborg.sdf2table.core;

import java.util.HashSet;
import java.util.Set;

public abstract class FixPoint<Value>{
	Set<FixPoint<Value>> _dependencies = new HashSet<FixPoint<Value>>();
	
	public void addDependency(FixPoint<Value> fp){
		if(fp != this)
			_dependencies.add(fp);
	}
	
	public Set<FixPoint<Value>> dependencies(){
		return _dependencies;
	}
	
	public void compute(){
		if(!_dependencies.isEmpty()){
			for(FixPoint<Value> dep : _dependencies){
				dep.compute();
				apply(dep.value());
			}
			_dependencies.clear();
		}
	}
	
	public abstract Value value();
	
	public abstract void apply(Value v);
}
