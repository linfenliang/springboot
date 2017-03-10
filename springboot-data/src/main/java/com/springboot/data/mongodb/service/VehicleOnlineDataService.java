/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
@Service
public class VehicleOnlineDataService {

	@Autowired
	private VehicleOnlineDataRepository repository;
	
	public Long getTotalCount(String vehicleId){
		System.out.println(repository);
		Long count = repository.countByVehicleId(vehicleId);
		return count;
	}
}
