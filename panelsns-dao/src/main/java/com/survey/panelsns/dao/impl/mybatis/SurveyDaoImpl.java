package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.SurveyDao;
import com.survey.panelsns.model.entity.Survey;

@Repository
public class SurveyDaoImpl extends GenericDaoImpl<Survey, Long> implements SurveyDao {

	@Override
	public String namespace() {
		return Survey.class.getName();
	}

}
