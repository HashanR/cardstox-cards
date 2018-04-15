package com.cardstox.cards.repositories;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cardstox.cards.entities.Card;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryTests {

	@Autowired
	private CardRepository subject;

	@Autowired
	private TestEntityManager em;

	@Test
	public void testShouldReturnListOfAllCards() {
		Card card = new Card();
		card.setName("name");
		card.setPrice(new BigDecimal(10));

		em.persist(card);
		em.flush();

		List<Card> result = subject.findAll();
		assertEquals(1, result.size());
	}
}
