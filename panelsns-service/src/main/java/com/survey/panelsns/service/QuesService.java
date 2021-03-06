package com.survey.panelsns.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.Ques;
import com.survey.panelsns.service.vo.QuesVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface QuesService extends GenericService<QuesVO,Ques, Long> {

	List<QuesVO> getQueses(long naireId,int pageNo)throws Exception;
	
}
