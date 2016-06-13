package org.metaborg.sdf2table.grammar;

public class ModuleNotFound extends Exception{
	private static final long serialVersionUID = 2895844459531185172L;
	
	String _module;
	Module _required_by;
	
	public ModuleNotFound(String module, Module required_by){
		super("Module not found `"+module+"'"+(required_by == null ? "" : " required by `"+required_by.name()+"'"));
		_module = module;
		_required_by = required_by;
	}
	
	public String moduleName(){
		return _module;
	}
	
	public Module requiredBy(){
		return _required_by;
	}
}
