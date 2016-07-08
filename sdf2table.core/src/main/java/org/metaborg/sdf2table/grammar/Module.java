package org.metaborg.sdf2table.grammar;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public class Module{
	private String _name;
	private Syntax _syntax;
	private Collection<Module> _dependencies = new LinkedList<>();
	
	private final static ITermFactory _factory = new TermFactory();
	
	public Module(String name, Syntax syntax){
		_name = name;
		_syntax = syntax;
	}
	
	public String name(){
		return _name;
	}
	
	public Syntax syntax(){
		return _syntax;
	}
	
	public SymbolCollection symbols(){
		return _syntax.symbols();
	}
	
	public void addDependency(Module dep){
		_dependencies.add(dep);
	}
	
	public Collection<Module> dependencies(){
		return _dependencies;
	}
	
	private static IStrategoTerm termFromFile(File file){
		FileReader reader = null;
		IStrategoTerm term = null;
		
		try{
			reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        String aterm = new String(chars);
	        reader.close();
			
		    term = _factory.parseFromString(aterm);
		}catch (IOException e) {
			System.err.println("Cannot open module file `"+file.getPath()+"'");
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		
		return term;
	}
	
	public static Syntax fromFile(File file, List<String> paths) throws ModuleNotFound{
		return fromStrategoTerm(termFromFile(file), paths);
	}
	
	public static Module fromFile(File file, List<String> paths, Map<String, UnloadedModule> modules, Syntax syntax) throws ModuleNotFound{
		return fromStrategoTerm(termFromFile(file), paths, modules, syntax);
	}
	
	public static Syntax fromStrategoTerm(IStrategoTerm term, List<String> paths) throws ModuleNotFound{
		Map<String, UnloadedModule> modules = new HashMap<>();
		Syntax syntax = new Syntax();
		fromStrategoTerm(term, paths, modules, syntax);
		
		//Set<Module> loaded_modules = new HashSet<>();
		for(Entry<String, UnloadedModule> e : modules.entrySet()){
			e.getValue().loadSyntax();
		}
		
		for(Entry<String, UnloadedModule> e : modules.entrySet()){
			UnloadedModule module = e.getValue();
			module.loadRestrictions();
			module.loadPriorities();
			
			//loaded_modules.add(module);
		}
		
		return syntax;
	}
	
	public static Module fromStrategoTerm(IStrategoTerm term, List<String> paths, Map<String, UnloadedModule> modules, Syntax syntax) throws ModuleNotFound{
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Module")){
				// Module attributes
				String name = "";
				// Get module name from: Unparameterized("<name>")
				StrategoString tname = (StrategoString)app.getSubterm(0).getSubterm(0);
				name = tname.stringValue();
				
				UnloadedModule module = new UnloadedModule(name, syntax);
				modules.put(name, module);
				
				// Dependencies
				for(IStrategoTerm t : (StrategoList)app.getSubterm(1)){
					if(t instanceof StrategoAppl && ((StrategoAppl)t).getName().equals("Imports")){
						for(IStrategoTerm timport : (StrategoList)t.getSubterm(0)){
							if(timport instanceof StrategoAppl && ((StrategoAppl)timport).getName().equals("Module")){
								String iname = null;
								
								switch(((StrategoAppl)timport.getSubterm(0)).getName()){
								case "Unparameterized":
									iname = ((StrategoString)timport.getSubterm(0).getSubterm(0)).stringValue();
									break;
								case "Parameterized":
									break;
								default:
									break;
								}
								
								if(iname != null){
									Module dep = modules.get(iname);
									if(dep == null){
										for(String path : paths){
											String filename = path+"/"+iname+".aterm";
											File file = new File(filename);
											if(file.exists() && !file.isDirectory()){
												dep = fromFile(new File(filename), paths, modules, syntax);
												module.addDependency(dep);
												
												break;
											}
										}
									}
									
									if(dep == null){
										throw new ModuleNotFound(iname, module);
									}
								}
							}
						}
					}
				}
				
				// Get sections
				StrategoList sdf_sections = (StrategoList)app.getSubterm(2);
				for(IStrategoTerm t : sdf_sections){
					StrategoAppl tsection = (StrategoAppl)t.getSubterm(0);
					switch(tsection.getName()){
					case "Kernel":
						module.setSyntaxTerm(tsection);
						break;
					case "Restrictions":
						module.setRestrictionsTerm(tsection);
						break;
					case "Priorities":
						module.setPrioritiesTerm(tsection);
						break;
					default:
						System.err.println("Unknown module section `"+tsection.getName()+"'");
						break;
					}
				}
				
				return module;
			}
		}
		return null;
	}
}
