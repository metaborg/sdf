package org.metaborg.sdf2table.symbol;

public class FileStart extends Sort{
	public FileStart(){
		super("<Start>");
	}
	
	@Override
	public boolean isFileStart(){
		return true;
	}
	
	@Override
	public boolean equals(Symbol other){
		if(other instanceof FileStart){
			return other != null;
		}
		return false;
	}
}
