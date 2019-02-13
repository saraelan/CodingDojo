package com.codingdojo.event.controllere;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.event.models.User;
import com.codingdojo.event.service.UserService;
import com.codingdojo.event.validator.UserValidator;



@Controller
public class Users {
	private final UserService userService;
	private final UserValidator userValidator;
	    
	    public Users(UserService userService, UserValidator userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	    }
	    
	    
	    
	    @RequestMapping("/")
	    public String registerForm(@ModelAttribute("user") User user,Model model)
	    {List<String> states = Arrays.asList("IL","WA","CA");
    	model.addAttribute("states",states);
	        return "index.jsp";
	    }
	    
//	    @RequestMapping("/login")
//	    public String login() {
//	        return "index.jsp";
//	    }
   
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model, HttpSession session) {
	    	userValidator.validate(user, result);
	    	if(result.hasErrors())
	    	{List<String> states = Arrays.asList("IL","WA","CA");
        	model.addAttribute("states",states);
	    		return "index.jsp";
	    	} else {
	    		User u = userService.registerUser(user);
	    		session.setAttribute("user",u.getId());
	    		return "redirect:/events";
	    	}
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	    	
	    	boolean check = userService.authenticateUser(email, password);
	    	if(check) {
	    		
	    		User user = userService.findByEmail(email);
	    		session.setAttribute("user", user.getId());
	    		return "redirect:/events";
	    		
	    		
	    	} else {
	    		List<String> states = Arrays.asList("IL","WA","CA");
	        	model.addAttribute("states",states);
	    		model.addAttribute("error", "Invalid login. Try again!");
	    		model.addAttribute("user",new User());
	    		return "index.jsp";
	    	}
	    }
	    
//	    @RequestMapping("/home")
//	    public String home(HttpSession session, Model model) {
////	    	if(session.getAttribute("id") == null) {
////	    		return "redirect:/registration";
////	    	}
//	        // get user from session, save them in the model and return the home page
//	    	System.out.println("home");
//	    	Long userId = (Long)session.getAttribute("userId");
//	    	User u = userService.findUserById(userId);
//	    	model.addAttribute("user", u);
//	    	
//	    	return "index.jsp";
	        // get user from session, save them in the model and return the home page
	    //}
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	        // redirect to login page
	    	System.out.println("logout");
	    	session.invalidate();
	    	return "redirect:/";

	}

}
