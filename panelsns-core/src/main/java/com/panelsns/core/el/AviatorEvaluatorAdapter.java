package com.panelsns.core.el;

import java.util.List;
import java.util.Map;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * 针对于表达式采用其本身的缓存策略。
 * 如果内存非常高的话，要具体审核下表达式的缓存策略
 * @author jiong
 *
 */
public class AviatorEvaluatorAdapter extends AbstractEvaluator {
	
	@Override
	public boolean isValidExpression(ExpressionConfig expressionConfig) {
		 try {
			AviatorEvaluator.compile(expressionConfig.getExpression(),expressionConfig.isCache());
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public List<String> getVariableNames(ExpressionConfig expressionConfig) {
		Expression compiledExp=null;
		if(expressionConfig.isCache()){
			compiledExp=AviatorEvaluator.getCachedExpression(expressionConfig.getExpression());
		}
		if(compiledExp==null){
			compiledExp = AviatorEvaluator.compile(expressionConfig.getExpression(),expressionConfig.isCache());
		}
		return compiledExp.getVariableNames();
	}

	public boolean executeBoolean(ExpressionConfig expressionConfig,
			Map<String, Object> env) {
		Expression compiledExp = AviatorEvaluator.compile(expressionConfig.getExpression(),expressionConfig.isCache());
		return (Boolean)compiledExp.execute(env);
	}

}
