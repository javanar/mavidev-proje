package com.javanar.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javanar.service.AddService;

@Controller
public class AddController {
	
	@Autowired
	private AddService addService;

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, 
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("Add Controller, add method called");
		
		getAddService().add(firstName, lastName);
		String result = firstName + " " + lastName;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("result",result);
		
		return mv;
	}

	public AddService getAddService() {
		return addService;
	}

	public void setAddService(AddService addService) {
		this.addService = addService;
	}
	
}
