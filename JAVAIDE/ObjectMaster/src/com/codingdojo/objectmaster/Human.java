package com.codingdojo.objectmaster;

public class Human {
	
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;
	private String name;
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getStrength() {
		return strength;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntelligence() {
		return intelligence;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getStealth() {
		return stealth;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Human() {
		this.strength=3;
		this.stealth=3;
		this.intelligence=3;
		this.health=100;
		this.name="";
		
	}
	
	public void attack(Human name)
	
	{
		name.health-=strength;
	}
	
	
	
	

}
