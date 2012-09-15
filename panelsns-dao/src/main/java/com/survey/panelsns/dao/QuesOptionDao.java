package com.survey.panelsns.dao;

import java.util.List;

import com.survey.dao.GenericDao;
import com.survey.panelsns.model.entity.QuesOption;


public interface QuesOptionDao extends GenericDao<QuesOption, Long> {

	void deleteByQuesId(long quesId);
	
	List<QuesOption> getQuesOptionsByQuesIds(List<Long> quesIdList);
	
}
