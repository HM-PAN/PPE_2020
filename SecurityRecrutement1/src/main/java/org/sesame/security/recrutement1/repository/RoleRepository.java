package org.sesame.security.recrutement1.repository;

import org.sesame.security.recrutement1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long>{
	public Role findByRoleName (String str);

}
