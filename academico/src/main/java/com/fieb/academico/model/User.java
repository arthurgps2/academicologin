package com.fieb.academico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	// Class User
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long d;
	private String firstName;
	private String lastName;
	
	private String email;
	private String password;
}
