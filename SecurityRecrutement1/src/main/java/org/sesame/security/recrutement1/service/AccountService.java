package org.sesame.security.recrutement1.service;

import org.sesame.security.recrutement1.entities.Role;
import org.sesame.security.recrutement1.entities.User;
import org.springframework.stereotype.Service;


public interface AccountService {
	public User saveuser(User u);
	public Role saverole(Role r);
	public void  addroletouser(String username, String role);
	public User findbyusername(String str);

}
