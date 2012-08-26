package com.survey.panelsns.model.entity;

public class LogicUnit {
    
    private Long id;

    
    private Long quesNaireId;

    
    private Long quesId;

    
    private Long quesOptionId;

    
    private String quesOptionVal;

    
    private Long logicConditionId;

    
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

    
    public Long getQuesId() {
        return quesId;
    }

    
    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    
    public Long getQuesOptionId() {
        return quesOptionId;
    }

    
    public void setQuesOptionId(Long quesOptionId) {
        this.quesOptionId = quesOptionId;
    }

    
    public String getQuesOptionVal() {
        return quesOptionVal;
    }

    
    public void setQuesOptionVal(String quesOptionVal) {
        this.quesOptionVal = quesOptionVal;
    }

    
    public Long getLogicConditionId() {
        return logicConditionId;
    }

    
    public void setLogicConditionId(Long logicConditionId) {
        this.logicConditionId = logicConditionId;
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