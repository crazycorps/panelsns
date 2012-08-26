package com.survey.panelsns.model.entity;

import java.util.Date;

public class QuesNaire {
    
    private Long id;

    
    private Long surveyId;

    
    private Long templateId;

    
    private Integer type;

    
    private String name;

    
    private String code;

    
    private String header;

    
    private String title;

    
    private String footer;

    
    private Integer priority;

    
    private String descript;

    
    private Integer status;

    
    private Date createDate;

    
    private Date updaetDate;

    
    private Integer version;

    
    private String remark;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getSurveyId() {
        return surveyId;
    }

    
    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    
    public Long getTemplateId() {
        return templateId;
    }

    
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    
    public Integer getType() {
        return type;
    }

    
    public void setType(Integer type) {
        this.type = type;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getHeader() {
        return header;
    }

    
    public void setHeader(String header) {
        this.header = header;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getFooter() {
        return footer;
    }

    
    public void setFooter(String footer) {
        this.footer = footer;
    }

    
    public Integer getPriority() {
        return priority;
    }

    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    
    public String getDescript() {
        return descript;
    }

    
    public void setDescript(String descript) {
        this.descript = descript;
    }

    
    public Integer getStatus() {
        return status;
    }

    
    public void setStatus(Integer status) {
        this.status = status;
    }

    
    public Date getCreateDate() {
        return createDate;
    }

    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    public Date getUpdaetDate() {
        return updaetDate;
    }

    
    public void setUpdaetDate(Date updaetDate) {
        this.updaetDate = updaetDate;
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