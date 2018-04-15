package com.cardstox.cards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardstox.cards.entities.Card;
import com.cardstox.cards.services.CardService;

@RestController
@RequestMapping(value = "api/v1/cards")
public class CardsController {

	@Autowired
	CardService cardService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Card> findAllCards() {
		return cardService.findAllCards();
	}
}
