package com.survey.panelsns.service.processer.ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.Ques.QuesType;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionControlMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.vo.KV;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.panelsns.service.vo.QuesVO;
import com.survey.tools.util.JSONUtils;

/**
 * 通过json转化后的数据，转化为对应的问题类型
 */
public class QuesDecodeProcesser implements Processer<List<KV<Integer,List<QuesVO>>>>{

	private long naireId;
	private NairePageMess nairePageMess;
	
	public QuesDecodeProcesser(long naireId, NairePageMess nairePageMess) {
		super();
		this.naireId = naireId;
		this.nairePageMess = nairePageMess;
	}

	@Override
	public List<KV<Integer,List<QuesVO>>> process() {
		if(nairePageMess==null){
			return null;
		}
		Map<String,Map<String,QuesAllMess>> pageMess=nairePageMess.getPageMess();
		if(pageMess==null){
			return null;
		}
		
		List<KV<Integer,List<QuesVO>>> ret=new ArrayList<KV<Integer,List<QuesVO>>>();
		
		Set<String> pageIdentityKeys=pageMess.keySet();
		List<KV<String,Integer>> sortPageKeyNoList=this.getSortPageKeyNo(pageIdentityKeys);
		for(KV<String,Integer> pageKeyNoKV:sortPageKeyNoList){
			Map<String,QuesAllMess> quesAllMessMap=pageMess.get(pageKeyNoKV.getKey());
			List<QuesVO> quesList=this.processPerPageMess(pageKeyNoKV,quesAllMessMap);
			if(CollectionUtils.isEmpty(quesList)){
				continue;
			}
			ret.add(new KV<Integer,List<QuesVO>>(pageKeyNoKV.getVal(),quesList));
		}
		return ret;
	}
	
	/**
	 * 处理每页上所有问题的
	 * @param quesAllMessMap 每页上包含的所有问题信息
	 */
	private List<QuesVO> processPerPageMess(KV<String,Integer> pageKeyNoKV,Map<String,QuesAllMess> quesAllMessMap){
		List<QuesVO> ret=new ArrayList<QuesVO>();
		Set<String> quesIdentityKeys=quesAllMessMap.keySet();
		List<KV<String,Integer>> sortQuesKeyNoList=this.getSortQuesKeyNo(quesIdentityKeys);
		for(KV<String,Integer> quesKeyNoKV:sortQuesKeyNoList){
			QuesAllMess quesAllMess=quesAllMessMap.get(quesKeyNoKV.getKey());
			QuesVO quesVo=this.processQuesAllMess(pageKeyNoKV.getVal(),quesKeyNoKV,quesAllMess);
			if(quesVo==null){
				continue;
			}
			ret.add(quesVo);
		}
		return ret;
	}
	/**
	 * 处理单个问题
	 * @param quesAllMess
	 */
	private QuesVO processQuesAllMess(int pageNo,KV<String,Integer> quesKeyNoKV,QuesAllMess quesAllMess){
		QuesTypeOption quesTypeOption=quesAllMess.getQuesTypeOption();
		QuesMess quesMess=quesAllMess.getQuesMess();
		if(quesTypeOption==null||quesMess==null){
			return null;
		}
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
		QuesVO quesVo=new QuesVO(ques);
		quesMess.setSnKey(quesVo.snKey());
		// 通过sn判断是否是更新还是新建
		if(StringUtils.isNotEmpty(quesMess.getSn())){
			quesVo.setSn(quesMess.getSn());
			long tempId=quesVo.parseSn();
			if(QuesVO.isValidFromSn(tempId)){
				ques.setId(tempId);
			}
		}
		
		List<QuesOptionMess> quesOptionMessList=quesMess.getQuesOptionMessList();
		if(quesOptionMessList!=null&&!quesOptionMessList.isEmpty()){
			List<QuesOptionVO> quesOptionVoList=new ArrayList<QuesOptionVO>();
			int i=1;
			for(QuesOptionMess quesOptionMess:quesOptionMessList){
				QuesOptionControlMess quesOptionControlMess=quesOptionMess.getQuesOptionControlMess();
				QuesOption quesOption=new QuesOption();
				quesOption.setNaireId(this.naireId);
				quesOption.setQuesId(ques.getId());
				quesOption.setTitle(quesOptionMess.getContent());
				quesOption.setContent(quesOptionMess.getContent());
				quesOption.setSerialNo(i++);
				quesOption.setControlMess(JSONUtils.toJSON(quesOptionControlMess));
				quesOption.setVersion(1);
				QuesOptionVO quesOptionVO=new QuesOptionVO(quesOption);
				quesOptionMess.setSnKey(quesVo.snKey()+"_"+quesOptionVO.snKey());
				if(StringUtils.isNotEmpty(quesOptionMess.getSn())){
					quesOptionVO.setSn(quesOptionMess.getSn());
					long tempId=quesOptionVO.parseSn();
					if(QuesOptionVO.isValidFromSn(tempId)){
						quesOption.setId(tempId);
					}
				}
				quesOptionVoList.add(quesOptionVO);
			}
			quesVo.setQuesOptionVoList(quesOptionVoList);
		}
		return quesVo;
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
