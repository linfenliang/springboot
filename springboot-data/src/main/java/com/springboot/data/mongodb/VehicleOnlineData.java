/*
 * 版权信息：北京中宇恒信科技有限责任公司</br>
 * Copyright ©2007-2016. All rights reserved. 京ICP备08102035号
 */
package com.springboot.data.mongodb;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @Author linfl
 * @Version 1.0
 * @Date 2017年3月9日
 */
@Document
public class VehicleOnlineData {

	@Id
	private String id;
	private String vehicleId;
	private String vehicleNo;
	private Date gatherTime;
	private Integer gpsSpeed;
	private Double realLongitude;
	private Double realLatitude;
	private Double offsetLongitude;
	private Double offsetLatitude;
	private Integer direct;
	private Integer altitude;
	private Integer accStatus;
	private Double gForce;
	private Double thermometerProbe1;
	private Double thermometerProbe2;
	private Double thermometerProbe3;
	private Double thermometerProbe4;
	private Double humidometerProbe1;
	private Double humidometerProbe2;
	private Double humidometerProbe3;
	private Double humidometerProbe4;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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
	public Integer getGpsSpeed() {
		return gpsSpeed;
	}
	public void setGpsSpeed(Integer gpsSpeed) {
		this.gpsSpeed = gpsSpeed;
	}
	public Double getRealLongitude() {
		return realLongitude;
	}
	public void setRealLongitude(Double realLongitude) {
		this.realLongitude = realLongitude;
	}
	public Double getRealLatitude() {
		return realLatitude;
	}
	public void setRealLatitude(Double realLatitude) {
		this.realLatitude = realLatitude;
	}
	public Double getOffsetLongitude() {
		return offsetLongitude;
	}
	public void setOffsetLongitude(Double offsetLongitude) {
		this.offsetLongitude = offsetLongitude;
	}
	public Double getOffsetLatitude() {
		return offsetLatitude;
	}
	public void setOffsetLatitude(Double offsetLatitude) {
		this.offsetLatitude = offsetLatitude;
	}
	public Integer getDirect() {
		return direct;
	}
	public void setDirect(Integer direct) {
		this.direct = direct;
	}
	public Integer getAltitude() {
		return altitude;
	}
	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}
	public Integer getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(Integer accStatus) {
		this.accStatus = accStatus;
	}
	public Double getgForce() {
		return gForce;
	}
	public void setgForce(Double gForce) {
		this.gForce = gForce;
	}
	public Double getThermometerProbe1() {
		return thermometerProbe1;
	}
	public void setThermometerProbe1(Double thermometerProbe1) {
		this.thermometerProbe1 = thermometerProbe1;
	}
	public Double getThermometerProbe2() {
		return thermometerProbe2;
	}
	public void setThermometerProbe2(Double thermometerProbe2) {
		this.thermometerProbe2 = thermometerProbe2;
	}
	public Double getThermometerProbe3() {
		return thermometerProbe3;
	}
	public void setThermometerProbe3(Double thermometerProbe3) {
		this.thermometerProbe3 = thermometerProbe3;
	}
	public Double getThermometerProbe4() {
		return thermometerProbe4;
	}
	public void setThermometerProbe4(Double thermometerProbe4) {
		this.thermometerProbe4 = thermometerProbe4;
	}
	public Double getHumidometerProbe1() {
		return humidometerProbe1;
	}
	public void setHumidometerProbe1(Double humidometerProbe1) {
		this.humidometerProbe1 = humidometerProbe1;
	}
	public Double getHumidometerProbe2() {
		return humidometerProbe2;
	}
	public void setHumidometerProbe2(Double humidometerProbe2) {
		this.humidometerProbe2 = humidometerProbe2;
	}
	public Double getHumidometerProbe3() {
		return humidometerProbe3;
	}
	public void setHumidometerProbe3(Double humidometerProbe3) {
		this.humidometerProbe3 = humidometerProbe3;
	}
	public Double getHumidometerProbe4() {
		return humidometerProbe4;
	}
	public void setHumidometerProbe4(Double humidometerProbe4) {
		this.humidometerProbe4 = humidometerProbe4;
	}


	
}
