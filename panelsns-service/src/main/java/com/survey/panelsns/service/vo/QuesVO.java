package com.survey.panelsns.service.vo;

import org.apache.commons.codec.binary.Hex;

import com.survey.panelsns.model.entity.Ques;
import com.survey.service.vo.AbstractObjectVO;
import com.survey.tools.encrypt.AESCoder;
import com.survey.tools.util.BitUtils;

@SuppressWarnings("serial")
public class QuesVO extends AbstractObjectVO<Ques> {
	
	private static final byte[] SECRET_KEY=AESCoder.initSecretKey();

	public String getSn(){
		if(this.entity==null||this.entity.getId()==null){
			return null;
		}
		try {
			return Hex.encodeHexString(AESCoder.encrypt(BitUtils.long2bytes(this.entity.getId()), SECRET_KEY));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public long parseSn(String sn){
		try {
			byte[] data = AESCoder.decrypt(sn.getBytes(), SECRET_KEY);
			return BitUtils.bytes2long(data, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1L;
	}
}
