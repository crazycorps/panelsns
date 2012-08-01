package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesDao;
import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.service.QuesService;
import com.survey.panelsns.service.vo.QuesVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class QuesServiceImpl extends AbstractGenericServiceImpl<QuesVO,Ques, Long> implements
		QuesService {

	@Autowired
	private QuesDao quesDao;

	public GenericDao<Ques, Long> getGenricDao() {
		return this.quesDao;
	}

	public Class<QuesVO> getClassR() {
		return QuesVO.class;
	}

}
