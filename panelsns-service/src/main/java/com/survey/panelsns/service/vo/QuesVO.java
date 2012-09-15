package com.survey.panelsns.service.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.model.entity.QuesOption;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesVO extends AbstractObjectVO<Ques> {
	
	private static final byte[] SECRET_KEY=new byte[]{94, 20, 91, 23, -125, -71, 109, -121, -62, -19, 108, 4, 97, 43, -35, -29};
	
	public static final QuesComparator QUES_COMPARATOR=new QuesComparator();
	
	private String sn;
	
	public QuesVO() {
		super();
	}

	public QuesVO(Ques ques) {
		super(ques);
	}
	
	private List<QuesOptionVO> quesOptionVoList;

	public List<QuesOptionVO> getQuesOptionVoList() {
		return quesOptionVoList;
	}

	public void setQuesOptionVoList(List<QuesOptionVO> quesOptionVoList) {
		this.quesOptionVoList = quesOptionVoList;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return this.sn;
		}
		this.sn=toSn(this.entity.getId(), SECRET_KEY);
		return this.sn;
	}
	
	public long parseSn(){
		return parseSn(this.sn, SECRET_KEY);
	}
	
	public String snKey(){
		return "p_"+this.entity.getPageNo()+"_q_"+this.entity.getSerialNo();
	}
	
	public boolean isNew(){
		return StringUtils.isEmpty(this.sn)||(this.entity!=null&&this.entity.getId()==null);
	}
	
	public static long parseSn(String sn){
		return parseSn(sn, SECRET_KEY);
	}
	
	public static List<Ques> sortAsc(List<Ques> quesList){
		if(CollectionUtils.isEmpty(quesList)){
			return Collections.emptyList();
		}
		Collections.sort(quesList, QUES_COMPARATOR);
		return quesList;
	}
	
	public static List<QuesVO> sortAscAndWapperVo(List<Ques> quesList){
		if(CollectionUtils.isEmpty(quesList)){
			return Collections.emptyList();
		}
		List<Ques>  sortedList=sortAsc(quesList);
		List<QuesVO> ret=new ArrayList<QuesVO>();
		for(Ques ques:sortedList){
			ret.add(new QuesVO(ques));
		}
		return ret;
	}
	
	
	public static class QuesComparator implements Comparator<Ques>{

		@Override
		public int compare(Ques o1, Ques o2) {
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
