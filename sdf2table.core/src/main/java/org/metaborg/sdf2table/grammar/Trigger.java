package org.metaborg.sdf2table.grammar;

public interface Trigger{
	public boolean isTerminal();
	
	public Trigger inter(Trigger other);
	public Trigger except(Trigger other);
	
	public String graphviz();
}
