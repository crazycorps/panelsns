package com.survey.panelsns.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.json.NaireDeleteMess;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.vo.QuesNaireVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface QuesNaireService extends GenericService<QuesNaireVO,QuesNaire, Long> {
	
	@Transactional(propagation = Propagation.REQUIRED)
	void processNairePageMess(long userId,long surveyId,long naireId,NairePageMess nairePageMess,NaireDeleteMess naireDeleteMess) throws Exception ;
	
	NairePageMess getNairePageMess(long naireId,List<Integer> pageNoList) throws Exception ;
}
