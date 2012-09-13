package com.survey.panelsns.service.json;

import java.util.List;

public class NaireDeleteMess {
	// 删除的问题
	private List<String> quesList;
	// 删除的问题选项
	private List<String> quesOptList;
	
	public List<String> getQuesList() {
		return quesList;
	}
	public void setQuesList(List<String> quesList) {
		this.quesList = quesList;
	}
	public List<String> getQuesOptList() {
		return quesOptList;
	}
	public void setQuesOptList(List<String> quesOptList) {
		this.quesOptList = quesOptList;
	}
	
	
}
