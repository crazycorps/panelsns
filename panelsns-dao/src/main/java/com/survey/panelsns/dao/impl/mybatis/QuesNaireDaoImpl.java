package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.impl.GenericDaoImpl;
import com.survey.panelsns.dao.QuesNaireDao;
import com.survey.panelsns.model.entity.QuesNaire;

@Repository
public class QuesNaireDaoImpl extends GenericDaoImpl<QuesNaire, Long> implements QuesNaireDao {

	@Override
	public String namespace() {
		return QuesNaire.class.getName();
	}

}
