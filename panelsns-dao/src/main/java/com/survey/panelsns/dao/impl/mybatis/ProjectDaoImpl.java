package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.ProjectDao;
import com.survey.panelsns.model.entity.Project;

@Repository
public class ProjectDaoImpl extends AbstractGenericDaoImpl<Project, Long> implements ProjectDao {

	@Override
	public String namespace() {
		return Project.class.getName();
	}

}
