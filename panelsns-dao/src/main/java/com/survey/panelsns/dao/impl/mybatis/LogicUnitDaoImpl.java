package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.LogicUnitDao;
import com.survey.panelsns.model.entity.LogicUnit;

@Repository
public class LogicUnitDaoImpl extends AbstractGenericDaoImpl<LogicUnit, Long> implements LogicUnitDao {

	@Override
	public String namespace() {
		return LogicUnit.class.getName();
	}

}
