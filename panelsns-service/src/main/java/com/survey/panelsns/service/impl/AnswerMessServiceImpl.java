package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.AnswerMessDao;
import com.survey.panelsns.model.entity.AnswerMess;
import com.survey.panelsns.service.AnswerMessService;
import com.survey.panelsns.service.vo.AnswerMessVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class AnswerMessServiceImpl extends AbstractGenericServiceImpl<AnswerMessVO,AnswerMess, Long> implements AnswerMessService {

	@Autowired
	private AnswerMessDao answerMessDao;

	public GenericDao<AnswerMess, Long> getGenricDao() {
		return this.answerMessDao;
	}

	public Class<AnswerMessVO> getClassR() {
		return AnswerMessVO.class;
	}

}
