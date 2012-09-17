package com.survey.panelsns.model.entity;

import java.util.Date;

public class AnswerMess {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.naire_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Long naireId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.user_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.answer_times
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Integer answerTimes;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.begin_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Date beginDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.last_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Date lastDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.end_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Date endDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.status
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.invalidate
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Integer invalidate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.first_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private String firstAnswerIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.end_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private String endAnswerIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.ext_in_params
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private String extInParams;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.version
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private Integer version;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column answer_mess.remark
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.id
	 * @return  the value of answer_mess.id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.id
	 * @param id  the value for answer_mess.id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.naire_id
	 * @return  the value of answer_mess.naire_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Long getNaireId() {
		return naireId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.naire_id
	 * @param naireId  the value for answer_mess.naire_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setNaireId(Long naireId) {
		this.naireId = naireId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.user_id
	 * @return  the value of answer_mess.user_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.user_id
	 * @param userId  the value for answer_mess.user_id
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.answer_times
	 * @return  the value of answer_mess.answer_times
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Integer getAnswerTimes() {
		return answerTimes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.answer_times
	 * @param answerTimes  the value for answer_mess.answer_times
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setAnswerTimes(Integer answerTimes) {
		this.answerTimes = answerTimes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.begin_date
	 * @return  the value of answer_mess.begin_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.begin_date
	 * @param beginDate  the value for answer_mess.begin_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.last_date
	 * @return  the value of answer_mess.last_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Date getLastDate() {
		return lastDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.last_date
	 * @param lastDate  the value for answer_mess.last_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.end_date
	 * @return  the value of answer_mess.end_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.end_date
	 * @param endDate  the value for answer_mess.end_date
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.status
	 * @return  the value of answer_mess.status
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.status
	 * @param status  the value for answer_mess.status
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.invalidate
	 * @return  the value of answer_mess.invalidate
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Integer getInvalidate() {
		return invalidate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.invalidate
	 * @param invalidate  the value for answer_mess.invalidate
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setInvalidate(Integer invalidate) {
		this.invalidate = invalidate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.first_answer_ip
	 * @return  the value of answer_mess.first_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public String getFirstAnswerIp() {
		return firstAnswerIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.first_answer_ip
	 * @param firstAnswerIp  the value for answer_mess.first_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setFirstAnswerIp(String firstAnswerIp) {
		this.firstAnswerIp = firstAnswerIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.end_answer_ip
	 * @return  the value of answer_mess.end_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public String getEndAnswerIp() {
		return endAnswerIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.end_answer_ip
	 * @param endAnswerIp  the value for answer_mess.end_answer_ip
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setEndAnswerIp(String endAnswerIp) {
		this.endAnswerIp = endAnswerIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.ext_in_params
	 * @return  the value of answer_mess.ext_in_params
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public String getExtInParams() {
		return extInParams;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.ext_in_params
	 * @param extInParams  the value for answer_mess.ext_in_params
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setExtInParams(String extInParams) {
		this.extInParams = extInParams;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.version
	 * @return  the value of answer_mess.version
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.version
	 * @param version  the value for answer_mess.version
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column answer_mess.remark
	 * @return  the value of answer_mess.remark
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column answer_mess.remark
	 * @param remark  the value for answer_mess.remark
	 * @mbggenerated  Tue Sep 18 00:39:07 CST 2012
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}