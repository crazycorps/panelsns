package com.panelsns.core.el;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractEvaluator implements Evaluator {

	public boolean executeBoolean(ExpressionConfig expressionConfig,
			Map<String, Object> env) {
		return false;
	}

	@Override
	public List<String> getVariableNames(ExpressionConfig expressionConfig) {
		return Collections.emptyList();
	}


	@Override
	public boolean isValidExpression(ExpressionConfig expressionConfig) {
		return false;
	}

	
}
