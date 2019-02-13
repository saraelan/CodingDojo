package com.codingdojo.aut.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.aut.model.User;
import com.codingdojo.aut.service.UserService;
import com.codingdojo.aut.validator.UserValidator;

@Controller
public class Users {
private final UserService userService;
private final UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
//    	System.out.println("reg post");
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId",u.getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	System.out.println("login post");
    	boolean check = userService.authenticateUser(email, password);
    	if(check) {
    		
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    		
    		
    	} else {
    		model.addAttribute("error", "Invalid login. Try again!");
    		return "loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
//    	if(session.getAttribute("id") == null) {
//    		return "redirect:/registration";
//    	}
        // get user from session, save them in the model and return the home page
    	System.out.println("home");
    	Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
    	
    	return "homePage.jsp";
        // get user from session, save them in the model and return the home page
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	System.out.println("logout");
    	session.invalidate();
    	return "redirect:/login";

}
}
