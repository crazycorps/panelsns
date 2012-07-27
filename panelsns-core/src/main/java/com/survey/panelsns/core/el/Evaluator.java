package com.survey.panelsns.core.el;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public interface Evaluator {
	
	public static final Logger logger=Logger.getLogger("evaluator");
	
	boolean isValidExpression(ExpressionConfig expressionConfig);
	
	List<String> getVariableNames(ExpressionConfig expressionConfig);
	
	boolean executeBoolean(ExpressionConfig expressionConfig ,Map<String, Object> env);
	
}
