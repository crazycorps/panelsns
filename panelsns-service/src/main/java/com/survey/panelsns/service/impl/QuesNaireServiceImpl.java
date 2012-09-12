package com.survey.panelsns.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.processer.QuesProcesser;
import com.survey.panelsns.service.vo.KV;
import com.survey.panelsns.service.vo.QuesNaireVO;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.panelsns.service.vo.QuesVO;
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
		Processer<List<KV<Integer,List<QuesVO>>>> processer=new QuesProcesser(naireId, nairePageMess);
		List<KV<Integer,List<QuesVO>>> processResult=processer.process();
		
		// 由于数据存储在此发生，而sn是通过id来生成的
		Map<String,String> quesSnMap=new HashMap<String,String>();
		Map<String,String> quesOptMap=new HashMap<String,String>();
		for(KV<Integer,List<QuesVO>> pageQuesList:processResult){
			for(QuesVO quesVo:pageQuesList.getVal()){
				Ques ques=quesVo.getEntity();
				this.quesDao.insertEntity(ques);
				quesSnMap.put(quesVo.snKey(), quesVo.getSn());
				List<QuesOptionVO> quesOptionVoList=quesVo.getQuesOptionVoList();
				if(CollectionUtils.isEmpty(quesOptionVoList)){
					continue;
				}
				for(QuesOptionVO quesOptionVo:quesOptionVoList){
					QuesOption quesOption=quesOptionVo.getEntity();
					quesOption.setQuesId(ques.getId());
					this.quesOptionDao.insertEntity(quesOption);
					QuesOptionVO quesOptionVO=new QuesOptionVO(quesOption);
					quesOptMap.put(quesVo.snKey()+"_"+quesOptionVO.snKey(), quesOptionVO.getSn());
				}
			}
		}
		// 重新遍历，设定sn的值
		Map<String,Map<String,QuesAllMess>> pageMess=nairePageMess.getPageMess();
		for(Map<String,QuesAllMess> pageQuesAllMess:pageMess.values()){
			for(QuesAllMess quesAllMess:pageQuesAllMess.values()){
				QuesMess quesMess=quesAllMess.getQuesMess();
				QuesTypeOption quesTypeOption=quesAllMess.getQuesTypeOption();
				if(quesMess==null||quesTypeOption==null){
					continue;
				}
				quesMess.setSn(quesSnMap.get(quesMess.getSnKey()));
				List<QuesOptionMess> quesOptionMessList=quesMess.getQuesOptionMessList();
				if(quesOptionMessList==null||quesOptionMessList.isEmpty()){
					continue;
				}
				for(QuesOptionMess quesOptionMess:quesOptionMessList){
					quesOptionMess.setSn(quesOptMap.get(quesOptionMess.getSnKey()));
				}
			}
		}
		
	}
	
}
