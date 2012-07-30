package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.SurveyDao;
import com.survey.panelsns.model.entity.Survey;
import com.survey.panelsns.service.SurveyService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class SurveyServiceImpl extends GenericServiceImpl<Survey, Long>
		implements SurveyService {

	@Autowired
	private SurveyDao surveyDao;

	@Override
	public GenericDao getGenricDao() {
		return this.surveyDao;
	}

}
