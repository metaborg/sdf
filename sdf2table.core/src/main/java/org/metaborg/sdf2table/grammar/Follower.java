package org.metaborg.sdf2table.grammar;

/*public abstract class Follower{
	private FirstSet _set = null;
	
	private Set<Terminal> _precomputed_firsts = new HashSet<>();
	private Set<Follower> _dependencies = new HashSet<>();
	private Set<Follower> _dependents = new HashSet<>();
	
	public abstract void computeDependencies();
	
	// TARJAN's requirements
	protected static int _count = 0;
	protected int _index = -1;
	protected int _low_link = -1;
	protected boolean _on_stack = false;
	
	public void generateFirstSet(){
		doGenerateFirstSet(new Stack<Follower>());
	}
	
	private void doGenerateFirstSet(Stack<Follower> stack){
		if(_set == null){
			_index = _low_link = _count++;
			_on_stack = true;
			stack.push(this);
			
			// Consider successors of this
			for(Follower w : _dependents){
				if(w._index == -1){
					// Successor w has not been visited; recurse on it
					w.doGenerateFirstSet(stack);
					_low_link = Math.min(_low_link, w._low_link);
				}else if(w._on_stack){
					// Successor w is in stack S and hence in the current SSC
					_low_link = Math.min(_low_link, w._index);
				}
			}
			
			// If v is a root node, pop the stack and generate an SCC
			if(_low_link == _index){
				// start a new strongly connected component
				FirstSet set = new FirstSet();
				Follower w = null;
				
				Set<Follower> scc = new HashSet<>();
				
				do{
					// add w to current strongly connected component
					w = stack.pop();
					set.addAll(w._precomputed_firsts);
					w._set = set;
					w._on_stack = false;
					w._precomputed_firsts = null;
					
					scc.add(w);
				}while(w != this);
				
				// dependencies
				for(Follower v : scc){
					for(Follower dep : v._dependencies){
						if(dep._set != null)
							set.addDependency(dep._set);
					}
					
					for(Follower dep : v._dependents){
						if(dep._set != null)
							dep._set.addDependency(set);
					}
					
					v._dependencies.clear();
					v._dependents.clear();
				}
			}
		}
	}

	protected void addDependency(Follower p){
		if(_dependencies.add(p)){
			p.addDependent(this);
		}
	}
	
	protected void addDependent(Follower f){
		_dependents.add(f);
	}
	
	protected void addFirst(Terminal s){
		if(_set == null)
			_precomputed_firsts.add(s);
		else
			_set.add(s);
	}
	
	public Set<Follower> dependencies(){
		return _dependencies;
	}
	
	public Set<Follower> dependents(){
		return _dependents;
	}
	
	public FirstSet firstSet(){
		return _set;
	}
}*/
