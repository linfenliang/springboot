/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.data.mongodb.domain.VehicleOnlineData;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
public interface VehicleOnlineDataRepository extends MongoRepository<VehicleOnlineData, String> {
//CrudRepository<VehicleOnlineData, String>
//	Long countByVehicleId(String vehicleId);
	List<VehicleOnlineData> findByVehicleId(String vehicleId);
//	void saveData(VehicleOnlineData entity);
}
