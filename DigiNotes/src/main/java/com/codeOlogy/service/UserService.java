package com.codeOlogy.service;

import com.codeOlogy.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

public interface UserService {

	public User saveUser (User user);
	public boolean existingEmailCheck (String email);
}
