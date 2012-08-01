package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.LogicConditionDao;
import com.survey.panelsns.model.entity.LogicCondition;

@Repository
public class LogicConditionDaoImpl extends AbstractGenericDaoImpl<LogicCondition, Long> implements LogicConditionDao {

	@Override
	public String namespace() {
		return LogicCondition.class.getName();
	}

}
