package com.codeOlogy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Controller
public class DigiNotesController {

	@GetMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
	
	@GetMapping("/editNotes")
	public String editNotes() {
		return "edit_notes";
	}
	
	@GetMapping("/viewNotes")
	public String ViewNotes() {
		return "view_notes";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
