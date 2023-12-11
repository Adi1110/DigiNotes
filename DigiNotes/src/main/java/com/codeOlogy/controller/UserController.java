package com.codeOlogy.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeOlogy.dao.UserRepository;
import com.codeOlogy.entity.Notes;
import com.codeOlogy.entity.User;
import com.codeOlogy.service.NotesService;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private NotesService notesService;
	
	@ModelAttribute
	public User getUser(Principal p, Model m) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		return user;
	}

	
	@GetMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
	
	@GetMapping("/editNotes/{id}")
	public String editNotes(@PathVariable int id, Model m) {
		Notes notes1 = notesService.getNotesById(id);
		m.addAttribute("n", notes1);
		return "edit_notes";
	}
	
	@GetMapping("/viewNotes")
	public String ViewNotes(Model m, Principal p) {
		User user = getUser(p, m);
		List<Notes> notesByUser = notesService.getNotesByUser(user);
		m.addAttribute("notesList", notesByUser);
		return "view_notes";
	}
	
	
	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
	
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		
		Notes saveNotes = notesService.saveNotes(notes);
		
		if(saveNotes!=null) {
			session.setAttribute("msg","Notes save Successful!");
		}else {
			session.setAttribute("msg","Something went wrong!");
		}
		
		return "redirect:/user/addNotes";
	}
	
	@PostMapping("/updateNotes")
	public String updateNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
	
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		
		Notes saveNotes = notesService.saveNotes(notes);
		
		if(saveNotes!=null) {
			session.setAttribute("msg","Notes update Successful!");
		}else {
			session.setAttribute("msg","Something went wrong!");
		}
		
		return "redirect:/user/viewNotes";
	}
	
	
	@GetMapping("/deleteNotes/{id}")
	public String deleteNotes(@PathVariable int id, HttpSession session) {
		
		boolean f = notesService.deleteNotes(id);
		
		if(f) {
			session.setAttribute("msg","Notes Deleted Successfully");
		}else {
			session.setAttribute("msg","Something went wrong!");
		}
		
		
		return "redirect:/user/viewNotes";
	}
}
