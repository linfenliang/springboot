/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.amqp.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.springboot.data.amqp.AmqpMessageConfiguration;
import com.springboot.data.amqp.message.LogisticNodeMessage;
import com.springboot.data.amqp.message.VehicleOnlineData;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月11日
 */
@Component
public class Receiver{
	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
	/**
	 * 可用作Module->Module之间数据交互
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * @param message
	 * void
	 * @Date 2017年7月23日 下午9:53:15
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = AmqpMessageConfiguration.queueName, durable = "true", autoDelete = "false", arguments = @Argument(name = "x-message-ttl", value = "30000", type = "java.lang.Integer")), 
			exchange = @Exchange(value="",durable="true",type=ExchangeTypes.DIRECT, autoDelete="false"),
			key=AmqpMessageConfiguration.queueName
))
    public void handleMessage(@Payload String message) {
        logger.debug("Received <" + message + ">");
    }
	/**
	 * 普通字符串数据传输
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * @param message
	 * void
	 * @Date 2017年7月23日 下午9:53:44
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "1", durable = "true", autoDelete = "false", arguments = @Argument(name = "x-message-ttl", value = "30000", type = "java.lang.Integer")),
							exchange = @Exchange(value = "stringExchange", type = ExchangeTypes.TOPIC, durable = "true",autoDelete = "false"),
							key="company_string_1"
//			arguments = {
//			@Argument(name = "x-match", value = "all"),
//			@Argument(name = "foo", value = "bar"),
//			@Argument(name = "baz")
//			}
			)
			)
	public void handleNum1Message(@Payload String message) {
		logger.debug("Received <" + message + ">");
	}
	/**
	 * 企业间数据交互，指定消息队列与主题与路由信息
	 * 
	 * @Author linfenliang
	 * @Version 1.0
	 * @param message
	 * void
	 * @Date 2017年7月23日 下午9:53:59
	 */
	@RabbitListener(
//			bindings = @QueueBinding(
//			value = @Queue(value = "nodeLogistic_1", durable = "true", autoDelete = "false", arguments = @Argument(name = "x-message-ttl", value = "30000", type = "java.lang.Integer")),
//			exchange = @Exchange(value = "nodeLogisticExchange", type = ExchangeTypes.TOPIC, durable = "true",autoDelete = "false"),
//			key="company_logisticNode_1")
			queues = "nodeLogistic_1"
			)
	public void handleEntityMessage(LogisticNodeMessage message) {
		logger.debug("Received <" + ReflectionToStringBuilder.toString(message) + ">");
	}
	@RabbitListener(queues = "nodeLogistic_1")
	public void handleEntityMessage(VehicleOnlineData message) {
		logger.debug("Received <" + ReflectionToStringBuilder.toString(message) + ">");
	}
		
}
