package com.javanar.controller;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonForm {
	
	@NotEmpty(message = "First name can not be empty")
	private String firstName;
	@NotEmpty(message = "Last name can not be empty")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
