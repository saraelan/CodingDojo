package com.codingdojo.event.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.*;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.Message;
@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3,message="Name cannot by empty!")
    private String name;
    @Size(min=3,message = "City is required!")
    private String city;
    @NotNull(message = "State can not be left blank")
    private String state;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Date is required!")
    private Date date;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User p;
    
    @OneToMany(mappedBy="event",fetch=FetchType.LAZY)
    private List<Message> messages;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_events",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="event_id"))
    private List<User>	joiners;
    
    
  

    
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(String name,String city, String state, Date date, User p) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.date = date;
		this.p = p;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public User getP() {
		return p;
	}
	public void setP(User p) {
		this.p = p;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<User> getJoiners() {
		return joiners;
	}
	public void setJoiners(List<User> joiners) {
		this.joiners = joiners;
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
