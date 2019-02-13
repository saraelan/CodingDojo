package com.codingdojo.objectmaster;

public class Samurai extends Human{
	
	private int count;

	public Samurai() 
	{
		super();
		
		this.setHealth(200);
		
		count++;
		
		
	}
	
	public void deathBlow(Human name)
	{
		name.setHealth(0);
		setHealth(getHealth()/2);
	}
	
	public void meditate()
	{
		setHealth(getHealth()*1);
	}
	
	public int howMany()
	{
		return count;
	}
}
