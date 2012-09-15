package com.survey.panelsns.dao.impl.mybatis;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.survey.dao.AbstractGenericDaoImpl;
import com.survey.panelsns.dao.QuesOptionDao;
import com.survey.panelsns.model.entity.QuesOption;

@Repository
public class QuesOptionDaoImpl extends AbstractGenericDaoImpl<QuesOption, Long> implements QuesOptionDao {

	@Override
	public String namespace() {
		return QuesOption.class.getName();
	}

	@Override
	public void deleteByQuesId(long quesId) {
		this.getSqlSessionTemplate().update(this.namespace()+".deleteByQuesId", quesId);
	}

	@Override
	public List<QuesOption> getQuesOptionsByQuesIds(List<Long> quesIdList) {
		if(CollectionUtils.isEmpty(quesIdList)){
			return Collections.emptyList();
		}
		return this.getSqlSessionTemplate().selectList(this.namespace()+".selectByQuesIds",quesIdList,new RowBounds(0, 1000));
	}

}
