package com.springboot.data.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class AmqpApp extends WebMvcConfigurerAdapter{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AmqpApp.class, args);
	}

}
