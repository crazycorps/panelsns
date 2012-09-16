package com.survey.panelsns.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.QuesNaireService;
import com.survey.panelsns.util.SpringApplicationUtil;
import com.survey.panelsns.web.render.NaireRender;
import com.survey.panelsns.web.render.Render;
import com.survey.panelsns.web.templates.TemplatesData;

@Controller
public class NaireRenderController {
	
	@Autowired
	private QuesNaireService quesNaireService;
	
	@Autowired
	private TemplatesData templatesData;
	
	@RequestMapping(value = "/render/{surveyId:\\d+}/", method = { RequestMethod.GET,RequestMethod.POST })
	public void index(HttpServletRequest request,HttpServletResponse response,
				@PathVariable long surveyId) throws Exception {
		QuesNaire query=new QuesNaire();
		query.setSurveyId(surveyId);
		QuesNaire quesNaire=quesNaireService.get(query);
		Render<Document> render=new NaireRender(quesNaire,templatesData);
		Document doc=render.render();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(doc.html());
		out.flush();
	}
}
