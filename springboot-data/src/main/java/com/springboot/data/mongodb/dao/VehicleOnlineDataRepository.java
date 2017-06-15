/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

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
	Long countByVehicleId(String vehicleId);
	@Query("{ 'vehicleId':?0, 'gatherTime': {$gte:?1,$lt:?2}}")
	Page<VehicleOnlineData> findByVehicleIdAndGatherTimeRange(String vehicleId,Date gatherTimeBegin,Date gatherTimeEnd,Pageable pageable);
	
//	void saveData(VehicleOnlineData entity);
}
