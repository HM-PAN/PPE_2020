package org.sesame.security.recrutement1.controller;

import java.util.List;

import org.sesame.security.recrutement1.entities.User;
import org.sesame.security.recrutement1.repository.UserRepository;
import org.sesame.security.recrutement1.service.AccountImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class AccountController {
	@Autowired
	private AccountImp u;
	@Autowired
	private UserRepository ur;
	
	
	@PostMapping("/add")
	public User adduser(@RequestBody User user) {
		
		return u.saveuser(user);
	}
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping ("/get")
	public List<User> get (){
		return ur.findAll();
	}

}
