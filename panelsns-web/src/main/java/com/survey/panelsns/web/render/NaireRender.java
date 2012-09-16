package com.survey.panelsns.web.render;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.web.templates.TemplatesData;

public class NaireRender implements Render<Document>{

	private QuesNaire quesNaire;
	
	private TemplatesData templatesData;
	
	public NaireRender(QuesNaire quesNaire,TemplatesData templatesData) {
		super();
		this.quesNaire = quesNaire;
		this.templatesData=templatesData;
	}

	@Override
	public Document render() {
		Document doc=templatesData.getTemplateDoc(quesNaire.getTemplateId());
		
		Elements surveyHeaderEles=doc.select(".survey_header");
		surveyHeaderEles.html(this.quesNaire.getHeader());
		
		Elements surveyTitleEles=doc.select(".survey_title");
		surveyTitleEles.html(this.quesNaire.getTitle());
		
		Elements surveyFooterEles=doc.select(".survey_footer");
		surveyFooterEles.html(this.quesNaire.getFooter());
		
		Element surveyIdEle=doc.getElementById("surveyId");
		surveyIdEle.val(this.quesNaire.getSurveyId()+"");
		
		Element naireIdEle=doc.getElementById("naireId");
		naireIdEle.val(this.quesNaire.getId()+"");
		
		// 默认从第一页开始回答
		Element nowPageNoEle=doc.getElementById("nowPageNo");
		nowPageNoEle.val("1");
		
		return doc;
	}

}
