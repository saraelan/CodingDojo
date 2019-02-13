package com.codingdojo.event.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;;

@Entity
@Table(name="messages")
public class Message {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="Message cannot by empty!")
    private String text;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event ;
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    
    private User p;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String text, Event event, User p) {
		this.text = text;
		this.event = event;
		this.p = p;
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getP() {
		return p;
	}
	public void setP(User p) {
		this.p = p;
	}

	

}
