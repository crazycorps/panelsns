package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.QuesOption;

@Repository
public class QuesOptionDaoImpl extends GenericDaoImpl<QuesOption, Long> implements QuesOptionDao {

	@Override
	public String namespace() {
		return QuesOption.class.getName();
	}

}
