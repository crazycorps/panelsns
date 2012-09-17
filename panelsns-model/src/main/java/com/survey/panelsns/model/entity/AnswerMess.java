package com.survey.panelsns.model.entity;

import java.util.Date;

public class AnswerMess {
    
    private Long id;

    
    private Long naireId;

    
    private Long userId;

    
    private Integer answerTimes;

    
    private Date beginDate;

    
    private Date lastDate;

    
    private Date endDate;

    
    private Integer status;

    
    private Integer invalidate;

    
    private String firstAnswerIp;

    
    private String endAnswerIp;

    
    private String extInParams;

    
    private Integer version;

    
    private String remark;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getNaireId() {
        return naireId;
    }

    
    public void setNaireId(Long naireId) {
        this.naireId = naireId;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Integer getAnswerTimes() {
        return answerTimes;
    }

    
    public void setAnswerTimes(Integer answerTimes) {
        this.answerTimes = answerTimes;
    }

    
    public Date getBeginDate() {
        return beginDate;
    }

    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    
    public Date getLastDate() {
        return lastDate;
    }

    
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    
    public Date getEndDate() {
        return endDate;
    }

    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    public Integer getStatus() {
        return status;
    }

    
    public void setStatus(Integer status) {
        this.status = status;
    }

    
    public Integer getInvalidate() {
        return invalidate;
    }

    
    public void setInvalidate(Integer invalidate) {
        this.invalidate = invalidate;
    }

    
    public String getFirstAnswerIp() {
        return firstAnswerIp;
    }

    
    public void setFirstAnswerIp(String firstAnswerIp) {
        this.firstAnswerIp = firstAnswerIp;
    }

    
    public String getEndAnswerIp() {
        return endAnswerIp;
    }

    
    public void setEndAnswerIp(String endAnswerIp) {
        this.endAnswerIp = endAnswerIp;
    }

    
    public String getExtInParams() {
        return extInParams;
    }

    
    public void setExtInParams(String extInParams) {
        this.extInParams = extInParams;
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