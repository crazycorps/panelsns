package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.QuesOptionService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class QuesOptionServiceImpl extends GenericServiceImpl<QuesOption, Long>
		implements QuesOptionService {

	@Autowired
	private QuesOptionDao quesOptionDao;

	@Override
	public GenericDao getGenricDao() {
		return this.quesOptionDao;
	}

}
