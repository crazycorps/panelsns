package com.survey.panelsns.model.entity;

import java.util.Date;

public class Ques {

	
	private Long id;
	
	private Long quesNaireId;
	
	private Integer type;
	
	private Integer pageNo;
	
	private Integer serialNo;
	
	private String busiNo;
	
	private String title;
	
	private String content;
	
	private String descript;
	
	private Integer mustAnswer;
	
	private Date createDate;
	
	private Date updateDate;
	
	private Integer version;
	
	private String remark;

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getQuesNaireId() {
		return quesNaireId;
	}

	
	public void setQuesNaireId(Long quesNaireId) {
		this.quesNaireId = quesNaireId;
	}

	
	public Integer getType() {
		return type;
	}

	
	public void setType(Integer type) {
		this.type = type;
	}

	
	public Integer getPageNo() {
		return pageNo;
	}

	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	
	public Integer getSerialNo() {
		return serialNo;
	}

	
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	
	public String getBusiNo() {
		return busiNo;
	}

	
	public void setBusiNo(String busiNo) {
		this.busiNo = busiNo;
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getContent() {
		return content;
	}

	
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getDescript() {
		return descript;
	}

	
	public void setDescript(String descript) {
		this.descript = descript;
	}

	
	public Integer getMustAnswer() {
		return mustAnswer;
	}

	
	public void setMustAnswer(Integer mustAnswer) {
		this.mustAnswer = mustAnswer;
	}

	
	public Date getCreateDate() {
		return createDate;
	}

	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public Date getUpdateDate() {
		return updateDate;
	}

	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public Integer getVersion() {
		return version;
	}

	
	public void setVersion(Integer version) {
		this.version = version;
	}

	
	public String getRemark() {
		return remark;
	}

	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}