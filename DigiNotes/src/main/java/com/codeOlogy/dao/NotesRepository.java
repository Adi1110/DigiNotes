package com.codeOlogy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.entity.Notes;
import com.codeOlogy.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface NotesRepository extends JpaRepository<Notes, Integer>{

	public List<Notes> findByUser(User user);
}
