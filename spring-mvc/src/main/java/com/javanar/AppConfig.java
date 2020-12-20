package com.javanar;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javanar.model.Person;

@Configuration
@ComponentScan({"com.javanar.controller", "com.javanar.service", "com.javanar.dao"})
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Person.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
}
