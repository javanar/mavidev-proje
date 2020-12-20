package com.javanar.dao;

import java.util.List;

import com.javanar.model.Person;

public interface UserDAO {

	public void add(String firstName, String lastName);
	
	public List<Person> list();
	
}
