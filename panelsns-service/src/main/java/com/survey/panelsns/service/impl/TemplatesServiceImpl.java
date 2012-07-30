package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.TemplatesDao;
import com.survey.panelsns.model.entity.Templates;
import com.survey.panelsns.service.TemplatesService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class TemplatesServiceImpl extends GenericServiceImpl<Templates, Long>
		implements TemplatesService {

	@Autowired
	private TemplatesDao templatesDao;

	@Override
	public GenericDao getGenricDao() {
		return this.templatesDao;
	}

}
