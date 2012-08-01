package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.TemplatesDao;
import com.survey.panelsns.model.entity.Templates;
import com.survey.panelsns.service.TemplatesService;
import com.survey.panelsns.service.vo.TemplatesVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class TemplatesServiceImpl extends AbstractGenericServiceImpl<TemplatesVO,Templates, Long>
		implements TemplatesService {

	@Autowired
	private TemplatesDao templatesDao;

	public GenericDao<Templates, Long> getGenricDao() {
		return this.templatesDao;
	}

	public Class<TemplatesVO> getClassR() {
		return TemplatesVO.class;
	}

}
