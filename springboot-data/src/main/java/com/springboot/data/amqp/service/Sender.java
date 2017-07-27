/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.amqp.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.data.amqp.AmqpMessageConfiguration;
import com.springboot.data.amqp.message.LogisticNodeMessage;
import com.springboot.data.amqp.message.VehicleOnlineData;

@Component
public class Sender {
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;

	AtomicLong stringCounter = new AtomicLong();
	AtomicLong numCounter = new AtomicLong();
	AtomicLong entityCounter = new AtomicLong();
	/**
	 * 模拟字符串数据发送
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * void
	 * @Date 2017年7月23日 下午5:47:38
	 */
	@Scheduled(fixedDelay = 5000L)
	public void send() {
		String message = RandomStringUtils.randomAlphabetic(8);
		logger.debug("{},send String msg:{}",stringCounter.incrementAndGet(),message);
		this.rabbitTemplate.convertAndSend(AmqpMessageConfiguration.queueName,message);
	}
	@Scheduled(fixedDelay = 10000L)
	public void sendNum() {
		String message = RandomStringUtils.randomNumeric(1);
		logger.debug("{},send num msg:{}",numCounter.incrementAndGet(),message);
		RabbitAdmin admin = new RabbitAdmin(this.rabbitTemplate.getConnectionFactory());  
        admin.declareQueue(QueueBuilder.durable(message).withArgument("x-message-ttl", 30*1000).build());
//        admin.declareExchange(new TopicExchange("topicExchange",true,false));  
//        admin.declareBinding(new Binding(message, DestinationType.QUEUE, "topicExchange", "compayn_*", null));
        this.rabbitTemplate.convertAndSend("stringExchange","company_string_"+message,RandomStringUtils.randomAlphabetic(1024));
	}
	/**
	 * 模拟对象数据发送
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * void
	 * @Date 2017年7月23日 下午5:47:48
	 */
	@Scheduled(fixedDelay = 300L)
	public void sendEntity() {
		LogisticNodeMessage message = new LogisticNodeMessage();
		message.setNodeId(RandomStringUtils.randomAlphabetic(1024));
		message.setContent("在客户阿凡达医药有限公司现场提货"+message.getNodeId());
		message.setNodeDate(new Date());
		message.setNodeName("提货");
		message.setTypeName("分段零担运输");
		logger.debug("{},send msg:{} ",entityCounter.incrementAndGet(),ReflectionToStringBuilder.toString(message));
		//this.rabbitTemplate.convertAndSend(AmqpMessageConfiguration.queueNameEntity,message);
		RabbitAdmin admin = new RabbitAdmin(this.rabbitTemplate.getConnectionFactory());  
        admin.declareQueue(QueueBuilder.durable("nodeLogistic_1").withArgument("x-message-ttl", 30*1000).build());
        this.rabbitTemplate.convertAndSend("nodeLogisticExchange","company_logisticNode_1",message);
	}
	/**
	 * 模拟对象数据发送
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * void
	 * @Date 2017年7月23日 下午5:47:48
	 */
	@Scheduled(fixedDelay = 300L)
	public void sendVehicleOnlineDataEntity() {
		VehicleOnlineData message = new VehicleOnlineData();
		message.setId(RandomStringUtils.randomAlphabetic(1024));
		message.setGatherTime(new Date());
		message.setVehicleNo("京HM831"+RandomStringUtils.randomNumeric(1));
		logger.debug("{},send msg:{} ",entityCounter.incrementAndGet(),ReflectionToStringBuilder.toString(message));
		//this.rabbitTemplate.convertAndSend(AmqpMessageConfiguration.queueNameEntity,message);
		RabbitAdmin admin = new RabbitAdmin(this.rabbitTemplate.getConnectionFactory());  
		admin.declareQueue(QueueBuilder.durable("nodeLogistic_1").withArgument("x-message-ttl", 30*1000).build());
		this.rabbitTemplate.convertAndSend("nodeLogisticExchange","company_logisticNode_1",message);
	}
	
}
