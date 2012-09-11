package com.survey.panelsns.service.json;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

public class NairePageMess {
	
	private Map<String,Map<String,QuesAllMess>> pageMess;
	
	public Map<String, Map<String, QuesAllMess>> getPageMess() {
		return pageMess;
	}

	public void setPageMess(Map<String, Map<String, QuesAllMess>> pageMess) {
		this.pageMess = pageMess;
	}

	public static class QuesAllMess{
		private QuesTypeOption quesTypeOption;
		private QuesMess quesMess;
		public QuesTypeOption getQuesTypeOption() {
			return quesTypeOption;
		}
		public void setQuesTypeOption(QuesTypeOption quesTypeOption) {
			this.quesTypeOption = quesTypeOption;
		}
		public QuesMess getQuesMess() {
			return quesMess;
		}
		public void setQuesMess(QuesMess quesMess) {
			this.quesMess = quesMess;
		}
	}

	public static class QuesTypeOption{
		private boolean isRequire;
		private boolean isHasIntro;
		private int quesType;
		private int leastChoice;
		private int mostChoice;
		private int directionType;
		private int columnNumber;
		private boolean isShuffle;
		public boolean isRequire() {
			return isRequire;
		}
		public void setRequire(boolean isRequire) {
			this.isRequire = isRequire;
		}
		public boolean isHasIntro() {
			return isHasIntro;
		}
		public void setHasIntro(boolean isHasIntro) {
			this.isHasIntro = isHasIntro;
		}
		public int getQuesType() {
			return quesType;
		}
		public void setQuesType(int quesType) {
			this.quesType = quesType;
		}
		public int getLeastChoice() {
			return leastChoice;
		}
		public void setLeastChoice(int leastChoice) {
			this.leastChoice = leastChoice;
		}
		public int getMostChoice() {
			return mostChoice;
		}
		public void setMostChoice(int mostChoice) {
			this.mostChoice = mostChoice;
		}
		public int getDirectionType() {
			return directionType;
		}
		public void setDirectionType(int directionType) {
			this.directionType = directionType;
		}
		public int getColumnNumber() {
			return columnNumber;
		}
		public void setColumnNumber(int columnNumber) {
			this.columnNumber = columnNumber;
		}
		public boolean isShuffle() {
			return isShuffle;
		}
		public void setShuffle(boolean isShuffle) {
			this.isShuffle = isShuffle;
		}
	}
	
	public static class QuesMess{
		private String title;
		private String intro;
		private List<QuesOptionMess> quesOptionMessList;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getIntro() {
			return intro;
		}
		public void setIntro(String intro) {
			this.intro = intro;
		}
		public List<QuesOptionMess> getQuesOptionMessList() {
			return quesOptionMessList;
		}
		public void setQuesOptionMessList(List<QuesOptionMess> quesOptionMessList) {
			this.quesOptionMessList = quesOptionMessList;
		}
	}
	
	public static class QuesOptionMess{
		private String content;
		private boolean allowSpecify;
		private int inputWidth;
		private int leastInput;
		private int mostInput;
		private boolean isExclusive;
		
		@JsonIgnore
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public boolean isAllowSpecify() {
			return allowSpecify;
		}
		public void setAllowSpecify(boolean allowSpecify) {
			this.allowSpecify = allowSpecify;
		}
		public int getInputWidth() {
			return inputWidth;
		}
		public void setInputWidth(int inputWidth) {
			this.inputWidth = inputWidth;
		}
		public int getLeastInput() {
			return leastInput;
		}
		public void setLeastInput(int leastInput) {
			this.leastInput = leastInput;
		}
		public int getMostInput() {
			return mostInput;
		}
		public void setMostInput(int mostInput) {
			this.mostInput = mostInput;
		}
		public boolean isExclusive() {
			return isExclusive;
		}
		public void setExclusive(boolean isExclusive) {
			this.isExclusive = isExclusive;
		}
		
	}
}


