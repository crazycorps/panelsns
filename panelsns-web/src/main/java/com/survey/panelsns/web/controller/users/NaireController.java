package com.survey.panelsns.web.controller.users;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.panelsns.web.json.NairePageMess;
import com.survey.tools.util.JSONUtils;

@Controller
@RequestMapping("/u/naire")
public class NaireController {
	
	@RequestMapping(value = "/", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception {
		
		return "users/naire";
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> update(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="surveyId",required=true) long surveyId,
			@RequestParam(value="naireId",required=true) long naireId,
			@RequestParam(value="pageMess",required=true) String pageMess) throws Exception {
		Map<String,Object> ret=new HashMap<String, Object>();
		TypeReference<NairePageMess> typeReference=new TypeReference<NairePageMess>(){};
		NairePageMess nairePageMess=JSONUtils.fromJSON(pageMess, typeReference, true);
		return ret;
	}
	
}
