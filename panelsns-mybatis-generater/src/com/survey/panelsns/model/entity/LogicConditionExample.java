package com.survey.panelsns.model.entity;

import java.util.ArrayList;
import java.util.List;

public class LogicConditionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public LogicConditionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdIsNull() {
			addCriterion("logic_group_id is null");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdIsNotNull() {
			addCriterion("logic_group_id is not null");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdEqualTo(Long value) {
			addCriterion("logic_group_id =", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdNotEqualTo(Long value) {
			addCriterion("logic_group_id <>", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdGreaterThan(Long value) {
			addCriterion("logic_group_id >", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdGreaterThanOrEqualTo(Long value) {
			addCriterion("logic_group_id >=", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdLessThan(Long value) {
			addCriterion("logic_group_id <", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdLessThanOrEqualTo(Long value) {
			addCriterion("logic_group_id <=", value, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdIn(List<Long> values) {
			addCriterion("logic_group_id in", values, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdNotIn(List<Long> values) {
			addCriterion("logic_group_id not in", values, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdBetween(Long value1, Long value2) {
			addCriterion("logic_group_id between", value1, value2, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andLogicGroupIdNotBetween(Long value1, Long value2) {
			addCriterion("logic_group_id not between", value1, value2, "logicGroupId");
			return (Criteria) this;
		}

		public Criteria andExpressionValIsNull() {
			addCriterion("expression_val is null");
			return (Criteria) this;
		}

		public Criteria andExpressionValIsNotNull() {
			addCriterion("expression_val is not null");
			return (Criteria) this;
		}

		public Criteria andExpressionValEqualTo(Long value) {
			addCriterion("expression_val =", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValNotEqualTo(Long value) {
			addCriterion("expression_val <>", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValGreaterThan(Long value) {
			addCriterion("expression_val >", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValGreaterThanOrEqualTo(Long value) {
			addCriterion("expression_val >=", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValLessThan(Long value) {
			addCriterion("expression_val <", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValLessThanOrEqualTo(Long value) {
			addCriterion("expression_val <=", value, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValIn(List<Long> values) {
			addCriterion("expression_val in", values, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValNotIn(List<Long> values) {
			addCriterion("expression_val not in", values, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValBetween(Long value1, Long value2) {
			addCriterion("expression_val between", value1, value2, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andExpressionValNotBetween(Long value1, Long value2) {
			addCriterion("expression_val not between", value1, value2, "expressionVal");
			return (Criteria) this;
		}

		public Criteria andLoginIdIsNull() {
			addCriterion("login_id is null");
			return (Criteria) this;
		}

		public Criteria andLoginIdIsNotNull() {
			addCriterion("login_id is not null");
			return (Criteria) this;
		}

		public Criteria andLoginIdEqualTo(Long value) {
			addCriterion("login_id =", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotEqualTo(Long value) {
			addCriterion("login_id <>", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThan(Long value) {
			addCriterion("login_id >", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThanOrEqualTo(Long value) {
			addCriterion("login_id >=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThan(Long value) {
			addCriterion("login_id <", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThanOrEqualTo(Long value) {
			addCriterion("login_id <=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdIn(List<Long> values) {
			addCriterion("login_id in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotIn(List<Long> values) {
			addCriterion("login_id not in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdBetween(Long value1, Long value2) {
			addCriterion("login_id between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotBetween(Long value1, Long value2) {
			addCriterion("login_id not between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andVersionIsNull() {
			addCriterion("version is null");
			return (Criteria) this;
		}

		public Criteria andVersionIsNotNull() {
			addCriterion("version is not null");
			return (Criteria) this;
		}

		public Criteria andVersionEqualTo(Integer value) {
			addCriterion("version =", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotEqualTo(Integer value) {
			addCriterion("version <>", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThan(Integer value) {
			addCriterion("version >", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("version >=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThan(Integer value) {
			addCriterion("version <", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThanOrEqualTo(Integer value) {
			addCriterion("version <=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionIn(List<Integer> values) {
			addCriterion("version in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotIn(List<Integer> values) {
			addCriterion("version not in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionBetween(Integer value1, Integer value2) {
			addCriterion("version between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("version not between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table logic_condition
	 * @mbggenerated  Mon Sep 17 23:07:17 CST 2012
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table logic_condition
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 29 21:04:38 CST 2012
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}