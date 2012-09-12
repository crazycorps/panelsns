package com.survey.panelsns.service.vo;

import com.survey.panelsns.model.entity.QuesOption;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesOptionVO extends AbstractObjectVO<QuesOption> {

	private static final byte[] SECRET_KEY=new byte[]{-83, -122, -45, 86, -126, 78, 8, 1, -44, 50, 127, -26, -92, -47, 73, -27};

	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return null;
		}
		return toSn(this.entity.getId(),SECRET_KEY);
	}
	
	
}
