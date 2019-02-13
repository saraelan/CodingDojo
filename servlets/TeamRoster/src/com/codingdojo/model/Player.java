package com.codingdojo.model;

public class Player {
	protected String firstname;
	protected String lastname;
	protected int age;
	
	public Player(String first, String last,int age) {
		this.firstname = first;
		this.lastname = last;
		this.age = age;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public int getAge() {
		return this.age;
	}

}
