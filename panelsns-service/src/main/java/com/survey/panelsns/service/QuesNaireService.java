package com.survey.panelsns.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.survey.panelsns.model.entity.QuesNaire;
import com.survey.service.GenericService;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public interface QuesNaireService extends GenericService<QuesNaire, Long> {

}
