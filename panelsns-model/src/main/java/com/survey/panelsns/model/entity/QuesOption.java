package com.survey.panelsns.model.entity;

public class QuesOption {
    
    private Long id;

    
    private Long quesId;

    
    private Integer serialNo;

    
    private String title;

    
    private String content;
    
    
    private String controlMess;

    
    private Integer version;

    
    private String remark;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getQuesId() {
        return quesId;
    }

    
    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    
    public Integer getSerialNo() {
        return serialNo;
    }

    
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
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
    
    
    public String getControlMess() {
		return controlMess;
	}


	public void setControlMess(String controlMess) {
		this.controlMess = controlMess;
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