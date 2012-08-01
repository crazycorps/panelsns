package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.UsersDao;
import com.survey.panelsns.model.entity.Users;
import com.survey.panelsns.service.UsersService;
import com.survey.panelsns.service.vo.UsersVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class UsersServiceImpl extends AbstractGenericServiceImpl<UsersVO,Users, Long> implements
		UsersService {

	@Autowired
	private UsersDao usersDao;

	public GenericDao<Users, Long> getGenricDao() {
		return this.usersDao;
	}

	public Class<UsersVO> getClassR() {
		return UsersVO.class;
	}

}
