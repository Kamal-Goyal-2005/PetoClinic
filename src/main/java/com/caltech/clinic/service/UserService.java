package com.caltech.clinic.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caltech.clinic.pogo.User;
import com.caltech.clinic.repo.UserRepository;

@Service
public class UserService {

	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	private UserRepository userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public String register(User login) {
		
		userService.save(login);
		return "User registered successfully";
	}
	
	public boolean validateuser(String name, String pwd) {
		
		String encodedpwd =  userService.validateuser(name);
		return (encodedpwd != null && passwordEncoder.matches(pwd, encodedpwd));
	}
	
	public boolean checkAdmin(String name, String pwd) {

		
        String encodedpwd =  userService.checkAdmin(name);
		return (encodedpwd != null && passwordEncoder.matches(pwd, encodedpwd));
	}
}
