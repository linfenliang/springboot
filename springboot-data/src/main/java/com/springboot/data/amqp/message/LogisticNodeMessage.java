/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.amqp.message;

import java.util.Date;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月23日
 */
public class LogisticNodeMessage {

	private String nodeId;
	private String nodeName;
	private Integer nodeType;
	private String typeName;
	private String content;
	private Date createDate;
	private Date nodeDate;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public Integer getNodeType() {
		return nodeType;
	}
	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getNodeDate() {
		return nodeDate;
	}
	public void setNodeDate(Date nodeDate) {
		this.nodeDate = nodeDate;
	}
	
}
