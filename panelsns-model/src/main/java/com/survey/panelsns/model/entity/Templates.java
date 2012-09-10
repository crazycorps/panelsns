package com.survey.panelsns.model.entity;

import java.util.Date;

public class Templates {
	
	public static final long DEFAULT_ID=0L;
	
	
    private Long id;

    
    private Integer type;

    
    private String name;

    
    private String path;

    
    private String descript;

    
    private Date createDate;

    
    private Integer version;

    
    private String remark;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
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

    
    public String getPath() {
        return path;
    }

    
    public void setPath(String path) {
        this.path = path;
    }

    
    public String getDescript() {
        return descript;
    }

    
    public void setDescript(String descript) {
        this.descript = descript;
    }

    
    public Date getCreateDate() {
        return createDate;
    }

    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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