package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.ProjectDao;
import com.survey.panelsns.model.entity.Project;
import com.survey.panelsns.service.ProjectService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long>
		implements ProjectService {

	@Autowired
	private ProjectDao ProjectDao;

	@Override
	public GenericDao getGenricDao() {
		return this.ProjectDao;
	}

}
