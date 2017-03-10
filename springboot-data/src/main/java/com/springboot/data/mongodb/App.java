package com.springboot.data.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.data.mongodb.service.VehicleOnlineDataService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	@Autowired
	private VehicleOnlineDataService service;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(service);
		System.out.println(service.getTotalCount("123"));
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
