package com.survey.panelsns.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(HttpServletRequest request,HttpServletResponse response) {
		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET,RequestMethod.POST })
	public String login(HttpServletRequest request,HttpServletResponse response) {
		
		return "login";
	}
	
}
