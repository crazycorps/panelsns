package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesNaireDao;
import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.QuesNaireService;
import com.survey.service.impl.GenericServiceImpl;

@Service
public class QuesNaireServiceImpl extends GenericServiceImpl<QuesNaire, Long>
		implements QuesNaireService {

	@Autowired
	private QuesNaireDao quesNaireDao;

	@Override
	public GenericDao getGenricDao() {
		return this.quesNaireDao;
	}

}
