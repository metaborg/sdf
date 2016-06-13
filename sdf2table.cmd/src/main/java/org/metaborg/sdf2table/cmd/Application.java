package org.metaborg.sdf2table.cmd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.metaborg.sdf2table.core.Benchmark;
import org.metaborg.sdf2table.grammar.Module;
import org.metaborg.sdf2table.grammar.ModuleNotFound;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.sdf2table.parsetable.State;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class Application{
	public static final float VERSION = 1.0f;
	public static final String APP_NAME = "sdf2table";
	
	public static void usage(String path, PrintStream out){
		out.println("Use this program to generate a parse table from an SDF definition");
		out.println("It can only generate tables from parse trees of full SDF definition");
		out.println("files, or search for modules itself using a search path.\n");
		
		out.println("Common usage pattern:");
		out.println("\t"+path+" -i <definitionFile>.aterm -o <file>.tbl\n");
		
		out.println("Usage: "+path+" [options]\nOptions:");
		out.println("\t-D filename\t\twrite a graphviz file from the parse table");
		out.println("\t-h\t\tdisplay help information (usage)");
		out.println("\t-i filename\t\tinput from file");
		out.println("\t-o filename\t\tinput to file (default stdout)");
		out.println("\t-p path\t\tcolon separated search path for SDF modules (default '.')");
		out.println("\t-V\t\treveal program version (i.e. "+String.valueOf(VERSION)+")");
	}
	
	public static String readNext(String argv[], int i){
		if(i >= argv.length)
			return "";
		return argv[i];
	}
	
	public static void main(String argv[]){
		List<String> paths = new LinkedList<>();

		String input = null;
		String output = null;
		String dot_output = null;
		
		for(int i = 0; i < argv.length; ++i){
			switch(argv[i]){
			case "-i":
				input = readNext(argv, ++i);
				break;
			case "-o":
				output = readNext(argv, ++i);
				break;
			case "-p":
				paths = Arrays.asList(readNext(argv, ++i).split(":"));
				break;
			case "-D":
				dot_output = readNext(argv, ++i);
				break;
			case "-h":
				usage(APP_NAME, System.out);
				return;
			case "-V":
				System.out.println(String.valueOf(VERSION));
				return;
			default:
				System.err.println(argv[0]+": invalid option -- '"+argv[i]+"'");
				usage(APP_NAME, System.err);
				return;
			}
		}
		
		if(paths.isEmpty())
			paths.add(".");
		
		if(input == null){
			System.err.println(APP_NAME+": no input given");
			usage(APP_NAME, System.err);
			return;
		}
		
		exec(input, output, paths, dot_output);
	}
	
	public static void exec(String input, String output, List<String> paths, String dot_output){
		Benchmark.SingleTask t_import = Benchmark.main.newSingleTask("import");
    	Benchmark.ComposedTask t_generate = Benchmark.main.newComposedTask("generation");
    	Benchmark.SingleTask t_export = Benchmark.main.newSingleTask("export");
    	
    	t_import.start();
    	Syntax syntax = null;
		try{
			syntax = Module.fromFile(new File(input), paths);
		}catch (ModuleNotFound e){
			System.err.println(e.getMessage());
			System.exit(1);
		}
		t_import.stop();
    	
    	t_generate.start();
        ParseTable pt = ParseTable.fromSyntax(syntax);
        t_generate.stop();
		
		t_export.start();
        IStrategoTerm result = pt.toATerm();
        if(output != null){
	        File file = new File(output);
	        FileWriter out = null;
	        try{
				out = new FileWriter(file);
				
				out.write(result.toString());
				
				out.close();
			}catch (IOException e){
				System.err.println(e.getMessage());
			}
        }else{
        	System.out.println(result.toString());
        }
        
        if(dot_output != null){
        	generateGraphvizFile(Paths.get(dot_output), pt);
        }
        
        t_export.stop();
        
        Benchmark.print();
        Benchmark.reset();
        State.reset();
        Production.reset();
	}
    
	static void generateGraphvizFile(Path file, ParseTable pt){
    	try {
			Files.write(file, pt.digraph().getBytes());
			System.err.println("Graphiv written at: "+file.toAbsolutePath().toUri().getPath());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
    }
}
