package org.sesame.security.recrutement1.controller;

import org.sesame.security.recrutement1.entities.Role;
import org.sesame.security.recrutement1.entities.User;
import org.sesame.security.recrutement1.service.AccountImp;
import org.sesame.security.recrutement1.service.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/register")
public class ApplicationController {
	@Autowired
	private AccountImp u;
	
	@PostMapping("/addCandidat")
	public User register(@RequestBody RegisterForm uform) {
		if(! uform.getPassword().equals(uform.getRepassword())) throw new RuntimeException("comfirmed your password");
		 User user1 = u.findbyusername(uform.getUsername());
		 if(user1 != null) throw new RuntimeException("this user existed");
		
		User user = new User();
		user.setUsername(uform.getUsername());
		user.setPassword(uform.getPassword());
		 u.saveuser(user);
		 u.addroletouser(user.getUsername(), "CANDIDAT");
		 //u.addroletouser(user.getUsername(), "ADMIN");
		
		 return user;
		
		
		
	}
	@PostMapping("/add/recruteur")
	public User registr(@RequestBody RegisterForm uform) {
		if(! uform.getPassword().equals(uform.getRepassword())) throw new RuntimeException("comfirmed your password");
		 User user1 = u.findbyusername(uform.getUsername());
		 if(user1 != null) throw new RuntimeException("this user existed");
		
		User user = new User();
		user.setUsername(uform.getUsername());
		user.setPassword(uform.getPassword());
		 u.saveuser(user);
		 //u.addroletouser(user.getUsername(), "candidat");
		 u.addroletouser(user.getUsername(), "RECRUTEUR");
		
		 return user;
		
		
		
	}
	
	
	
	@GetMapping("/auth")
	public String auth() {
		return "bienvenue ...";
	}

}
