package org.metaborg.sdf2table.symbol;

public class Start extends Sort {
	public Start(){
		super("<START>");
	}
	
	@Override
	public boolean isStart(){
		return true;
	}
	
	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Start){
			return other != null;
		}
		return false;
	}
}
