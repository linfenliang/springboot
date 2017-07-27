/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.cache.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月24日
 */
public class VehicleOnlineData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4374693708959369614L;
	private String id;
	private String vehicleNo;
	private Date gatherTime;
	private Float latitude;
	private Float longitude;
	private Integer attitude;
	private Date createDate;
	
	public VehicleOnlineData(String id) {
		this.id = id;
	}
	public VehicleOnlineData() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public Date getGatherTime() {
		return gatherTime;
	}
	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Integer getAttitude() {
		return attitude;
	}
	public void setAttitude(Integer attitude) {
		this.attitude = attitude;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
