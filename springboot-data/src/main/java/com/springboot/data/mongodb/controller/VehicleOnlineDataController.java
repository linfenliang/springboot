/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;
import com.springboot.data.mongodb.domain.VehicleOnlineData;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
@Controller
@RequestMapping("vehicle/onlinedata")
public class VehicleOnlineDataController {

	@Autowired
	private VehicleOnlineDataRepository vehicleOnlineDataRepository;
	@RequestMapping("list")
	@ResponseBody
	public void showData() throws IOException{
		System.out.println(vehicleOnlineDataRepository.count());
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 14, 18, 22, 18);
		Date gatherTimeBegin = cal.getTime();
		cal.add(Calendar.SECOND, 30);
		Date gatherTimeEnd = cal.getTime();
		Page<VehicleOnlineData> page = vehicleOnlineDataRepository.findByVehicleIdAndGatherTimeRange("98765432109876543210987654321032A", gatherTimeBegin, gatherTimeEnd,new PageRequest(0, 10,new Sort(Direction.DESC,"gatherTime")));

		
	}
}
