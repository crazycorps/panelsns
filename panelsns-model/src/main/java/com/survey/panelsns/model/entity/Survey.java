package com.survey.panelsns.model.entity;

import java.util.Date;

public class Survey {
    private Long id;

    private Long projectId;

    private Integer industry;

    private String name;

    private Integer needPanelNum;

    private Integer endowPoint;

    private Integer hortationPoint;

    private Date beginDate;

    private Date endDate;

    private Date cancleDate;

    private Date createDate;

    private String descript;

    private Integer status;

    private Integer version;

    private String remark;
    
    transient private Long userId;
    
    transient private String clause;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNeedPanelNum() {
        return needPanelNum;
    }

    public void setNeedPanelNum(Integer needPanelNum) {
        this.needPanelNum = needPanelNum;
    }

    public Integer getEndowPoint() {
        return endowPoint;
    }

    public void setEndowPoint(Integer endowPoint) {
        this.endowPoint = endowPoint;
    }

    public Integer getHortationPoint() {
        return hortationPoint;
    }

    public void setHortationPoint(Integer hortationPoint) {
        this.hortationPoint = hortationPoint;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCancleDate() {
        return cancleDate;
    }

    public void setCancleDate(Date cancleDate) {
        this.cancleDate = cancleDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getClause() {
		return clause;
	}

	public void setClause(String clause) {
		this.clause = clause;
	}
    
}