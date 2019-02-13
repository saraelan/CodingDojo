package com.codingdojo.event.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;


import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.repository.EventRepository;

@Service
public class EventService {
private final EventRepository eventRepository;
public EventService(EventRepository eventRepository) 
{
		this.eventRepository=eventRepository;
}
		
		public List<Event> allEvents() 
		{
	        return eventRepository.findAll();
	    }
			
		public Event createEvent(Event e)
		{
	        return eventRepository.save(e);
	    }
	    
	    public Event findEvent(Long id) {
	        Optional<Event> optionalEvent = eventRepository.findById(id);
	        if(optionalEvent.isPresent()) {
	            return optionalEvent.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Event updateEvent(Long id, String name, Date date ,String city, String state) {
			Optional<Event> optionalEvent = eventRepository.findById(id);
			if(optionalEvent.isPresent()) 
			{
				Event event =optionalEvent.get();
				event.setName(name);
				event.setCity(city);
				event.setState(state);
				event.setDate(date);
				return eventRepository.save(event);
		    
				
			}
			else
			{
				return null;
			}
			
			
		}
		
		public void deleteEvent(Long id) {
	    	eventRepository.deleteById(id);
	    }
	    
		
		
		public List<Event> locEvents(String state){
			return eventRepository.findEventByState(state);
		}
		
		public List<Event> notEvents(String state){
			return eventRepository.findEventByOtherState(state);
		}
		
		public void joinEvent(Event e, User u) {
			List<User> joiners = e.getJoiners();
			joiners.add(u);
			e.setJoiners(joiners);
			eventRepository.save(e);
		}
		public void leaveEvent(Event e, User u) {
			List<User> joiners = e.getJoiners();
			joiners.remove(u);
			e.setJoiners(joiners);
			eventRepository.save(e);
		}
		public Long countJoins(Long id) {
			return eventRepository.countJoiners(id);
		}
	}


