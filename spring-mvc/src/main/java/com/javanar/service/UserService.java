package com.javanar.service;

import java.util.List;

import com.javanar.model.Person;

public interface UserService {

	public void add(String firstName, String lastName);
	
	public List<Person> list();
	
}
