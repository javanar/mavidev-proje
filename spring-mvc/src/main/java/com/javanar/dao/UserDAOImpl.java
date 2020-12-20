package com.javanar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javanar.model.Person;

@Component
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(String firstName, String lastName) {
		Person person = new Person(firstName, lastName);

		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.save(person);

		transaction.commit();
	}

	@Override
	public List<Person> list() {
		Session session = getSessionFactory().openSession();

		return session.createQuery("select p from Person p", Person.class).getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
