package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.Templates;
import com.survey.panelsns.service.vo.TemplatesVO;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface TemplatesService extends GenericService<TemplatesVO,Templates, Long> {

}
