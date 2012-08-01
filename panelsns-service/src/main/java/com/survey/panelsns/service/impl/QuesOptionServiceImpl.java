package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.QuesOptionService;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class QuesOptionServiceImpl extends AbstractGenericServiceImpl<QuesOptionVO,QuesOption, Long>
		implements QuesOptionService {

	@Autowired
	private QuesOptionDao quesOptionDao;

	public GenericDao<QuesOption, Long> getGenricDao() {
		return this.quesOptionDao;
	}

	public Class<QuesOptionVO> getClassR() {
		return QuesOptionVO.class;
	}

}
