package com.survey.panelsns.service.vo;

import com.survey.panelsns.core.Constant;
import com.survey.panelsns.model.entity.Survey;
import com.survey.service.vo.AbstractObjectVO;
import com.survey.tools.util.DateUtils;

@SuppressWarnings("serial")
public class SurveyVO extends AbstractObjectVO<Survey> {

	public String getFormatCreateDate(){
		if(this.entity==null||this.entity.getCreateDate()==null){
			return "";
		}
		return DateUtils.format(this.entity.getCreateDate(), Constant.DEFAULT_FORMAT_DATE_DAY);
	}

}
