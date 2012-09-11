package com.survey.panelsns.service.vo;

import org.apache.commons.codec.digest.DigestUtils;

import com.survey.panelsns.model.entity.Ques;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesVO extends AbstractObjectVO<Ques> {

	private static final String PREFIX="q_";
	
	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return null;
		}
		return DigestUtils.md5Hex(PREFIX+this.entity.getId());
	}
}
