package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.AnswerMess;
import com.survey.panelsns.service.vo.AnswerMessVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface AnswerMessService extends GenericService<AnswerMessVO,AnswerMess, Long> {

}
