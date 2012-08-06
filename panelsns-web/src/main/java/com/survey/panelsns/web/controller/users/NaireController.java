package com.survey.panelsns.web.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/u/naire")
public class NaireController {
	
	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		
		return "users/naire";
	}
	
	
}
