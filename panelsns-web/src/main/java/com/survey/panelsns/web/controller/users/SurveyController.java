package com.survey.panelsns.web.controller.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.survey.panelsns.model.entity.Survey;
import com.survey.panelsns.service.SurveyService;
import com.survey.panelsns.service.vo.SurveyVO;
import com.survey.service.pagination.PaginationResult;

@Controller
@RequestMapping("/u")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "/survey", method = { RequestMethod.GET,RequestMethod.POST })
	public String survey(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Survey survey=null;
		PaginationResult<SurveyVO> paginationResult=surveyService.getVoPaginationResult(survey, 1, 10);
		return "users/survey";
	}
	
	
}
