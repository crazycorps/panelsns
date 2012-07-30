package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesDao;
import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.service.QuesService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class QuesServiceImpl extends GenericServiceImpl<Ques, Long> implements
		QuesService {

	@Autowired
	private QuesDao quesDao;

	@Override
	public GenericDao getGenricDao() {
		return this.quesDao;
	}

}
