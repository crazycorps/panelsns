package com.survey.panelsns.web.controller.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.survey.dao.common.OrderType;
import com.survey.panelsns.model.Status;
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
	public String survey(@RequestParam(value="toPage",required=false,defaultValue="1") int toPage,
			@RequestParam(value="orderCol",required=false) String orderCol,
			@RequestParam(value="orderType",required=false) String orderType,
			@RequestParam(value="status",required=false,defaultValue="0") int status,
			HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		Survey entity=new Survey();
		entity.setUserId(1L);
		entity.setStatus(status);
		if(StringUtils.isNotEmpty(orderCol)&&StringUtils.isNotEmpty(orderType)){
			entity.setOrderCol(orderCol);
			entity.setOrderType(orderType);
			model.addAttribute("orderCol", orderCol);
			model.addAttribute("orderType", orderType);
		}
		PaginationResult<SurveyVO> paginationResult=surveyService.getVoPaginationResult(entity, toPage, Pagination.DEFAULT_PAGE_SIZE);
		Map<String,List<SurveyVO>> tempResult=new HashMap<String,List<SurveyVO>>();
		// 先按照天分组
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
		OrderType insOrderType=OrderType.instanceOf(orderType);
		// 对天进行排序
		if(tempResult.size()>1&&insOrderType!=null&&"create_date".equals(orderCol)){
			List<String> sortFormatDayList=new ArrayList<String>(tempResult.keySet());
			if(OrderType.DESC.equals(insOrderType)){
				Collections.sort(sortFormatDayList, Collections.reverseOrder());
			}else{
				Collections.sort(sortFormatDayList);
			}
			for(String formatDay:sortFormatDayList){
				List<SurveyVO> daySurveyVoList=tempResult.get(formatDay);
				Map<String,List<SurveyVO>> formatDayResult=new HashMap<String,List<SurveyVO>>();
				formatDayResult.put(formatDay, daySurveyVoList);
				processedResults.add(formatDayResult);
			}
		}else{
			processedResults.add(tempResult);
		}
		PaginationResult<Map<String,List<SurveyVO>>> processedPaginationResult=new PaginationResult<Map<String,List<SurveyVO>>>(processedResults, paginationResult.getPagination());
		model.addAttribute("paginationResult", processedPaginationResult);
		
		model.addAttribute("surveyStatus", Status.SurveyStatus.values());
		model.addAttribute("selectedStatus",status);
		return "users/survey";
	}
	
	
}
