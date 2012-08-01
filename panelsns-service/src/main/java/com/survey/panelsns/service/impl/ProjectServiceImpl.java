package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.ProjectDao;
import com.survey.panelsns.model.entity.Project;
import com.survey.panelsns.service.ProjectService;
import com.survey.panelsns.service.vo.ProjectVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class ProjectServiceImpl extends AbstractGenericServiceImpl<ProjectVO,Project, Long>
		implements ProjectService {

	@Autowired
	private ProjectDao ProjectDao;

	public GenericDao<Project, Long> getGenricDao() {
		return this.ProjectDao;
	}

	public Class<ProjectVO> getClassR() {
		return ProjectVO.class;
	}

}
