package com.springboot.data.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;

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
		VehicleOnlineData v = repository.save(new VehicleOnlineData());
		System.out.println(v.getId());
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
