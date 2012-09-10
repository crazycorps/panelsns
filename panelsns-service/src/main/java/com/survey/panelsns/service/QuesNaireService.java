package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.vo.QuesNaireVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface QuesNaireService extends GenericService<QuesNaireVO,QuesNaire, Long> {

	void processNairePageMess(long userId,long surveyId,long naireId,NairePageMess nairePageMess);
}
