package com.survey.panelsns.model;

public class Status {
	public enum SurveyStatus{
		EDITING("正在编辑"),CHECKING("正在审核"),RUNNING("正在运行"),FINISHED("已经结束"),CANCELED("已经取消");
		
		private String displayName;

		private SurveyStatus(String displayName) {
			this.displayName = displayName;
		}
		public int getIndex() {
			return this.ordinal();
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		
		public  SurveyStatus instanceOfByIndex(int index){
			if(index>=SurveyStatus.values().length||index<0){
				return null;
			}
			return SurveyStatus.values()[index];
		}
	}
}
