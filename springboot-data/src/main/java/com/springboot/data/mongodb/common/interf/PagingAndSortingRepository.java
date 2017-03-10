/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.common.interf;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
public interface PagingAndSortingRepository<T,ID extends Serializable> extends CrudRepository<T, ID>{

	Iterable<T> findAll(Sort sort);
	Page<T> findAll(Pageable pageable);
}
