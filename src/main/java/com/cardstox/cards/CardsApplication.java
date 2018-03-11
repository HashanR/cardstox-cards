package com.cardstox.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CardsApplication {

	@Autowired
	test test;
	
	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		testingDao dao = new testingDao();
		dao.setName("test");
		
		testingDao h = test.save(dao);
		return "Hello World";
	}
}
