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
import com.survey.panelsns.service.QuesService;
import com.survey.panelsns.service.json.NaireDeleteMess;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.processer.ques.QuesDecodeProcesser;
import com.survey.panelsns.service.processer.ques.QuesEncodeProcesser;
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
	
	@Autowired
	private QuesService quesService;

	public GenericDao<QuesNaire, Long> getGenricDao() {
		return this.quesNaireDao;
	}

	public Class<QuesNaireVO> getClassR() {
		return QuesNaireVO.class;
	}

	@Override
	public void processNairePageMess(long userId, long surveyId, long naireId, NairePageMess nairePageMess,NaireDeleteMess naireDeleteMess) throws Exception {
		Processer<List<KV<Integer,List<QuesVO>>>> processer=new QuesDecodeProcesser(naireId, nairePageMess);
		List<KV<Integer,List<QuesVO>>> processResult=processer.process();
		
		this.processDeleteMess(naireDeleteMess);
		
		// 由于数据存储在此发生，而sn是通过id来生成的
		Map<String,String> quesSnMap=new HashMap<String,String>();
		Map<String,String> quesOptMap=new HashMap<String,String>();
		for(KV<Integer,List<QuesVO>> pageQuesList:processResult){
			for(QuesVO quesVo:pageQuesList.getVal()){
				Ques ques=quesVo.getEntity();
				if(quesVo.isNew()){
					this.quesDao.insertEntity(ques);
				}else{
					this.quesDao.updateEntitySelectiveById(ques);
				}
				quesSnMap.put(quesVo.snKey(), quesVo.getSn());
				List<QuesOptionVO> quesOptionVoList=quesVo.getQuesOptionVoList();
				if(CollectionUtils.isEmpty(quesOptionVoList)){
					continue;
				}
				for(QuesOptionVO quesOptionVo:quesOptionVoList){
					QuesOption quesOption=quesOptionVo.getEntity();
					quesOption.setQuesId(ques.getId());
					if(quesOptionVo.isNew()){
						this.quesOptionDao.insertEntity(quesOption);
					}else{
						this.quesOptionDao.updateEntitySelectiveById(quesOption);
					}
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
	
	/**
	 * 执行删除数据库操作
	 * @param naireDeleteMess
	 * @throws Exception 
	 */
	private void processDeleteMess(NaireDeleteMess naireDeleteMess) throws Exception{
		if(naireDeleteMess==null){
			return ;
		}
		
		this.processQuesDeleteMess(naireDeleteMess.getQuesList());
		
		this.processQuesOptDeleteMess(naireDeleteMess.getQuesOptList());
	}
	/**
	 * 删除问题
	 * @param quesDeleteMessList
	 * @throws Exception
	 */
	private void processQuesDeleteMess(List<String> quesDeleteMessList) throws Exception{
		if(CollectionUtils.isEmpty(quesDeleteMessList)){
			return ;
		}
		for(String sn:quesDeleteMessList){
			long quesId=QuesVO.parseSn(sn);
			if(!QuesVO.isValidFromSn(quesId)){
				continue;
			}
			this.quesOptionDao.deleteByQuesId(quesId);
			this.quesDao.deleteById(quesId);
		}
	}
	/**
	 * 删除问题选项
	 * @param quesOptDeleteMessList
	 * @throws Exception
	 */
	private void processQuesOptDeleteMess(List<String> quesOptDeleteMessList) throws Exception{
		if(CollectionUtils.isEmpty(quesOptDeleteMessList)){
			return ;
		}
		for(String sn:quesOptDeleteMessList){
			long quesOptId=QuesOptionVO.parseSn(sn);
			if(!QuesOptionVO.isValidFromSn(quesOptId)){
				continue;
			}
			this.quesOptionDao.deleteById(quesOptId);
		}
	}

	@Override
	public NairePageMess getNairePageMess(long naireId, List<Integer> pageNoList) throws Exception {
		Map<Integer,List<QuesVO>> pageQuesMap=new HashMap<Integer, List<QuesVO>>();
		for(int pageNo:pageNoList){
			List<QuesVO> quesVoList=this.quesService.getQueses(naireId, pageNo);
			pageQuesMap.put(pageNo, quesVoList);
		}
		Processer<NairePageMess> processer=new QuesEncodeProcesser(pageQuesMap);
		NairePageMess ret=processer.process();
		return ret;
	}
	
}
