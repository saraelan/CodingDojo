package com.codingdojo.belts.controllers;

import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.codingdojo.belts.models.*;

import com.codingdojo.belts.services.*;

import com.codingdojo.belts.validator.UserValidator;


@Controller
public class Users {
	private final UserService userService;
	private final UserValidator userValidator;
	private final ShowService showService;
	private final RatingService ratingService;

	public Users(UserService userService, UserValidator userValidator, ShowService showService,
			RatingService ratingService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.showService = showService;
		this.ratingService = ratingService;

	}

	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user, Model model) {
		return "index.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
			userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}

		else {
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {

		boolean check = userService.authenticateUser(email, password);
		if (check) {

			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			System.out.println("i am inside");
			return "redirect:/shows";

		} else {

			model.addAttribute("error", "Invalid login. Try again!");
			model.addAttribute("user", new User());
			return "index.jsp";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("logout");
		session.invalidate();
		return "redirect:/";

	}

	@RequestMapping("/shows")
	public String allshows(Model model, User user, HttpSession session) {
		System.out.println("here");
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User u = userService.findUserById(userId);
		model.addAttribute("user", u);
		List<Show> shows = showService.allShows();
		model.addAttribute("show", shows);
		return "showall.jsp";

	}

	@RequestMapping("shows/new")
	public String show(Model model, @ModelAttribute("show") Show show, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);

		return "new.jsp";
	}

	@PostMapping("shows/new")
	public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model,
			HttpSession session) {
		System.out.println("Now in new");
		if (result.hasErrors()) {
			return "new.jsp";
		}

		else {

			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			showService.create(show);
			return "redirect:/shows";

		}

	}

	@RequestMapping("shows/{id}/edit")
	public String editShow(@Valid @ModelAttribute("show") Show show, BindingResult result, @PathVariable("id") Long id,
			Model model, HttpSession session) {

		{
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			model.addAttribute("show", showService.findOne(id));
			return "edit.jsp";

		}

	}

	@PostMapping("shows/{id}/edit")
	public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result,
			@PathVariable("id") Long id, Model model, HttpSession session) {
		{
			if (result.hasErrors())

			{

				return "edit.jsp";
			}

			else

			{
				Long userId = (Long) session.getAttribute("userId");
				User user = userService.findUserById(userId);
				model.addAttribute("user", user);
				showService.update(show);
				return "redirect:/shows";
			}
		}

	}

	@RequestMapping("shows/{TVid}")
	public String show(@ModelAttribute("show") Show show,@PathVariable("TVid") Long id,@ModelAttribute("r") Rating rating, Model model,
			 HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			User users = userService.findUserById(userId);
			model.addAttribute("users",users);
			Show cur = showService.findOne(id);
			model.addAttribute("show", showService.findOne(id));
			List<Rating> rat = ratingService.findByShow(cur);
			model.addAttribute("rat", rat);
			
			
			
		
		return "shows.jsp";
	}

	@GetMapping("/shows/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		showService.deleteShow(id);
		return "redirect:/shows";
	}

	@PostMapping("shows/{Tvid}/rating")
	public String addRating(@Valid @ModelAttribute("r") Rating rating, BindingResult result,
			@PathVariable("Tvid") Long id, Model model, HttpSession session,RedirectAttributes flash) {
		{

			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}

			else if (result.hasErrors()) {
				System.out.println(result);
				return "shows.jsp";
			} 
			
			
			
			
			else  
			
			{

				User user = userService.findUserById(userId);
				model.addAttribute("user", user);

				List<Show> shows = showService.allShows();
				model.addAttribute("show", shows);
				System.out.println(rating.getRate());
				System.out.println(rating.getShow());
				rating.setUser(user);
				ratingService.create(rating);
				if(rating.getUser().getId() == user.getId())
				{
					flash.addAttribute("errors","only once");
					return  "redirect:/shows";
				}
				
				
				return "redirect:/shows";
			}
			
			
				
			
				
			
			}
			
			
			
			
			
		}}
	

