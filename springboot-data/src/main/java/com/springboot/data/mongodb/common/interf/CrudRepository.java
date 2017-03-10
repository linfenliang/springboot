/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.common.interf;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
public interface CrudRepository<T,ID extends Serializable> extends Repository<T,ID>{

	<S extends T> S save(S entity);
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	Long count();
	void delete(T entity);
	boolean exists(ID primaryKey);
	
	
	
	
	
}
