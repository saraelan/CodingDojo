package com.codingdojo.objectmaster;

public class HumanTest {

	public HumanTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Human h = new Human();
		Human h1=new Human();
		h.attack(h1);
		System.out.println(h1.getHealth());
		
		Wizard w=new Wizard();
		w.heal(h1);
		w.fireball(h1);
		
		Ninja n =new Ninja();
		n.steal(h1);
		n.runAway();
		
		Samurai s=new Samurai();
		Samurai s1=new Samurai();
		Samurai s2=new Samurai();
		s1.deathBlow(s2);
		s.meditate();
		System.out.println(s1.howMany());
		
		
		
		

	}

}
