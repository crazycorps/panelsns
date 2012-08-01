package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicUnitDao;
import com.survey.panelsns.model.entity.LogicUnit;
import com.survey.panelsns.service.LogicUnitService;
import com.survey.panelsns.service.vo.LogicUnitVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class LogicUnitServiceImpl extends AbstractGenericServiceImpl<LogicUnitVO,LogicUnit, Long> implements LogicUnitService {

	@Autowired
	private LogicUnitDao logicUnitDao;

	public GenericDao<LogicUnit, Long> getGenricDao() {
		return this.logicUnitDao;
	}

	public Class<LogicUnitVO> getClassR() {
		return LogicUnitVO.class;
	}

}
