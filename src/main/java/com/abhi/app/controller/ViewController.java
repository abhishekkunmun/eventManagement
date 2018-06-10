package com.abhi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	
	
	@RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView homeView() {
		return new ModelAndView("home.html");
	}
	
		
	@RequestMapping(value="/admin-panel", method = RequestMethod.GET)
	public ModelAndView adminView() {
		return new ModelAndView("admin.html");
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginView() {
		return new ModelAndView("login.html");
	}
}
