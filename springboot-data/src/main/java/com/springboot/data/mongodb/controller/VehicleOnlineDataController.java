/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.data.mongodb.service.VehicleOnlineDataService;

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
	private VehicleOnlineDataService vehicleOnlineDataService;
	@RequestMapping("list")
	@ResponseBody
	public void showData(){
		System.out.println(vehicleOnlineDataService);
		System.out.println(vehicleOnlineDataService.getTotalCount("123"));
	}
}
