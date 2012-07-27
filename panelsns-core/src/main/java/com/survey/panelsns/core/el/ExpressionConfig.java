package com.survey.panelsns.core.el;

public class ExpressionConfig {

	private String expression;
	
	private boolean isCache;

	public ExpressionConfig(String expression) {
		super();
		this.expression = expression;
		this.isCache = false;
	}
	
	public ExpressionConfig(String expression, boolean isCache) {
		super();
		this.expression = expression;
		this.isCache = isCache;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}
	
	
	
}
