package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.LogicUnitDao;
import com.survey.panelsns.model.entity.LogicUnit;

@Repository
public class LogicUnitDaoImpl extends GenericDaoImpl<LogicUnit, Long> implements LogicUnitDao {

	@Override
	public String namespace() {
		return LogicUnit.class.getName();
	}

}
