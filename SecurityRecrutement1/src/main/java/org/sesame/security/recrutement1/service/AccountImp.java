package org.sesame.security.recrutement1.service;


import javax.transaction.Transactional;

import org.sesame.security.recrutement1.entities.Role;
import org.sesame.security.recrutement1.entities.User;
import org.sesame.security.recrutement1.repository.RoleRepository;
import org.sesame.security.recrutement1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@Transactional

public class AccountImp implements AccountService {

	@Autowired
	private UserRepository ue;
	@Autowired
	  private  RoleRepository re;
	@Autowired
	private BCryptPasswordEncoder bc;
	@Override
	public User saveuser(User u) {
		String   str= bc.encode(u.getPassword());
		u.setPassword(str);

		return ue.save(u);
	}

	@Override
	public Role saverole(Role r) {
		// TODO Auto-generated method stub
		return re.save(r);
	}

	@Override
	public void addroletouser(String username, String role) {
		User u = ue.findByUsername(username);
		Role r = re.findByRoleName(role);
		u.getRoles().add(r);
		
	}

	@Override
	public User findbyusername(String str) {
		// TODO Auto-generated method stub
		return ue.findByUsername(str);
	}
}
