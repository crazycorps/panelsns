package com.survey.panelsns.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.QuesNaireDao;
import com.survey.panelsns.model.entity.QuesNaire;

@Repository
public class QuesNaireDaoImpl extends AbstractGenericDaoImpl<QuesNaire, Long> implements QuesNaireDao {

	@Override
	public String namespace() {
		return QuesNaire.class.getName();
	}

}
