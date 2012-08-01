package com.survey.panelsns.web.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/u")
public class HomeController {

	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "users/index";
	}
	
}
