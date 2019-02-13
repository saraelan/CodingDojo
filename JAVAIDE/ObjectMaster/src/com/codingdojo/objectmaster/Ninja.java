package com.codingdojo.objectmaster;

public class Ninja extends Human{
	
	

	public Ninja() 
	{
		super();
		this.setStealth(10);
		
		
	}
	
	public void steal(Human name)
	{
		name.setHealth(name.getHealth() - getStealth());
	}
	
	public void runAway()
	{
		setHealth(getHealth()-10);
	}

}
