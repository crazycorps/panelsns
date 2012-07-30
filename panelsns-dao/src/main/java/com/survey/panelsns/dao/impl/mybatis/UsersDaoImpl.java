package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.UsersDao;
import com.survey.panelsns.model.entity.Users;

@Repository
public class UsersDaoImpl extends GenericDaoImpl<Users, Long> implements UsersDao {

	@Override
	public String namespace() {
		return Users.class.getName();
	}

}
