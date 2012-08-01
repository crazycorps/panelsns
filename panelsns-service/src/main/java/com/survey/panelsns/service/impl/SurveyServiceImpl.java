package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.SurveyDao;
import com.survey.panelsns.model.entity.Survey;
import com.survey.panelsns.service.SurveyService;
import com.survey.panelsns.service.vo.SurveyVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class SurveyServiceImpl extends AbstractGenericServiceImpl<SurveyVO,Survey, Long>
		implements SurveyService {

	@Autowired
	private SurveyDao surveyDao;

	public GenericDao<Survey, Long> getGenricDao() {
		return this.surveyDao;
	}

	public Class<SurveyVO> getClassR() {
		return SurveyVO.class;
	}

}
