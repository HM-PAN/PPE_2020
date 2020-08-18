package org.sesame.security.recrutement1.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sesame.security.recrutement1.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,"
				+ "Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,"
				+ "Authorization");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,"
				+ "Access-Control-Allow-Credentials,"
				+ "Authorization");
		//Begin test
		
		//end test
	   String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
	   System.out.println(jwt);
	   if(jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
		filterChain.doFilter(request, response);
	    return ;
	   }
	  // System.out.println("dddddddddddddddddddddd");
	   Claims claims = Jwts.parser()
			   .setSigningKey(SecurityConstants.SECRET).parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
			   .getBody();
	   String username = claims.getSubject();
	   ArrayList<Map<String,String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
	  
	   Collection<GrantedAuthority> authorities = new ArrayList<>();
	   //System.out.println(authorities);
	  // System.out.println("les roles sont" + roles);
	   roles.forEach(r->{
		   authorities.add(new SimpleGrantedAuthority(r.get("authority")));
	   });
	   //System.out.println(authorities);
	   UsernamePasswordAuthenticationToken authenticationUser =
			   new UsernamePasswordAuthenticationToken(username,null,authorities);
	   SecurityContextHolder.getContext().setAuthentication(authenticationUser);
	   filterChain.doFilter(request, response);
	   
	   
	   
	   
	   
	   
	   
		
	}

}
