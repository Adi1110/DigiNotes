package com.codeOlogy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.dao.NotesRepository;
import com.codeOlogy.entity.Notes;
import com.codeOlogy.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	public NotesRepository notesRepo;
	
	@Override
	public Notes saveNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesRepo.save(notes);
	}

	@Override
	public Notes getNotesById(int id) {
		// TODO Auto-generated method stub
		return notesRepo.findById(id).get();
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		// TODO Auto-generated method stub
		return notesRepo.findByUser(user);
	}

	@Override
	public Notes updateNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesRepo.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) {
		// TODO Auto-generated method stub
		Notes notesDel = notesRepo.findById(id).get();
		
		if(notesDel!=null) {
			notesRepo.delete(notesDel);
			return true;
		}
		
		return false;
	}

	
}
