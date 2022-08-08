package com.example.restservice.model;

import com.example.restservice.validation.IpAddress;
import com.example.restservice.validation.PwdRule;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserData {
	@NotNull(message = "Please provide mandatory field username")
	@NotEmpty(message = "username cannot be blank")
	private String username;

	@NotNull(message = "Please provide mandatory field password")
	@NotEmpty(message = "password cannot be blank")
	@PwdRule(message = "Password need to be greater than 8 characters, containing at least 1 number, 1 Capitalized letter, 1 special character in this set “_ # $ % .")
	private String password;

	@NotNull(message = "Please provide mandatory field ipAddress")
	@NotEmpty(message = "ipAddress cannot be blank")
	@IpAddress(message = "Please provide a valid ipAddress")
	private String ipAddress;


	public UserData(String username, String password, String ipAddress) {
		this.username = username;
		this.password = password;
		this.ipAddress = ipAddress;
	}


}
