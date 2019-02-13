package com.codingdojo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class survey {

	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping(path="/reg", method=RequestMethod.POST)
	public String reg(HttpSession session,
			
			@RequestParam(value="name",required=true) String name, 
			@RequestParam(value="location",required=true) String location,
			@RequestParam(value="language",required=true) String language,
			@RequestParam(value="comment",required=false) String comment)
	
	
	{
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping("result")
	public String result(HttpSession session,Model model)
	
	{	
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("locaation"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		
		return "result.jsp";
	}
	
	

	
	
	}
	
	

