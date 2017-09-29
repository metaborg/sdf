package org.metaborg.sdf2table.exceptions;

public class UnexpectedTermException extends Exception{
	private static final long serialVersionUID = 2895844459531185172L;
	
	String unexpected;
	String expected;
	
	public UnexpectedTermException(String unexpected, String expected){
		super("Unexpected term '" + unexpected + "'.\nExpected '" + expected + "'." );
		this.unexpected = unexpected;
		this.expected = expected;
	}
	
	public UnexpectedTermException(String unexpected){
        super("Unexpected term '" + unexpected + "'." );
        this.unexpected = unexpected;
    }
	
	public String unexpected(){
		return unexpected;
	}
	
	public String expected(){
		return expected;
	}
}
