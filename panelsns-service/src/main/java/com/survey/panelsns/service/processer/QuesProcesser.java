package com.survey.panelsns.service.processer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.Ques.QuesType;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.vo.KV;
import com.survey.tools.util.JSONUtils;

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
			this.processPerPageMess(pageKeyNoKV,quesAllMessMap);
		}
		return null;
	}
	
	/**
	 * 处理每页上所有问题的
	 * @param quesAllMessMap 每页上包含的所有问题信息
	 */
	private void processPerPageMess(KV<String,Integer> pageKeyNoKV,Map<String,QuesAllMess> quesAllMessMap){
		Set<String> quesIdentityKeys=quesAllMessMap.keySet();
		List<KV<String,Integer>> sortQuesKeyNoList=this.getSortQuesKeyNo(quesIdentityKeys);
		for(KV<String,Integer> quesKeyNoKV:sortQuesKeyNoList){
			QuesAllMess quesAllMess=quesAllMessMap.get(quesKeyNoKV.getKey());
			this.processQuesAllMess(pageKeyNoKV.getVal(),quesKeyNoKV,quesAllMess);
		}
	}
	/**
	 * 处理单个问题
	 * @param quesAllMess
	 */
	private Ques processQuesAllMess(int pageNo,KV<String,Integer> quesKeyNoKV,QuesAllMess quesAllMess){
		QuesTypeOption quesTypeOption=quesAllMess.getQuesTypeOption();
		QuesMess quesMess=quesAllMess.getQuesMess();
		QuesType quesType=QuesType.intanceof(quesTypeOption.getQuesType());
		Ques ques=new Ques();
		ques.setQuesNaireId(this.naireId);
		ques.setType(quesType.ordinal());
		ques.setPageNo(pageNo);
		ques.setSerialNo(quesKeyNoKV.getVal());
		ques.setBusiNo("Q"+quesKeyNoKV.getVal()+":");
		ques.setTitle(quesMess.getTitle());
		ques.setContent(quesMess.getTitle());
		ques.setDescript(quesMess.getIntro());
		ques.setMustAnswer(quesTypeOption.isRequire()?1:0);
		Date now=new Date();
		ques.setCreateDate(now);
		ques.setUpdateDate(now);
		ques.setVersion(1);
		ques.setControlMess(JSONUtils.toJSON(quesTypeOption));
		
		List<QuesOptionMess> quesOptionMessList=quesMess.getQuesOptionMessList();
		if(quesOptionMessList!=null&&!quesOptionMessList.isEmpty()){
			List<QuesOption> quesOptionList=new ArrayList<QuesOption>();
			int i=1;
			for(QuesOptionMess quesOptionMess:quesOptionMessList){
				QuesOption quesOption=new QuesOption();
				quesOption.setQuesId(ques.getId());
				quesOption.setTitle(quesOptionMess.getContent());
				quesOption.setContent(quesOptionMess.getContent());
				quesOption.setSerialNo(i++);
				quesOption.setControlMess(JSONUtils.toJSON(quesOptionMess));
				quesOption.setVersion(1);
				quesOptionList.add(quesOption);
			}
			ques.setQuesOptionList(quesOptionList);
		}
		return ques;
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
