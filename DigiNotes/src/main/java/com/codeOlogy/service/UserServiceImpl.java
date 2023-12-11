package com.codeOlogy.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.codeOlogy.dao.UserRepository;
import com.codeOlogy.entity.User;

/**
 * @author Aditya Ranjan
 * Youtube : @Code_O_logy
 * Website : blogsnax.com
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		user.setPassword(passwordencoder.encode(user.getPassword()));
		User newUser= userRepo.save(user);
		return newUser;
	}

	@Override
	public boolean existingEmailCheck(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	
	public void removeSessionMessage() {
		
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
				.getRequest().getSession();
		session.removeAttribute("msg");
	}
}
