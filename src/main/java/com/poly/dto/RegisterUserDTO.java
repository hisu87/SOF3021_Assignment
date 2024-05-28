package com.poly.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterUserDTO {
	
	@NotEmpty(message = "{NotEmpty.user.username}")
	private String name;
	
	@NotEmpty(message = "{NotEmpty.user.password}")
	private String password;
	
	@NotEmpty(message = "{NotEmpty.user.email}")
	@Email(message = "{Email.user.email}") 
	private String email;
	
	@NotEmpty(message = "{NotEmpty.user.phoneNumber}")
	private String phoneNumber;

}
