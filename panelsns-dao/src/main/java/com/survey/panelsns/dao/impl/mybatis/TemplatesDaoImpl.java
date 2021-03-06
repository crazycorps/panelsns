package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.TemplatesDao;
import com.survey.panelsns.model.entity.Templates;

@Repository
public class TemplatesDaoImpl extends AbstractGenericDaoImpl<Templates, Long> implements TemplatesDao {

	@Override
	public String namespace() {
		return Templates.class.getName();
	}

}
