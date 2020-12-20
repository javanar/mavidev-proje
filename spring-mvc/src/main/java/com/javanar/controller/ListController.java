package com.javanar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javanar.model.Person;
import com.javanar.service.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;
	
	@RequestMapping("/list")
	public ModelAndView list() {
		
		List<Person> people = getListService().list();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("people", people);
		
		return mv;
	}

	public ListService getListService() {
		return listService;
	}

	public void setListService(ListService listService) {
		this.listService = listService;
	}

}
