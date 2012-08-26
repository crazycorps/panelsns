package com.survey.panelsns.model.entity;

public class LogicCondition {
    
    private Long id;

    
    private Long logicGroupId;

    
    private Long expressionVal;

    
    private Long loginId;

    
    private Integer version;

    
    private String remark;

    
    private String expression;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getLogicGroupId() {
        return logicGroupId;
    }

    
    public void setLogicGroupId(Long logicGroupId) {
        this.logicGroupId = logicGroupId;
    }

    
    public Long getExpressionVal() {
        return expressionVal;
    }

    
    public void setExpressionVal(Long expressionVal) {
        this.expressionVal = expressionVal;
    }

    
    public Long getLoginId() {
        return loginId;
    }

    
    public void setLoginId(Long loginId) {
        this.loginId = loginId;
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

    
    public String getExpression() {
        return expression;
    }

    
    public void setExpression(String expression) {
        this.expression = expression;
    }
}