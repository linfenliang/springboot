/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月24日
 */
@EnableCaching
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class CacheApp extends WebMvcConfigurerAdapter {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CacheApp.class, args);
	}

}
