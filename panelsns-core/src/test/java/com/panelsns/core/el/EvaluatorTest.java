package com.panelsns.core.el;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.panelsns.core.el.AviatorEvaluatorAdapter;
import com.panelsns.core.el.Evaluator;
import com.panelsns.core.el.ExpressionConfig;


public class EvaluatorTest {

	private AviatorEvaluatorAdapter aviatorEvaluatorAdapter =new AviatorEvaluatorAdapter();
	
	@Test
	public void isValidExpression(){
		String expression = "((!( q_1_2==1 && q_3_4 ==0 ) || (q_10_7 ==0 && (q_11_3==1 ))) && (q_20_1 == 1 ))|| !(q_100_2==0)";
		Assert.assertTrue(aviatorEvaluatorAdapter.isValidExpression(new ExpressionConfig(expression)));
	}
	
	@Test
	public void exec(){
		String expression = "((!( q_1_2==1 && q_3_4 ==0 ) || (q_10_7 ==0 && (q_11_3==1 ))) && (q_20_1 == 1 ))|| !(q_100_2==0)";
		Map<String,Object> evns=new HashMap<String,Object>();
		evns.put("q_1_2", 1);
		evns.put("q_3_4",0);
		evns.put("q_10_7", 0);
		evns.put("q_11_3", 0);
		evns.put("q_20_1", 1);
		evns.put("q_100_2", 0);
		
		Assert.assertTrue(aviatorEvaluatorAdapter.executeBoolean(new ExpressionConfig(expression), evns));
	}
	
	@Test
	public void getVariableNames(){
		String expression = "((!( q_1_2==1 && q_3_4 ==0 ) || (q_10_7 ==0 && (q_11_3==1 ))) && (q_20_1 == 1 ))|| !(q_100_2==0)";
		List<String> variableNameList=aviatorEvaluatorAdapter.getVariableNames(new ExpressionConfig(expression));
		for(String variable:variableNameList){
			Evaluator.logger.debug(variable);
		}
	}

}
