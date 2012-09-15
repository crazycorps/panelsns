package com.survey.panelsns.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.survey.dao.GenericDao;
import com.survey.panelsns.dao.QuesDao;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.QuesService;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.panelsns.service.vo.QuesVO;
import com.survey.service.AbstractGenericServiceImpl;

@Service
public class QuesServiceImpl extends AbstractGenericServiceImpl<QuesVO,Ques, Long> implements
		QuesService {

	@Autowired
	private QuesDao quesDao;
	
	@Autowired
	private QuesOptionDao quesOptionDao;

	public GenericDao<Ques, Long> getGenricDao() {
		return this.quesDao;
	}

	public Class<QuesVO> getClassR() {
		return QuesVO.class;
	}

	@Override
	public List<QuesVO> getQueses(long naireId, int pageNo) throws Exception {
		Ques query=new Ques();
		query.setQuesNaireId(naireId);
		query.setPageNo(pageNo);
		List<Ques> matchQuesList=this.quesDao.selectMatchList(query);
		if(matchQuesList==null||matchQuesList.isEmpty()){
			return Collections.emptyList();
		}
		List<Long> quesIdList=new ArrayList<Long>();
		for(Ques ques:matchQuesList){
			quesIdList.add(ques.getId());
		}
		List<QuesOption> quesOptionList=this.quesOptionDao.getQuesOptionsByQuesIds(quesIdList);
		Map<Long,List<QuesOptionVO>> quesOptionByQuesMap=QuesOptionVO.partitionByQuesAndSort(quesOptionList);
		
		List<QuesVO> ret=QuesVO.sortAscAndWapperVo(matchQuesList);
		for(QuesVO quesVo:ret){
			Ques ques=quesVo.getEntity();
			quesVo.setQuesOptionVoList(quesOptionByQuesMap.get(ques.getId()));
		}
		return ret;
	}

}
