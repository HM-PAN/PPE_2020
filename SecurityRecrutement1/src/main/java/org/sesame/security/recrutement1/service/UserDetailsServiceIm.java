package org.sesame.security.recrutement1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.sesame.security.recrutement1.entities.User;
import org.sesame.security.recrutement1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service

public class UserDetailsServiceIm implements UserDetailsService{
	@Autowired
	private UserRepository r;
	@Autowired
	private AccountService acc;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = acc.findbyusername(username);
		
		if(user ==null ) throw new UsernameNotFoundException("jfjjf");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new  org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}

}
