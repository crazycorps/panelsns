package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicUnitDao;
import com.survey.panelsns.model.entity.LogicUnit;
import com.survey.panelsns.service.LogicUnitService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class LogicUnitServiceImpl extends GenericServiceImpl<LogicUnit, Long> implements LogicUnitService {

	@Autowired
	private LogicUnitDao logicUnitDao;

	@Override
	public GenericDao getGenricDao() {
		return this.logicUnitDao;
	}

}
