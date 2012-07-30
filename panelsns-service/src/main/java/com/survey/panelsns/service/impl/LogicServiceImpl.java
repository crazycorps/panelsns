package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicDao;
import com.survey.panelsns.model.entity.Logic;
import com.survey.panelsns.service.LogicService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class LogicServiceImpl extends GenericServiceImpl<Logic, Long> implements
		LogicService {

	@Autowired
	private LogicDao logicDao;

	@Override
	public GenericDao getGenricDao() {
		return this.logicDao;
	}

}
