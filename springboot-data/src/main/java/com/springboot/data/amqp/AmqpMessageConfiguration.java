/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.amqp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.data.amqp.message.LogisticNodeMessage;
import com.springboot.data.amqp.message.VehicleOnlineData;

/**
 * 配置AMQP发送-接收数据转换器
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月23日
 */
@Configuration
public class AmqpMessageConfiguration {
	public static final long MESSAGE_EXPIRES_IN = 30*1000;
	public static final String queueNameEntity = "spring-boot-entity";
	public static final String queueName = "spring-boot";
	public static final String exchangeName = "spring-boot-exchange";
	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter(){
		Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
		jsonConverter.setClassMapper(classMapper());
		return jsonConverter;
	}

	private ClassMapper classMapper() {
		Map<String, Class<?>> idClassMapping = new HashMap<>();
		idClassMapping.put("logisticNode", LogisticNodeMessage.class);
		idClassMapping.put("vehicleOnlineData", VehicleOnlineData.class);
		idClassMapping.put("string", String.class);
		DefaultClassMapper classMapper = new DefaultClassMapper();
		classMapper.setIdClassMapping(idClassMapping);
		return classMapper;
	}
//	@Bean
//    Queue stringQueue() {
//        return QueueBuilder.durable(queueName).withArgument("x-message-ttl", MESSAGE_EXPIRES_IN).build();
//    }
//    @Bean
//    Queue entityQueue() {
//    	return QueueBuilder.durable(queueNameEntity).withArgument("x-message-ttl", MESSAGE_EXPIRES_IN).build();
//    }
//    @Bean
//    Exchange directExchange(){
//    	//Direct, Topic, Fanout, and Headers
//    	return ExchangeBuilder.directExchange("directExchange").durable(true).withArgument("x-message-ttl", MESSAGE_EXPIRES_IN).build();
//    }
//    @Bean
//    Exchange topicExchange(){
//    	//Direct, Topic, Fanout, and Headers
//    	return ExchangeBuilder.topicExchange("topicExchange").durable(true).withArgument("x-message-ttl", MESSAGE_EXPIRES_IN).build();
//    }
//    @Bean
//    Binding binding(){
//    	return BindingBuilder.bind(queue1()).to((TopicExchange)topicExchange()).with("company_*");
//    }
//    
    
}
