package com.codingdojo.objectmaster;

public class Wizard extends Human{
	
	

	public Wizard() 
	{
		super();
		this.setIntelligence(10);
		this.setHealth(50);
		
		
	}
	
	public void heal(Human name)
	{
		name.setHealth(name.getHealth() + getIntelligence());
	}
	
	public void fireball(Human name)
	{
		name.setHealth(name.getHealth() - getIntelligence()*3);
	}

}
