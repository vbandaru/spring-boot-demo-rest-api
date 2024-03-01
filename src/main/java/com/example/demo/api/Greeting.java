package com.example.demo.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.IllegalStateException;

public class Greeting {
	
	private long id;
	
	private String content;
	private String sig;
	
	public Greeting(long id, String content) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		md5.update(String.format("%d-%s", id, content).getBytes());

		this.id = id;
		this.content = content;
		this.sig = md5.digest().toString().substring(3);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}

}

