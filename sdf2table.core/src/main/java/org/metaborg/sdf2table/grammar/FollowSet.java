package org.metaborg.sdf2table.grammar;

public class FollowSet extends Follower{
	Production _production;
	
	public FollowSet(Production prod){
		_production = prod;
	}
	
	public void computeDependencies(){
		// nothing to do.
	}
	
	@Override
	public String toString(){
		return "FOLLOW("+_production.toString()+")";
	}
}
