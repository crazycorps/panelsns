package com.survey.panelsns.service.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.survey.panelsns.model.entity.QuesOption;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesOptionVO extends AbstractObjectVO<QuesOption> {

	private static final byte[] SECRET_KEY=new byte[]{-83, -122, -45, 86, -126, 78, 8, 1, -44, 50, 127, -26, -92, -47, 73, -27};
	
	public static final QuesOptionComparator QUES_OPTION_COMPARATOR=new QuesOptionComparator();
	
	private String sn;

	public QuesOptionVO() {
		super();
	}

	public QuesOptionVO(QuesOption entity) {
		super(entity);
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return sn;
		}
		this.sn=toSn(this.entity.getId(),SECRET_KEY);
		return sn;
	}
	
	public long parseSn(){
		return parseSn(this.sn, SECRET_KEY);
	}
	
	public String snKey(){
		return "qo_"+this.entity.getSerialNo();
	}
	
	public boolean isNew(){
		return StringUtils.isEmpty(this.sn)||(this.entity!=null&&this.entity.getId()==null);
	}
	
	public static long parseSn(String sn){
		return parseSn(sn, SECRET_KEY);
	}
	
	public static List<QuesOption> sortAsc(List<QuesOption> quesOptionList){
		if(CollectionUtils.isEmpty(quesOptionList)){
			return Collections.emptyList();
		}
		Collections.sort(quesOptionList, QUES_OPTION_COMPARATOR);
		return quesOptionList;
	}
	
	public static List<QuesOptionVO> sortAscAndWapperVo(List<QuesOption> quesOptionList){
		if(CollectionUtils.isEmpty(quesOptionList)){
			return Collections.emptyList();
		}
		List<QuesOption>  sortedList=sortAsc(quesOptionList);
		List<QuesOptionVO> ret=new ArrayList<QuesOptionVO>();
		for(QuesOption quesOption:sortedList){
			ret.add(new QuesOptionVO(quesOption));
		}
		return ret;
	}
	
	public static Map<Long,List<QuesOptionVO>> partitionByQuesAndSort(List<QuesOption> quesOptionList){
		if(CollectionUtils.isEmpty(quesOptionList)){
			return Collections.emptyMap();
		}
		Map<Long,List<QuesOption>> quesOptionMap=new HashMap<Long, List<QuesOption>>();
		for(QuesOption quesOption:quesOptionList){
			long quesId=quesOption.getQuesId();
			List<QuesOption> tempList=null;
			if(quesOptionMap.containsKey(quesId)){
				tempList=quesOptionMap.get(quesId);
			}else{
				tempList=new ArrayList<QuesOption>();
				quesOptionMap.put(quesId, tempList);
			}
			tempList.add(quesOption);
		}
		Map<Long,List<QuesOptionVO>> ret=new HashMap<Long, List<QuesOptionVO>>();
		for(Entry<Long,List<QuesOption>> entry:quesOptionMap.entrySet()){
			// 在此对问题选项按照序号进行排序
			List<QuesOptionVO> tempList=sortAscAndWapperVo(entry.getValue());
			ret.put(entry.getKey(), tempList);
		}
		return ret;
	}
	
	
	public static class QuesOptionComparator implements Comparator<QuesOption>{

		@Override
		public int compare(QuesOption o1, QuesOption o2) {
			if(o1.getSerialNo()>o2.getSerialNo()){
				return 1;
			}
			if(o1.getSerialNo()<o2.getSerialNo()){
				return -1;
			}
			return 0;
		}
		
	}
}
