package com.fieb.academico.web.dto;

public class UserDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public UserDto() {
		
	}
	
	public UserDto(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public UserDto(Long id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
}
