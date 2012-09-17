package com.survey.panelsns.model.entity;

public class Answer {
    
    private Long id;

    
    private Long answerMessId;

    
    private Long userId;

    
    private Long naireId;

    
    private Integer pageNo;

    
    private Long quesId;

    
    private Integer quesNo;

    
    private Long quesOptId;

    
    private Integer quesOptNo;

    
    private String answerVal;

    
    private String remark;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getAnswerMessId() {
        return answerMessId;
    }

    
    public void setAnswerMessId(Long answerMessId) {
        this.answerMessId = answerMessId;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Long getNaireId() {
        return naireId;
    }

    
    public void setNaireId(Long naireId) {
        this.naireId = naireId;
    }

    
    public Integer getPageNo() {
        return pageNo;
    }

    
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    
    public Long getQuesId() {
        return quesId;
    }

    
    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    
    public Integer getQuesNo() {
        return quesNo;
    }

    
    public void setQuesNo(Integer quesNo) {
        this.quesNo = quesNo;
    }

    
    public Long getQuesOptId() {
        return quesOptId;
    }

    
    public void setQuesOptId(Long quesOptId) {
        this.quesOptId = quesOptId;
    }

    
    public Integer getQuesOptNo() {
        return quesOptNo;
    }

    
    public void setQuesOptNo(Integer quesOptNo) {
        this.quesOptNo = quesOptNo;
    }

    
    public String getAnswerVal() {
        return answerVal;
    }

    
    public void setAnswerVal(String answerVal) {
        this.answerVal = answerVal;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }
}