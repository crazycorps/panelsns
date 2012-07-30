package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.QuesDao;
import com.survey.panelsns.model.entity.Ques;

@Repository
public class QuesDaoImpl extends GenericDaoImpl<Ques, Long> implements QuesDao {

	@Override
	public String namespace() {
		return Ques.class.getName();
	}

}
