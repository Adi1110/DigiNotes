package com.codeOlogy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeOlogy.entity.User;
import com.codeOlogy.service.UserService;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Controller
public class DigiNotesController {

	
	@Autowired
	private UserService userService;
		
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {
		//System.out.println(user);
		
		boolean emailExists = userService.existingEmailCheck(user.getEmail());
		
		
		if(emailExists) {
			session.setAttribute("msg","Email already exists!");
		}else {
			User newUser = userService.saveUser(user);
			if(newUser!=null) {
				session.setAttribute("msg","Resgistration Successful!");
			}else {
				session.setAttribute("msg","Something went wrong!");
			}
			
		}
		return "redirect:/register";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
}
