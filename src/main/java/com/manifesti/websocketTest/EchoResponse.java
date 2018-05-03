package com.manifesti.websocketTest;

public class EchoResponse {
	
	private String message;
	private String username;
	
    public EchoResponse(String username, String message) {
    	this.message = message;
    	this.username = username;
    }
    public EchoResponse() {
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
