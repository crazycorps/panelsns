package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.LogicCondition;
import com.survey.panelsns.service.vo.LogicConditionVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface LogicConditionService extends GenericService<LogicConditionVO,LogicCondition, Long> {

}
