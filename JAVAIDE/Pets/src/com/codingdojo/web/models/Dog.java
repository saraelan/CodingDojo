package com.codingdojo.web.models;

public class Dog extends Animal implements Pet{
	public String test;

	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
		test = "hello";
	}
	
	public String showAffection() {
		return "Your "+this.getBreed()+". "+this.getName() + "  looked at you with some affection .You Think";
	}
}
