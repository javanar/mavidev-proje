package com.javanar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javanar.model.Person;
import com.javanar.service.UserService;

@Controller
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addUser");
		model.addAttribute("form",new PersonForm());
		
		return mv;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("form") @Valid PersonForm personForm,  BindingResult errors, Model model) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Errors : " + errors.getErrorCount());
		System.out.println(personForm.getFirstName());
		System.out.println(personForm.getLastName());
		
		if(errors.hasErrors()) {
			mv.setViewName("addUser");
		} else {
			this.userService.add(personForm.getFirstName(), personForm.getLastName());
			mv.setViewName("result");
			mv.addObject("result",personForm.getFirstName() + " " + personForm.getLastName());
		}
		
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
