package com.survey.panelsns.model.entity;

import java.util.Date;

public class QuesNaire {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.survey_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Long surveyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.template_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Long templateId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.type
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Integer type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.name
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.code
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.header
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String header;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.title
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.footer
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String footer;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.priority
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Integer priority;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.descript
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String descript;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.status
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.total_page
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Integer totalPage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.create_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.updaet_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Date updaetDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.version
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private Integer version;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ques_naire.remark
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.id
	 * @return  the value of ques_naire.id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.id
	 * @param id  the value for ques_naire.id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.survey_id
	 * @return  the value of ques_naire.survey_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Long getSurveyId() {
		return surveyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.survey_id
	 * @param surveyId  the value for ques_naire.survey_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.template_id
	 * @return  the value of ques_naire.template_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Long getTemplateId() {
		return templateId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.template_id
	 * @param templateId  the value for ques_naire.template_id
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.type
	 * @return  the value of ques_naire.type
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.type
	 * @param type  the value for ques_naire.type
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.name
	 * @return  the value of ques_naire.name
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.name
	 * @param name  the value for ques_naire.name
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.code
	 * @return  the value of ques_naire.code
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.code
	 * @param code  the value for ques_naire.code
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.header
	 * @return  the value of ques_naire.header
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.header
	 * @param header  the value for ques_naire.header
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.title
	 * @return  the value of ques_naire.title
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.title
	 * @param title  the value for ques_naire.title
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.footer
	 * @return  the value of ques_naire.footer
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.footer
	 * @param footer  the value for ques_naire.footer
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.priority
	 * @return  the value of ques_naire.priority
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.priority
	 * @param priority  the value for ques_naire.priority
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.descript
	 * @return  the value of ques_naire.descript
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getDescript() {
		return descript;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.descript
	 * @param descript  the value for ques_naire.descript
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.status
	 * @return  the value of ques_naire.status
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.status
	 * @param status  the value for ques_naire.status
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.total_page
	 * @return  the value of ques_naire.total_page
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.total_page
	 * @param totalPage  the value for ques_naire.total_page
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.create_date
	 * @return  the value of ques_naire.create_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.create_date
	 * @param createDate  the value for ques_naire.create_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.updaet_date
	 * @return  the value of ques_naire.updaet_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Date getUpdaetDate() {
		return updaetDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.updaet_date
	 * @param updaetDate  the value for ques_naire.updaet_date
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setUpdaetDate(Date updaetDate) {
		this.updaetDate = updaetDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.version
	 * @return  the value of ques_naire.version
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.version
	 * @param version  the value for ques_naire.version
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ques_naire.remark
	 * @return  the value of ques_naire.remark
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ques_naire.remark
	 * @param remark  the value for ques_naire.remark
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}