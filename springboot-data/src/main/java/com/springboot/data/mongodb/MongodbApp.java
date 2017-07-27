package com.springboot.data.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class MongodbApp extends WebMvcConfigurerAdapter{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MongodbApp.class, args);
	}

}
