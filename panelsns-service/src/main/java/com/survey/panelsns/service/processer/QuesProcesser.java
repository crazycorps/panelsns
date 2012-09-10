package com.survey.panelsns.service.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.vo.KV;

public class QuesProcesser implements Processer<Object>{

	private long userId;
	private long surveyId;
	private long naireId;
	private NairePageMess nairePageMess;
	
	public QuesProcesser(long userId, long surveyId, long naireId, NairePageMess nairePageMess) {
		super();
		this.userId = userId;
		this.surveyId = surveyId;
		this.naireId = naireId;
		this.nairePageMess = nairePageMess;
	}

	@Override
	public Object process() {
		if(nairePageMess==null){
			return null;
		}
		Map<String,Map<String,QuesAllMess>> pageMess=nairePageMess.getPageMess();
		if(pageMess==null){
			return null;
		}
		
		Set<String> pageIdentityKeys=pageMess.keySet();
		List<KV<String,Integer>> sortPageKeyNoList=this.getSortPageKeyNo(pageIdentityKeys);
		for(KV<String,Integer> pageKeyNoKV:sortPageKeyNoList){
			Map<String,QuesAllMess> quesAllMessMap=pageMess.get(pageKeyNoKV.getKey());
			this.processPerPageMess(quesAllMessMap);
		}
		return null;
	}
	
	/**
	 * 处理每页上所有问题的
	 * @param quesAllMessMap 每页上包含的所有问题信息
	 */
	private void processPerPageMess(Map<String,QuesAllMess> quesAllMessMap){
		Set<String> quesIdentityKeys=quesAllMessMap.keySet();
		List<KV<String,Integer>> sortQuesKeyNoList=this.getSortQuesKeyNo(quesIdentityKeys);
		for(KV<String,Integer> quesKeyNoKV:sortQuesKeyNoList){
			QuesAllMess quesAllMess=quesAllMessMap.get(quesKeyNoKV.getKey());
			this.processQuesAllMess(quesAllMess);
		}
	}
	/**
	 * 处理单个问题
	 * @param quesAllMess
	 */
	private void processQuesAllMess(QuesAllMess quesAllMess){
		QuesTypeOption quesTypeOption=quesAllMess.getQuesTypeOption();
		QuesMess quesMess=quesAllMess.getQuesMess();
		QuesNaire naire=new QuesNaire();
		
	}
	
	/**
	 * 通过解析key，过滤出问卷页，并排序
	 * @param pageIdentityKeys
	 * @return
	 */
	private List<KV<String,Integer>> getSortPageKeyNo(Set<String> pageIdentityKeys){
		if(pageIdentityKeys==null||pageIdentityKeys.isEmpty()){
			return Collections.emptyList();
		}
		List<KV<String,Integer>> ret=new ArrayList<KV<String,Integer>>();
		for(String key:pageIdentityKeys){
			String valStr=key.substring(key.indexOf("p_")+2);
			if(StringUtils.isEmpty(valStr)||!StringUtils.isNumeric(valStr)){
				continue;
			}
			ret.add(new KV<String,Integer>(key,Integer.parseInt(valStr)));
		}
		Collections.sort(ret, KV.VAL_INTEGER_ASC_COMPARATOR);
		
		return ret;
	}
	
	/**
	 * 
	 * @param pageIdentityKeys
	 * @return
	 */
	private List<KV<String,Integer>> getSortQuesKeyNo(Set<String> quesIdentityKeys){
		if(quesIdentityKeys==null||quesIdentityKeys.isEmpty()){
			return Collections.emptyList();
		}
		List<KV<String,Integer>> ret=new ArrayList<KV<String,Integer>>();
		for(String key:quesIdentityKeys){
			String valStr=key.substring(key.indexOf("q_")+2);
			if(StringUtils.isEmpty(valStr)||!StringUtils.isNumeric(valStr)){
				continue;
			}
			ret.add(new KV<String,Integer>(key,Integer.parseInt(valStr)));
		}
		Collections.sort(ret, KV.VAL_INTEGER_ASC_COMPARATOR);
		
		return ret;
	}

	
	
}
