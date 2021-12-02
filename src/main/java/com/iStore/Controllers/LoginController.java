package com.iStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iStore.Entity.User;
import com.iStore.Repository.UserRepo;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	UserRepo userrepo;
	
	@PostMapping("/newuser")
	public User signUp(@RequestBody User newuser) {
		userrepo.save(newuser);
		System.out.println(newuser);
		return newuser;
	}
	
	@PostMapping("/user")
	public User logIn(@RequestBody User verifyuser) {
		
		User user = userrepo.findByUserEmail(verifyuser.getUserEmail());
		if(user.getUserPassword().equals(verifyuser.getUserPassword())) {
			return user;
		}
		return new User();
	}	
//	@PostMapping("/user")
//	public ResponseEntity<User> createUser(@Valid @RequestBody User user)     
//	{  
//	User savedUser=userrepo.save(user);    
//	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();  
//	return ResponseEntity.created(location).build();  
//	}  
}
