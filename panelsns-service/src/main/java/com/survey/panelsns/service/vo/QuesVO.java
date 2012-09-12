package com.survey.panelsns.service.vo;

import com.survey.panelsns.model.entity.Ques;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesVO extends AbstractObjectVO<Ques> {
	
	private static final byte[] SECRET_KEY=new byte[]{94, 20, 91, 23, -125, -71, 109, -121, -62, -19, 108, 4, 97, 43, -35, -29};

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
	
}
