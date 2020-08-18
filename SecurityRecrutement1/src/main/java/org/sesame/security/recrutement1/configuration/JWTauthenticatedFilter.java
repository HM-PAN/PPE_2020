package org.sesame.security.recrutement1.configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sesame.security.recrutement1.entities.User;
import org.sesame.security.recrutement1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTauthenticatedFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository ur;
	public JWTauthenticatedFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		User user ;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), User.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("userame"+ user.getUsername());
		System.out.println("userame"+ user.getPassword());
		//System.out.println("roles"+ user.getRoles());
		//System.out.println("roles"+ user.getUser_id());

		
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		Gson gson = new Gson();
		org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
		//String idUser = ur.findByUsername(springUser.getUsername()).getUser_id().toString(); 
		String jwt = Jwts.builder().setSubject(springUser.getUsername())
				
				
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles", springUser.getAuthorities())
				.compact();

				//response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+ jwt );
		        String token = gson.toJson(SecurityConstants.TOKEN_PREFIX+ jwt);
		        PrintWriter out = response.getWriter();
		        
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(token);
		        out.flush(); 
		//super.successfulAuthentication(request, response, chain, authResult);
	}

}
