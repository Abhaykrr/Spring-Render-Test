package com.monocept.excep;

public class EmployeeError {
	
	private int status;
	private String body;
	private long milliseconds;
	
	public EmployeeError(int status, String body, long milliseconds) {
		super();
		this.status = status;
		this.body = body;
		this.milliseconds = milliseconds;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	
	

}
