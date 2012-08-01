package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicConditionDao;
import com.survey.panelsns.model.entity.LogicCondition;
import com.survey.panelsns.service.LogicConditionService;
import com.survey.panelsns.service.vo.LogicConditionVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class LogicConditionServiceImpl extends
		AbstractGenericServiceImpl<LogicConditionVO, LogicCondition, Long> implements
		LogicConditionService {

	@Autowired
	private LogicConditionDao logicConditionDao;

	public GenericDao<LogicCondition, Long> getGenricDao() {
		return this.logicConditionDao;
	}

	public Class<LogicConditionVO> getClassR() {
		return LogicConditionVO.class;
	}

}
