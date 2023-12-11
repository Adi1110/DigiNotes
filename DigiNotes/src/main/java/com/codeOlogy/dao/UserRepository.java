package com.codeOlogy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public boolean existsByEmail(String email);

	public User findByEmail(String email);

}
