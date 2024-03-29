package com.fieb.academico.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fieb.academico.model.Role;
import com.fieb.academico.model.User;
import com.fieb.academico.repository.RoleRepository;
import com.fieb.academico.repository.UserRepository;
import com.fieb.academico.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}


	
	@Override
	public User save(UserDto userDto) {
		
		User user = new User(userDto.getFirstName(), 
							 userDto.getLastName(), 
							 userDto.getEmail(), 
							 passwordEncoder.encode(userDto.getPassword()),
							 new ArrayList<>());
							 //Arrays.asList(new Role("ROLE_USER")));
							
		
		userRepository.save(user);
		this.addRoleToUser(user.getEmail(), "ROLE_USER");
		return user;
	}


	@Override
	public User findByEmail(UserDto userDto) {
		return userRepository.findByEmail(userDto.getEmail());
	}


	@Override
	public User update(UserDto userDto) {
		User user = userRepository.findByEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setCep(userDto.getCep());
		user.setCity(userDto.getCity());
		user.setDistrict(userDto.getDistrict());
		user.setCountry(userDto.getCountry());
		user.setNumber(userDto.getNumber());
		user.setState(userDto.getState());
		
		return userRepository.save(user);
	}
	
	@Override
	public User getAuthenticatedUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = userRepository.findByEmail(username);
		return user;
	}


	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}


	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByEmail(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		userRepository.save(user);
	}


	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByEmail(username);
	}


	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
}
