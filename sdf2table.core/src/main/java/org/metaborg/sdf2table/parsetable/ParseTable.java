package org.metaborg.sdf2table.parsetable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.metaborg.sdf2table.core.Benchmark;
import org.metaborg.sdf2table.grammar.Exportable;
import org.metaborg.sdf2table.grammar.Module;
import org.metaborg.sdf2table.grammar.ModuleNotFound;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Syntax;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public class ParseTable{ // TODO extends ParseTable from Set<State>.
	public static final int VERSION = 6;
	
	private static final StrategoConstructor CONS_PT = new StrategoConstructor("parse-table", 5);
	private static final StrategoConstructor CONS_STATES = new StrategoConstructor("states", 1);
	private static final StrategoConstructor CONS_PRIORITIES = new StrategoConstructor("priorities", 1);
	
	private List<State> _states = new LinkedList<>();
	private Syntax _syntax;
	
	private Queue<State> _queue  = new LinkedList<>();

	public ParseTable(Syntax syntax){
		_syntax = syntax;
	}
	
	public void build(){
		Benchmark.ComposedTask task = Benchmark.newComposedTask("parse table generation");
		task.start();
		
		Benchmark.SingleTask t_ff = task.newSingleTask("FIRST and FOLLOW computation");
		Benchmark.SingleTask t_sg = task.newSingleTask("states generation");	
		
		Production start = _syntax.startProduction();
			
		t_ff.start();
		_syntax.computeFollowSets();
		t_ff.stop();
		
		t_sg.start();
		State s0 = new State(this);
		s0.addItem(new Item(start, 0));
		
		
		addState(s0);
		processQueue();
		t_sg.stop();
		
		task.stop();
	}
	
	public State addState(State state){
		state.close();
		
		for(State s : _states){ // Avoid state duplication
			if(s.equals(state))
				return s;
		}
		
		state.assignId(_states.size());
		_states.add(state);
		_queue.add(state);
		
		return state;
	}
	
	public void processQueue(){
		while(!_queue.isEmpty()){
			State state = _queue.poll();
			state.shift();
		}
	}
	
	public static ParseTable fromSyntax(Syntax syntax){
		ParseTable table = new ParseTable(syntax);
		
		table.build();
		
		return table;
	}
	
	public static void fromFile(File input, File output, List<String> paths){
		Syntax syntax = null;
		try{
			syntax = Module.fromFile(input, paths);
		}catch (ModuleNotFound e){
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		ParseTable pt = ParseTable.fromSyntax(syntax);
				
		IStrategoTerm result = pt.toATerm();
        if(output != null){
	        FileWriter out = null;
	        try{
				out = new FileWriter(output);
				
				out.write(result.toString());
				
				out.close();
			}catch (IOException e){
				System.err.println(e.getMessage());
			}
        }else{
        	System.out.println(result.toString());
        }
        
        State.reset();
        Production.reset();
	}
	
	
	public int getInitialState(){
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public IStrategoTerm toATerm(){
		ArrayList<IStrategoTerm> labels = new ArrayList<>();
		ArrayList<IStrategoTerm> priorities = new ArrayList<>();
		
		for(Production p : _syntax.productions()){
			labels.add(p.toATerm());
			
			for(Priority prio : p.priorities()){
				priorities.addAll(prio.toATerms());
			}
		}
		
		return new StrategoAppl(
				CONS_PT,
				new IStrategoTerm[]{
						new StrategoInt(VERSION, null, 0),
						new StrategoInt(getInitialState(), null, 0),
						Utilities.strategoListFromCollection(labels),
						new StrategoAppl(
								CONS_STATES,
								new IStrategoTerm[]{
										Utilities.strategoListFromExportables((Collection<Exportable>)(Object)_states)
								},
								null,
								0
						),
						new StrategoAppl(
								CONS_PRIORITIES,
								new IStrategoTerm[]{
										Utilities.strategoListFromCollection(priorities)
								},
								null,
								0
						)
				},
				null,
				0
		);
	}
	
	public String digraph(){
		String str = "digraph g{\n";
		str += "graph [rankdir = \"LR\"];\n";
		
		for(State s : _states){
			str += s.digraph();
		}
		
		str += "}";
		return str;
	}
}
