package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.LogicDao;
import com.survey.panelsns.model.entity.Logic;
import com.survey.panelsns.service.LogicService;
import com.survey.panelsns.service.vo.LogicVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class LogicServiceImpl extends AbstractGenericServiceImpl<LogicVO,Logic, Long> implements
		LogicService {

	@Autowired
	private LogicDao logicDao;

	public GenericDao<Logic, Long> getGenricDao() {
		return this.logicDao;
	}

	public Class<LogicVO> getClassR() {
		return LogicVO.class;
	}

}
