package com.survey.panelsns.service.vo;

import java.util.List;

import com.survey.panelsns.model.entity.Ques;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesVO extends AbstractObjectVO<Ques> {
	
	private static final byte[] SECRET_KEY=new byte[]{94, 20, 91, 23, -125, -71, 109, -121, -62, -19, 108, 4, 97, 43, -35, -29};
	
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

	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return null;
		}
		try {
			return toSn(this.entity.getId(), SECRET_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String snKey(){
		return "p_"+this.entity.getPageNo()+"_q_"+this.entity.getSerialNo();
	}
	
}
