package com.survey.panelsns.web.controller.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.survey.panelsns.model.entity.Survey;
import com.survey.panelsns.service.SurveyService;
import com.survey.panelsns.service.vo.SurveyVO;
import com.survey.service.pagination.Pagination;
import com.survey.service.pagination.PaginationResult;

@Controller
@RequestMapping("/u")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "/survey", method = { RequestMethod.GET,RequestMethod.POST })
	public String survey(@RequestParam(value="toPage",required=false,defaultValue="1") int toPage,HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		Survey entity=new Survey();
		entity.setUserId(1L);
		PaginationResult<SurveyVO> paginationResult=surveyService.getVoPaginationResult(entity, toPage, Pagination.DEFAULT_PAGE_SIZE);
		Map<String,List<SurveyVO>> tempResult=new HashMap<String,List<SurveyVO>>();
		for(SurveyVO vo:paginationResult.getResults()){
			String formatDay=vo.getFormatCreateDate();
			List<SurveyVO> daySurveyList=null;
			if(tempResult.containsKey(formatDay)){
				daySurveyList=tempResult.get(formatDay);
			}else{
				daySurveyList=new ArrayList<SurveyVO>();
				tempResult.put(formatDay, daySurveyList);
			}
			daySurveyList.add(vo);
		}
		List<Map<String,List<SurveyVO>>> processedResults=new ArrayList<Map<String,List<SurveyVO>>>();
		processedResults.add(tempResult);
		PaginationResult<Map<String,List<SurveyVO>>> processedPaginationResult=new PaginationResult<Map<String,List<SurveyVO>>>(processedResults, paginationResult.getPagination());
		model.addAttribute("paginationResult", processedPaginationResult);
		return "users/survey";
	}
	
	
}
