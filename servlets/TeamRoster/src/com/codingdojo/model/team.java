package com.codingdojo.model;

import java.util.ArrayList;

public class team {
	
protected String TeamName;
protected ArrayList<Player> player = new ArrayList<Player>();

ArrayList<team> t = new ArrayList<team>();
	
	public team(String name) {
		this.TeamName = name;
	}
	
	public String getTeamName() {
		return this.TeamName;
	}
	
	public int getSize() {
		return player.size();
	}
	
	public void setList(ArrayList<Player> p) {
		player = p;
	}
	
	public ArrayList<Player> getPlayers() {
		return player;
	}
	public void setTeamList(ArrayList<team> team) {
		this.t= team;
	}
	
	
	public ArrayList<team> getTeamList(){
		return t;
	}


}
