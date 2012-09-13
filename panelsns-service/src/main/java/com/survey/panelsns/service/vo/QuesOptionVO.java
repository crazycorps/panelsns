package com.survey.panelsns.service.vo;

import org.apache.commons.lang3.StringUtils;

import com.survey.panelsns.model.entity.QuesOption;
import com.survey.service.vo.AbstractObjectVO;

@SuppressWarnings("serial")
public class QuesOptionVO extends AbstractObjectVO<QuesOption> {

	private static final byte[] SECRET_KEY=new byte[]{-83, -122, -45, 86, -126, 78, 8, 1, -44, 50, 127, -26, -92, -47, 73, -27};
	
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
}
