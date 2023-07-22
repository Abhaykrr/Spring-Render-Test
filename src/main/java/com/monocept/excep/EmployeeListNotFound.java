package com.monocept.excep;

public class EmployeeListNotFound  extends RuntimeException{
	
	private String message;

	public EmployeeListNotFound(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
