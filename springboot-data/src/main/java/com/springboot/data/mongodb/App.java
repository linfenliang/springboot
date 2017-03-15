package com.springboot.data.mongodb;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.ReflectionUtils;

import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;
import com.springboot.data.mongodb.domain.VehicleOnlineData;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	@Autowired
	private VehicleOnlineDataRepository repository;
	
	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		VehicleOnlineData vod = new VehicleOnlineData();
		vod.setVehicleNo("京HM8310");
		vod.setVehicleId("123456");
		VehicleOnlineData v = repository.save(vod);
		System.out.println(v.getId());
		System.out.println(ReflectionToStringBuilder.toString(repository.findByVehicleId("123456").get(0)));
		System.out.println(repository.count());
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
