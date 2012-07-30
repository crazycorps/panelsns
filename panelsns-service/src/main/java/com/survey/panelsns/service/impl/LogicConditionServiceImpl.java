package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicConditionDao;
import com.survey.panelsns.model.entity.LogicCondition;
import com.survey.panelsns.service.LogicConditionService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class LogicConditionServiceImpl extends GenericServiceImpl<LogicCondition, Long> implements
LogicConditionService {

	@Autowired
	private LogicConditionDao logicConditionDao;

	@Override
	public GenericDao getGenricDao() {
		return this.logicConditionDao;
	}

}
