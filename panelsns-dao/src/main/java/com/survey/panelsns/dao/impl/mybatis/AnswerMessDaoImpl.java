package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.AnswerMessDao;
import com.survey.panelsns.model.entity.AnswerMess;

@Repository
public class AnswerMessDaoImpl extends AbstractGenericDaoImpl<AnswerMess, Long> implements AnswerMessDao {

	@Override
	public String namespace() {
		return AnswerMess.class.getName();
	}

}
