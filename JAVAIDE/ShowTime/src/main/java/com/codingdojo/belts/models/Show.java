package com.codingdojo.belts.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {


	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Size(min=3, message = "Show Name is required!")
	private String showname;
	
	@Size(min=1, message = "Network is required!")
    private String network;
	
	private Long avgRating;
	
	private Date createdAt;
	private Date updatedAt;
	

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_shows", 
        joinColumns = @JoinColumn(name = "show_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

	
//	 public void addShows(Show s) {
//	    	List<Show> sh = this.shows;
//	    	sh.add(s);
//	    	this.setShows(sh);
//	    }

	 
	@PrePersist
	protected void onCreate(){
		this.updatedAt = new Date();
	    this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	


        		
public Show() {
		
	}
	
	public Show(String showname, String network, long avgRating) {
		this.avgRating=avgRating;
		this.showname=showname;
		this.network=network;
		this.createdAt = new Date();
		this.updatedAt = new Date();
		
		
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowname() {
		return showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Long getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Long avgRating) {
		this.avgRating = avgRating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	



	
	

	
	
	
}
