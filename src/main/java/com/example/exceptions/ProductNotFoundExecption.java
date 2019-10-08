package com.example.exceptions;

public class ProductNotFoundExecption extends Exception{
	
	

	private static final long serialVersionUID = 1L;

public ProductNotFoundExecption() {
	super();
}

public ProductNotFoundExecption(String errors) {
	super(errors);
}
}
