package com.survey.panelsns.web.controller.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.model.entity.Users;
import com.survey.panelsns.service.QuesNaireService;
import com.survey.panelsns.service.QuesService;
import com.survey.panelsns.service.json.NaireDeleteMess;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.web.controller.AbstractPanelSnsController;
import com.survey.tools.util.JSONUtils;

@Controller
@RequestMapping("/u/naire")
public class NaireController extends AbstractPanelSnsController{
	
	@Autowired
	private QuesNaireService quesNaireService;
	
	@Autowired
	private QuesService quesService;
	
	@RequestMapping(value = "/{surveyId:\\d+}/", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(HttpServletRequest request,HttpServletResponse response,
			@PathVariable long surveyId,Model model) throws Exception {
		QuesNaire query=new QuesNaire();
		query.setSurveyId(surveyId);
		QuesNaire quesNaire=quesNaireService.get(query);
		model.addAttribute("naire", quesNaire);
		return "users/naire";
	}
	
	@RequestMapping(value = "/update/", method = {RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> update(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="surveyId",required=true) long surveyId,
			@RequestParam(value="naireId",required=true) long naireId,
			@RequestParam(value="pageMess",required=true) String pageMess,
			@RequestParam(value="deleteMess",required=true) String deleteMess) throws Exception {
		Map<String,Object> ret=new HashMap<String, Object>();
		try {
			NairePageMess nairePageMess=JSONUtils.fromJSON(pageMess, new TypeReference<NairePageMess>(){}, true);
			NaireDeleteMess naireDeleteMess=JSONUtils.fromJSON(deleteMess, new TypeReference<NaireDeleteMess>(){}, true);
			this.quesNaireService.processNairePageMess(Users.DEFAULT.getId(), surveyId, naireId, nairePageMess,naireDeleteMess);
			ret.put("pageMess", nairePageMess);
			ret.put(PROCESS_STATUS_KEY, PROCESS_STATUS_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			ret.put(PROCESS_STATUS_KEY, PROCESS_STATUS_FAIL);
		}
		return ret;
	}
	
	@RequestMapping(value = "/mess/", method = {RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> mess(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="naireId",required=true) long naireId,
			@RequestParam(value="pageNo",required=true) int pageNo) throws Exception {
		Map<String,Object> ret=new HashMap<String, Object>();
		try {
			List<Integer> pageNoList=new ArrayList<Integer>();
			pageNoList.add(pageNo);
			NairePageMess nairePageMess=this.quesNaireService.getNairePageMess(naireId, pageNoList);
			ret.put("pageMess", nairePageMess);
			ret.put(PROCESS_STATUS_KEY, PROCESS_STATUS_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			ret.put(PROCESS_STATUS_KEY, PROCESS_STATUS_FAIL);
		}
		return ret;
	}
	
}
