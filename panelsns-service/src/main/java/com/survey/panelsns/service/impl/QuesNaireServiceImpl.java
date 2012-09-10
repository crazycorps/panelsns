package com.survey.panelsns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesNaireDao;
import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.QuesNaireService;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.processer.QuesProcesser;
import com.survey.panelsns.service.vo.QuesNaireVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class QuesNaireServiceImpl extends AbstractGenericServiceImpl<QuesNaireVO,QuesNaire, Long>
		implements QuesNaireService {

	@Autowired
	private QuesNaireDao quesNaireDao;

	public GenericDao<QuesNaire, Long> getGenricDao() {
		return this.quesNaireDao;
	}

	public Class<QuesNaireVO> getClassR() {
		return QuesNaireVO.class;
	}

	@Override
	public void processNairePageMess(long userId, long surveyId, long naireId, NairePageMess nairePageMess) {
		Processer<Object> processer=new QuesProcesser(userId, surveyId, naireId, nairePageMess);
		processer.process();
	}
	
	
}
