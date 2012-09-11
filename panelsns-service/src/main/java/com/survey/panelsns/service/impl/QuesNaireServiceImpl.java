package com.survey.panelsns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesDao;
import com.survey.panelsns.dao.QuesNaireDao;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.QuesNaireService;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.processer.QuesProcesser;
import com.survey.panelsns.service.vo.KV;
import com.survey.panelsns.service.vo.QuesNaireVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class QuesNaireServiceImpl extends AbstractGenericServiceImpl<QuesNaireVO,QuesNaire, Long>
		implements QuesNaireService {

	@Autowired
	private QuesNaireDao quesNaireDao;
	
	@Autowired
	private QuesDao quesDao;
	
	@Autowired
	private QuesOptionDao quesOptionDao;

	public GenericDao<QuesNaire, Long> getGenricDao() {
		return this.quesNaireDao;
	}

	public Class<QuesNaireVO> getClassR() {
		return QuesNaireVO.class;
	}

	@Override
	public void processNairePageMess(long userId, long surveyId, long naireId, NairePageMess nairePageMess) throws Exception {
		Processer<List<KV<Integer,List<Ques>>>> processer=new QuesProcesser(naireId, nairePageMess);
		List<KV<Integer,List<Ques>>> processResult=processer.process();
		
		for(KV<Integer,List<Ques>> pageQuesList:processResult){
			for(Ques ques:pageQuesList.getVal()){
				this.quesDao.insertEntity(ques);
				List<QuesOption> quesOptionList=ques.getQuesOptionList();
				if(CollectionUtils.isEmpty(quesOptionList)){
					continue;
				}
				for(QuesOption quesOption:quesOptionList){
					quesOption.setQuesId(ques.getId());
					this.quesOptionDao.insertEntity(quesOption);
				}
			}
		}
	}
	
	
}
