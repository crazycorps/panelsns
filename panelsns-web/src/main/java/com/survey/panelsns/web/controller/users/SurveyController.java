package com.survey.panelsns.web.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.survey.panelsns.service.SurveyService;

@Controller
@RequestMapping("/u")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "/survey", method = { RequestMethod.GET,RequestMethod.POST })
	public String survey(HttpServletRequest request,
			HttpServletResponse response) {
		return "users/survey";
	}
	
	
}
