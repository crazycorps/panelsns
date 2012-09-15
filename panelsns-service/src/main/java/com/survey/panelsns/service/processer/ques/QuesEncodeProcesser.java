package com.survey.panelsns.service.processer.ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.CollectionUtils;

import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.json.NairePageMess;
import com.survey.panelsns.service.json.NairePageMess.QuesAllMess;
import com.survey.panelsns.service.json.NairePageMess.QuesMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionControlMess;
import com.survey.panelsns.service.json.NairePageMess.QuesOptionMess;
import com.survey.panelsns.service.json.NairePageMess.QuesTypeOption;
import com.survey.panelsns.service.processer.Processer;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.panelsns.service.vo.QuesVO;
import com.survey.tools.util.JSONUtils;

/**
 * 把问题转化为json数据对象 
 */
public class QuesEncodeProcesser implements Processer<NairePageMess> {

	private Map<Integer,List<QuesVO>> pageQuesMap;
	
	public QuesEncodeProcesser(Map<Integer, List<QuesVO>> pageQuesMap) {
		super();
		this.pageQuesMap = pageQuesMap;
	}

	@Override
	public NairePageMess process() {
		if(CollectionUtils.isEmpty(pageQuesMap)){
			return null;
		}
		Map<String, Map<String, QuesAllMess>> pageMess=new HashMap<String, Map<String,QuesAllMess>>();
		for(Entry<Integer, List<QuesVO>> entry:this.pageQuesMap.entrySet()){
			Map<String, QuesAllMess> quesAllMess=new HashMap<String, QuesAllMess>();
			for(QuesVO quesVo:entry.getValue()){
				Ques ques=quesVo.getEntity();
				QuesTypeOption quesTypeOption=JSONUtils.fromJSON(ques.getControlMess(), QuesTypeOption.class);
				
				String sn=quesVo.getSn();
				String title=ques.getTitle();
				String intro=ques.getDescript();
				List<QuesOptionMess> quesOptionMessList=this.convertQuesOptionMess(quesVo.getQuesOptionVoList());
				QuesMess quesMess=new QuesMess(sn, title, intro, quesOptionMessList);
				
				quesAllMess.put("q_"+ques.getSerialNo(), new QuesAllMess(quesTypeOption, quesMess));
			}
			pageMess.put("p_"+entry.getKey(), quesAllMess);
		}
		return new NairePageMess(pageMess);
	}
	
	private List<QuesOptionMess> convertQuesOptionMess(List<QuesOptionVO> quesOptionVoList){
		if(CollectionUtils.isEmpty(quesOptionVoList)){
			return Collections.emptyList();
		}
		List<QuesOptionMess> ret=new ArrayList<NairePageMess.QuesOptionMess>();
		for(QuesOptionVO quesOptionVo:quesOptionVoList){
			QuesOption quesOption=quesOptionVo.getEntity();
			
			String sn=quesOptionVo.getSn();
			String content=quesOption.getContent();
			QuesOptionControlMess quesOptionControlMess=JSONUtils.fromJSON(quesOption.getControlMess(), QuesOptionControlMess.class);
			ret.add(new QuesOptionMess(sn, content, quesOptionControlMess));
		}
		return ret;
	}

}
