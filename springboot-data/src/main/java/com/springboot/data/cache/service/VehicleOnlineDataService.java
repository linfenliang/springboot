/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.cache.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.springboot.data.cache.entity.VehicleOnlineData;


/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月24日
 */
@Service
@CacheConfig(cacheNames="vehicleOnlineDataService")
public class VehicleOnlineDataService {
	private static final Logger logger =  LoggerFactory.getLogger(VehicleOnlineDataService.class);

	static List<VehicleOnlineData> list = new ArrayList<>();
	static{
		for (int i = 0; i < 10; i++) {
			VehicleOnlineData v = new VehicleOnlineData();
			v.setId(RandomStringUtils.randomAlphabetic(32));
			v.setVehicleNo("京HM"+RandomStringUtils.randomNumeric(4));
			v.setCreateDate(new Date());
			v.setGatherTime(new Date());
			v.setAttitude(RandomUtils.nextInt(100, 300));
			list.add(v);
		}
	}
	@Cacheable(value="vehicleOnlineDataList")
	public List<VehicleOnlineData> list(){
		logger.debug("list");
		return list;
	}
	@Cacheable(value="vehicleOnlineData")
	public VehicleOnlineData get(VehicleOnlineData entity){
		logger.debug("get");
		for(VehicleOnlineData v:list){
			if(StringUtils.equals(v.getId(), entity.getId())){
				return v;
			}
		}
		return null;
	}
	@Caching(evict={@CacheEvict(value="vehicleOnlineData",allEntries=true),@CacheEvict(value="vehicleOnlineDataList",allEntries=true)})
	public VehicleOnlineData update(VehicleOnlineData entity){
		logger.debug("update");
		for(int index=0;index<VehicleOnlineDataService.list.size();index++){
			if(StringUtils.equals(VehicleOnlineDataService.list.get(index).getId(), entity.getId())){
				VehicleOnlineDataService.list.set(index, entity);
				return VehicleOnlineDataService.list.get(index);
			}
		}
		return null;
	}
//	@CachePut(value="vehicleOnlineDataList",keyGenerator = "keyGenerator")
	@CacheEvict(value="vehicleOnlineDataList",allEntries=true)
	public void add(VehicleOnlineData entity){
		logger.debug("add");
		list.add(entity);
		list.forEach(v->{
			System.out.println(v);
		});
	}
	
	
	@Caching(evict={@CacheEvict(value="vehicleOnlineData",allEntries=true),@CacheEvict(value="vehicleOnlineDataList",allEntries=true)})
	public void del(String id){
		logger.debug("del");
		Iterator<VehicleOnlineData> iter = VehicleOnlineDataService.list.iterator();
		while(iter.hasNext()){
			VehicleOnlineData v = iter.next();
			if(StringUtils.equals(v.getId(), id)){
				iter.remove();
			}
		}
	}
	
	
}
