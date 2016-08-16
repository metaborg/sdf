package org.metaborg.sdf2table.core;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FixPointMember<Value, FixPointType extends FixPoint<Value>>{
	private FixPointType _component = null;
	private Value _initial_value = null;
	
	private Set<FixPointMember<Value, FixPointType>> _dependencies = new HashSet<>();
	private Set<FixPointMember<Value, FixPointType>> _dependents = new HashSet<>();
	
	public FixPointMember(Value initial_value){
		_initial_value = initial_value;
	}
	
	// TARJAN's requirements
	protected static int _count = 0;
	protected int _index = -1;
	protected int _low_link = -1;
	protected boolean _on_stack = false;
	
	public void compute(FixPointFactory factory){
		doCompute(new Stack<FixPointMember<Value, FixPointType>>(), factory);
	}
	
	/**
	 * Compute equivalent classes in FIRST sets.
	 * <p>
	 * Let view all FIRST and FOLLOW sets as a graph G(E, V), where
	 * for all production P, E contains FIRST(P) and FOLLOW(P),
	 * and V a relation defined by :
	 * 
	 * 		for all (A, B) on E^2, (A, B) is on V iff
	 * 		B depends on A, ie. for all terminal t of A, t is in B. // TODO review this definition.
	 * 
	 * G is a dependency graph. G can contains cycles.
	 * <p>
	 * For all FOLLOW or FIRST sets A and B, A = B if
	 * it exists two paths (v, w) where
	 * 
	 * 		A --v-->* B, and B --w-->* A.
	 * 
	 * In other words, A = B if A and B share the same strongly connected component.
	 * <p>
	 * ... // TODO explain how to build the acyclic dependency graph.
	 * <p>
	 * Based on TARJAN's strongly connected components algorithm.
	 * c.f. https://en.wikipedia.org/wiki/Tarjan's_strongly_connected_components_algorithm
	 * @param stack
	 */
	private void doCompute(Stack<FixPointMember<Value, FixPointType>> stack, FixPointFactory factory){
		if(_component == null){
			_index = _low_link = _count++;
			_on_stack = true;
			stack.push(this);
			
			// Consider successors of this
			for(FixPointMember<Value, FixPointType> w : _dependents){
				if(w._index == -1){
					// Successor w has not been visited; recurse on it
					w.doCompute(stack, factory);
					_low_link = Math.min(_low_link, w._low_link);
				}else if(w._on_stack){
					// Successor w is in stack S and hence in the current SSC
					_low_link = Math.min(_low_link, w._index);
				}
			}
			
			// If v is a root node, pop the stack and generate an SCC
			if(_low_link == _index){
				// start a new strongly connected component
				@SuppressWarnings("unchecked")
				FixPointType component = (FixPointType)factory.create();
				FixPointMember<Value, FixPointType> w = null;
				
				Set<FixPointMember<Value, FixPointType>> scc = new HashSet<>();
				
				do{
					// add w to current strongly connected component
					w = stack.pop();
					component.apply(w._initial_value);
					w._component = component;
					w._on_stack = false;
					w._initial_value = null;
					
					scc.add(w);
				}while(w != this);
				
				// dependencies
				for(FixPointMember<Value, FixPointType> v : scc){
					for(FixPointMember<Value, FixPointType> dep : v._dependencies){
						if(dep._component != null)
							component.addDependency(dep._component);
					}
					
					for(FixPointMember<Value, FixPointType> dep : v._dependents){
						if(dep._component != null)
							dep._component.addDependency(component);
					}
					
					v._dependencies.clear();
					v._dependents.clear();
				}
			}
		}
	}

	public void addDependency(FixPointMember<Value, FixPointType> p){
		if(_dependencies.add(p)){
			p.addDependent(this);
		}
	}
	
	protected void addDependencies(Set<FixPointMember<Value, FixPointType>> set){
		for(FixPointMember<Value, FixPointType> p : set){
			addDependency(p);
		}
	}
	
	protected void addDependent(FixPointMember<Value, FixPointType> f){
		_dependents.add(f);
	}
	
	public Set<FixPointMember<Value, FixPointType>> dependencies(){
		return _dependencies;
	}
	
	public Set<FixPointMember<Value, FixPointType>> dependents(){
		return _dependents;
	}
	
	public Value initialValue(){
		return _initial_value;
	}
	
	public void setInitialValue(Value v){
		_initial_value = v;
	}
	
	public Value value(){
		return _component.value();
	}
	
	public FixPointType component(){
		return _component;
	}
}
