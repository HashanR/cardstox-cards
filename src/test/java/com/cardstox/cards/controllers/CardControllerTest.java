package com.cardstox.cards.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cardstox.cards.entities.Card;
import com.cardstox.cards.services.CardService;

@RunWith(SpringRunner.class)
@WebMvcTest(CardsController.class)
public class CardControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CardService cardService;

	@Test
	public void testShouldReturnJSONArray() throws Exception {
		Card card = new Card();
		card.setName("name");
		card.setPrice(new BigDecimal(10));

		List<Card> cards = Arrays.asList(card);

		when(cardService.findAllCards()).thenReturn(cards);

		mvc.perform(get("/api/v1/cards").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)));
	}
}
