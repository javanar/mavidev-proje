package com.javanar.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.javanar.model.Person;

@Component
public class ListService {

	public List<Person> list() {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		
		return session.createQuery("select p from Person p", Person.class).getResultList();
	}

}
