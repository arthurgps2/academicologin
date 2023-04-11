package com.fieb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fieb.academico.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
