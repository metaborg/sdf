package org.metaborg.sdf2table.exceptions;

public class ModuleNotFoundException extends Exception{
	private static final long serialVersionUID = 2895844459531185172L;
	
	String module;
	String requiredBy;
	
	public ModuleNotFoundException(String module, String requiredBy){
		super("Module not found '" + module + "'" + (requiredBy == null ? "" : " required by '" + requiredBy + "'"));
		this.module = module;
		this.requiredBy = requiredBy;
	}
	
	public String moduleName(){
		return module;
	}
	
	public String requiredBy(){
		return requiredBy;
	}
}
