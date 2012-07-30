package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.UsersDao;
import com.survey.panelsns.model.entity.Users;
import com.survey.panelsns.service.UsersService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class UsersServiceImpl extends GenericServiceImpl<Users, Long> implements
		UsersService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public GenericDao getGenricDao() {
		return this.usersDao;
	}

}
