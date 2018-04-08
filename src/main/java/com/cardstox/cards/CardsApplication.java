package com.cardstox.cards;

import java.math.BigDecimal;
import java.util.List;

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
	CardRepository cards;
	
	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
	
	@RequestMapping("/")
	public List<Card> hello() {
		Card card = new Card();
		card.setName("William");
		card.setPrice(BigDecimal.valueOf(10.00));
		cards.save(card);
		return cards.findAll();
		
	}
}
