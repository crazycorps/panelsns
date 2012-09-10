package com.survey.panelsns.service.processer;

/**
 * 其实现类，有处理业务的权限，每页查询和存储的权限
 * @author lenovo
 *
 * @param <T>
 */
public interface Processer<T> {
	
	T process();
	
}
