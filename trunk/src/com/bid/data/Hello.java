package com.bid.data;

// default package
// Generated 2010-1-3 10:10:24 by Hibernate Tools 3.2.4.GA

/**
 * Hello generated by hbm2java
 */
public class Hello implements java.io.Serializable {

	private int idhello;
	private String name;

	public Hello() {
	}

	public Hello(int idhello) {
		this.idhello = idhello;
	}

	public Hello(int idhello, String name) {
		this.idhello = idhello;
		this.name = name;
	}

	public int getIdhello() {
		return this.idhello;
	}

	public void setIdhello(int idhello) {
		this.idhello = idhello;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}