/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.cache;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.data.cache.entity.VehicleOnlineData;
import com.springboot.data.cache.service.VehicleOnlineDataService;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月24日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CacheApp.class)
public class CacheRedisTest {
	private static final Logger logger = LoggerFactory.getLogger(CacheRedisTest.class);
	@Autowired
	private VehicleOnlineDataService service;
	
	String id = null;
	@Before
	public void listTest(){
		if(id==null){
			List<VehicleOnlineData> list = service.list();
			list.forEach(v->{
				logger.debug(v.toString());
			});
			id = list.get(0).getId();
		}
	}
	@Test
	public void upateTest(){
		logger.debug("第一次根据ID：{}取数据{}",id,service.get(new VehicleOnlineData(id)).toString());
		logger.debug("第二次根据ID：{}取数据{}",id,service.get(new VehicleOnlineData(id)).toString());
		VehicleOnlineData v = new VehicleOnlineData();
		v.setId(id);
		v.setVehicleNo("测试修改后的车辆");
		VehicleOnlineData vv = service.update(v);
		logger.debug("{}",vv);
		logger.debug("第三次根据ID：{}取数据{}",id,service.get(new VehicleOnlineData(id)).toString());
		logger.debug("修改记录后获取集合数据：");
		List<VehicleOnlineData> list = service.list();
		list.forEach(e->{
			logger.debug(e.toString());
		});
		
		VehicleOnlineData entity = new VehicleOnlineData();
		entity.setId(RandomStringUtils.randomAlphabetic(32));
		entity.setVehicleNo("京HM"+RandomStringUtils.randomNumeric(4));
		entity.setCreateDate(new Date());
		entity.setGatherTime(new Date());
		entity.setAttitude(RandomUtils.nextInt(100, 300));
		logger.debug("新增一条记录：{}",entity);
		service.add(entity);
		logger.debug("新增记录后获取集合数据：");
		list = service.list();
		list.forEach(e->{
			logger.debug(e.toString());
		});
		
		
//		service.del(id);
//		list = service.list();
//		list.forEach(e->{
//			logger.debug(e.toString());
//		});
	}
	
}
