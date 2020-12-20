package com.javanar.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.javanar.model.Person;

@Component
public class AddService {

	public void add(String firstName, String lastName) {
		
		Person person = new Person(firstName, lastName);
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(person);
        
        transaction.commit();
	}
	
}
