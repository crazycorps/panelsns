package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.AnswerDao;
import com.survey.panelsns.model.entity.Answer;

@Repository
public class AnswerDaoImpl extends AbstractGenericDaoImpl<Answer, Long> implements AnswerDao {

	@Override
	public String namespace() {
		return Answer.class.getName();
	}

}
