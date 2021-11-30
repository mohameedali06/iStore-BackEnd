package com.iStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStore.Entity.User;
import com.iStore.Repository.UserRepo;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	UserRepo userrepo;
	
	@PostMapping("/newuser")
	public User signUp(User newuser) {
		
		userrepo.save(newuser);
		return newuser;
	}
	
	@PostMapping("/user")
	public User logIn(User verifyuser) {
		
		User user = userrepo.findByEmail(verifyuser.getUserEmail());
		if(user.getUserPassword().equals(verifyuser)) {
			return user;
		}
		return new User();
	}
	
	
	
}
