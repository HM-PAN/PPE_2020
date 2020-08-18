package org.sesame.security.recrutement1.repository;

import org.sesame.security.recrutement1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String str );

}
