package com.codingdojo.event.controllere;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.Message;
import com.codingdojo.event.models.User;
import com.codingdojo.event.service.EventService;
import com.codingdojo.event.service.MessageService;
import com.codingdojo.event.service.UserService;


@Controller
@RequestMapping("/events")
public class EventController {
	
	private final EventService eventService;
	private final UserService userService;
	private final MessageService messageService;
	
	public EventController(EventService eventService,UserService userService,MessageService messageService) {
        this.eventService=eventService;
        this.userService=userService;
        this.messageService=messageService;
    }
	
	
	@RequestMapping("")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long id = (Long) session.getAttribute("user");
		if (id == null) {
			return "redirect:/";
		}
		User user = userService.findUserById(id);
    	model.addAttribute("user", user);
	    List<Event> localEvents = eventService.locEvents(user.getState());
	    model.addAttribute("localEvents", localEvents);
    	List<Event> notEvents = eventService.notEvents(user.getState());
    	model.addAttribute("notEvents", notEvents);
    	List<String> states = Arrays.asList("IL","WA","CA");
    	model.addAttribute("states",states);
	    return "events.jsp";
	    
	    
	    
	    
	}
    

//	@RequestMapping("/events")
//    public String newEvent(@ModelAttribute("event") Event event) {
//        return "events.jsp";
//    }
    @RequestMapping(value="" , method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("event") Event event, Model model, BindingResult result,HttpSession session) {
        if (result.hasErrors())
        {
        	Long id = (Long) session.getAttribute("user");
        	User user = userService.findUserById(id);
	    	model.addAttribute("user", user);
	    	List<Event> localEvents = eventService.locEvents(user.getState());
	    	model.addAttribute("localEvents", localEvents);
	    	List<Event> notEvents = eventService.notEvents(user.getState());
	    	model.addAttribute("notEvents", notEvents);
	    	List<String> states = Arrays.asList("IL","WA","CA");
	    	model.addAttribute("states",states);
	    	
        	
            return "events.jsp";
        } else {
            eventService.createEvent(event);
            return "redirect:/events/";
        }
    }
    
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long eventID, Model model,HttpSession session)
    {Long id = (Long) session.getAttribute("user");
	if (id == null) {
		return "redirect:/";
	}
         Event event = eventService.findEvent(eventID);
         model.addAttribute("event",event);
         User user = userService.findUserById(id);
         model.addAttribute("user",user);
         if(event.getP().getId()!=user.getId())
         {
        	 return "redirect:/events";         }
         
         List<String> states = Arrays.asList("IL","WA","CA");
        model.addAttribute("states",states);
        model.addAttribute("event", event);
        
        return "edit.jsp";
    }
    
    @RequestMapping(value="/{id}/edit", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("event") Event event,Model model, BindingResult result,@PathVariable("id") Long eventID) {
        if (result.hasErrors()) {
        	List<String> states = Arrays.asList("IL","WA","CA");
        	model.addAttribute("states",states);
            return "edit.jsp";
        } else {
            eventService.updateEvent(eventID,event.getName(),event.getDate(),event.getCity(),event.getState());
            return "redirect:/events/"+eventID;
        }
    }
    
    @RequestMapping("/{id}/delete")
    public String destroy(@PathVariable("id") Long eventID,HttpSession session) {
    	Long id = (Long) session.getAttribute("user");
		if (id == null) {
			return "redirect:/";
		}
		Event event = eventService.findEvent(eventID);
		User user = userService.findUserById(id);
		if(event.getP().getId() != user.getId() ) {
			return "redirect:/events";
		}
		eventService.deleteEvent(eventID);
		return "redirect:/events";
	}
    
    
    @RequestMapping("/{id}")
	public String findEvent(HttpSession session, Model model, @PathVariable("id") Long eventID, @ModelAttribute("message") Message message) {
		Long id = (Long) session.getAttribute("user");
		if (id == null) {
			return "redirect:/";
		}
		User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	Event event = eventService.findEvent(eventID);
    	model.addAttribute("event",event);
    	Long joiners = eventService.countJoins(eventID);
    	model.addAttribute("joiners", joiners);
		return "message.jsp";
	}
    
    @RequestMapping("/{id}/join")
	public String join(@PathVariable("id") Long eventID, HttpSession session) {
		Long id = (Long) session.getAttribute("user");
		if (id == null) {
			return "redirect:/";
		}
		Event event = eventService.findEvent(eventID);
		User user = userService.findUserById(id);
		eventService.joinEvent(event, user);
		return "redirect:/events";
	}
	@RequestMapping("/{id}/cancel")
	public String cancel(@PathVariable("id") Long eventID, HttpSession session) {
		Long id = (Long) session.getAttribute("user");
		if (id == null) {
			return "redirect:/";
		}
		Event event = eventService.findEvent(eventID);
		User user = userService.findUserById(id);
		eventService.leaveEvent(event, user);
		return "redirect:/events";
	}
	
	@RequestMapping(value="/{id}/message", method=RequestMethod.POST)
	public String Message(@Valid @ModelAttribute("message") Message message, @PathVariable("id") Long eventID, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Long id = (Long) session.getAttribute("user");
			User user = userService.findUserById(id);
			model.addAttribute("user", user);
			Event event = eventService.findEvent(eventID);
			model.addAttribute("event",event);
			return "message.jsp";
		}else {
	  		messageService.createMessage(message);
	   		return "redirect:/events/"+eventID;
	   	}
	}
	
	
}
