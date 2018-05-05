package com.manifesti.websocketTest.Beans;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EchoResponse {

	@Id
	@GeneratedValue
	Long id;

	@Column
	@Lob
	private String message;
	private String username;
	private Date date = new Date();
	
    public EchoResponse(String username, String message) {
    	this.message = message;
    	this.username = username;
    	this.date = new Date();
    }
    public EchoResponse() {
    }
	public String getMessage() {
		return message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
