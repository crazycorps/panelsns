package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.QuesOption;
import com.survey.panelsns.service.vo.QuesOptionVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface QuesOptionService extends GenericService<QuesOptionVO,QuesOption, Long> {

}
