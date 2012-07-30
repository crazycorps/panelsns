package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.LogicDao;
import com.survey.panelsns.model.entity.Logic;

@Repository
public class LogicDaoImpl extends GenericDaoImpl<Logic, Long> implements LogicDao {

	@Override
	public String namespace() {
		return Logic.class.getName();
	}

}
