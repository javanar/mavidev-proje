package com.javanar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javanar.dao.UserDAO;
import com.javanar.model.Person;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void add(String firstName, String lastName) {
		userDAO.add(firstName, lastName);
	}

	@Override
	public List<Person> list() {
		return userDAO.list();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
