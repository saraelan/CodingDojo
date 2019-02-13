package com.codingdojo;


import javax.servlet.http.HttpSession;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ninja {
	@RequestMapping("/")
	public String index(Model model,HttpSession session) {
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities")==null) {
			ArrayList<String> activities = new ArrayList<>();
			session.setAttribute("activities", activities);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activities", session.getAttribute("activities"));
		return "index.jsp";
	}
	
	@RequestMapping(path="/gold", method=RequestMethod.POST)
	public String gold(Model model, HttpSession session, @RequestParam(value="gold") String place) {
		Random random = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		Date date = new Date();
		
		String activity;
		Integer earn = 0;
		
		
		
		if(place.equals("farm")) {
			earn = random.nextInt(10) + 10;
		}
		
		if(place.equals("cave")) {
			earn = (random.nextInt(5) + 5);
		}
		
		if(place.equals("house")) {
			earn = random.nextInt(3) + 2;
		}
		
		if(place.equals("casino")) {
			earn = random.nextInt(100) - 50;
		}
		
		if(place.equals("reset")) {
			session.setAttribute("gold", 0);
			ArrayList<String> act = new ArrayList<>();
			session.setAttribute("activities", act);
			return "redirect:/";

		}
		
		gold += earn;
		if (earn >= 0) {
			activity = String.format("You entered a %s and earned %d gold. (%s)", place, earn, date.toString());
		}
		else {
			activity = String.format("You entered a casino and lost %d gold...Ouch. (%s)", earn, date.toString());
		}
		
		activities.add(activity);
		session.setAttribute("gold", gold);
		session.setAttribute("activities", activities);

		return "redirect:/";
	}
}