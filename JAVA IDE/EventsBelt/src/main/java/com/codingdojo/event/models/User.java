package com.codingdojo.event.models;


import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=3, message = "Email is required!")
    @Email(message="Must be a valid email!")
    private String email;
    @Size(min=3, message = "First name is required!")
    private String firstName;
    @Size(min=3,message = "Last name is required!")
    private String lastName;
    @Size(min=3,message = "City is required!")
    private String city;
    @NotNull(message = "State can not be left blank")
    private String state;
    @Size(min=5, message="Password must be at least 5 characters!")
    private String password;
    @Transient
    private String passwordConfirmation;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Single host for many events//
    @OneToMany(mappedBy="p",fetch=FetchType.LAZY)
    private List<Event> myevents;
    
    //many users can have many events -joiners //
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_events",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="event_id"))
    private List<Event>	joinedevents;
	
    //Host can hav many messages//
    @OneToMany(mappedBy="p", fetch = FetchType.LAZY)
    private List<Message> messages;	
	
    public User()
    {}

	public User(String email, String password) {
    	this.password = password;
    	this.email = email;
    }
	
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Event> getJoinedevents() {
		return joinedevents;
	}
	public void setJoinedevents(List<Event> joinedevents) {
		this.joinedevents = joinedevents;
	}
	 
		@PrePersist
	    protected void onCreate(){
	   this.createdAt = new Date();
	    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	


}
