package com.compiler.ErrorHandle;

import com.compiler.Util.Token;

public class ErrorToken extends Token {
	
	public ErrorToken(String name,String source){
		super(name,source);
	}
	
	public ErrorToken(String name,String value,String source){
		super(name,source);
		this.value=value;
	}
}
