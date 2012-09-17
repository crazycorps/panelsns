package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.AnswerDao;
import com.survey.panelsns.model.entity.Answer;
import com.survey.panelsns.service.AnswerService;
import com.survey.panelsns.service.vo.AnswerVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class AnswerServiceImpl extends AbstractGenericServiceImpl<AnswerVO,Answer, Long> implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	public GenericDao<Answer, Long> getGenricDao() {
		return this.answerDao;
	}

	public Class<AnswerVO> getClassR() {
		return AnswerVO.class;
	}

}
