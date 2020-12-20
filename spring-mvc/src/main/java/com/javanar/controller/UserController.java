package com.javanar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javanar.model.Person;
import com.javanar.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
		
		this.userService.add(firstName, lastName);
		
		String result = firstName + " " + lastName;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("result",result);
		
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Person> people = this.userService.list();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("people", people);
		
		return mv;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
