package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.LogicUnit;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface LogicUnitService extends GenericService<LogicUnit, Long> {

}
