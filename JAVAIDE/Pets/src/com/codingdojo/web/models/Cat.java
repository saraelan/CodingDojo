package com.codingdojo.web.models;

public class Cat extends Animal implements Pet{

	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
	}

	
	public String showAffection() {
		return "Your "+this.getBreed()+". "+this.getName() + "  looked at you with some affection .You Think";
	}
}
