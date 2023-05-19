package com.fieb.academico.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fieb.academico.model.Role;
import com.fieb.academico.model.User;
import com.fieb.academico.web.dto.UserDto;


public interface UserService extends UserDetailsService {
	
	User save(UserDto userDto);
	User findByEmail(UserDto userDto);
	User update(UserDto userDto);
	User getAuthenticatedUser();
	Role saveRole(Role role);
	void addRoleToUser(String username, String rolename);
	
	// api
	User getUserByUsername(String username);
	User findUserById(Long id);
}
