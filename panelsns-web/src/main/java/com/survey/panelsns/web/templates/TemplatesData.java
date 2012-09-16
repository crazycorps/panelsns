package com.survey.panelsns.web.templates;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.survey.panelsns.core.Constant;

@Component
public class TemplatesData {
	
	private static final String RESOURCE_URL="templates/default.html";
	
	private static final Long DEFAULT_TEMPLATE_ID=0L;
	
	private Map<Long,Document> templateDocs=new HashMap<Long,Document>();
	
	@PostConstruct
	public void init(){
		try {
			// 初始化模板数据
			InputStream resourceIn = TemplatesData.class.getClassLoader().getResourceAsStream(RESOURCE_URL);
			Document defaultTempDoc = Jsoup.parse(resourceIn,Constant.DEFAULT_CHARSET,"");
			templateDocs.put(DEFAULT_TEMPLATE_ID, defaultTempDoc);
			templateDocs=Collections.unmodifiableMap(templateDocs);
		} catch (IOException e) {
			throw new RuntimeException("load template data is error !"+e.getMessage());
		}
	}
	/**
	 * 获取默认模板的克隆对象
	 * @return
	 */
	public Document getDefaultTemplateDoc(){
		return templateDocs.get(DEFAULT_TEMPLATE_ID).clone();
	}
	
	public Document getTemplateDoc(long templateId){
		if(!templateDocs.containsKey(templateId)){
			throw new RuntimeException("there is no this template id:"+templateId);
		}
		return templateDocs.get(templateId).clone();
	}
	
}
