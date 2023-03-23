import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DealerJUnitTests {

	@Test
	void createDealerTest() {
		Dealer dealer = new Dealer();

		assertEquals(0, dealer.getValue());
		assertEquals("Dealer Hand: ", dealer.getHand());
	}
	
	@Test
	void addCardDealerTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);

		dealer.addCard(card1);
		dealer.addCard(card2);

		assertEquals(12, dealer.getValue());
	}
	
	@Test
	void getDealerHandTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);

		dealer.addCard(card1);
		assertEquals("Dealer Hand: 2 of Spades", dealer.getHand());
		dealer.addCard(card2);
		assertEquals("Dealer Hand: 2 of Spades, Queen of Hearts", dealer.getHand());
	}

	@Test
	void clearDealerHandTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);


		dealer.addCard(card1);
		dealer.addCard(card2);
		dealer.clearHand();

		assertEquals("Dealer Hand: ", dealer.getHand());

	}
	
	@Test
	void aceBusterDealerTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 11, 1);
		Card card2 = new Card(2, 11, 1);
		
		dealer.addCard(card1);
		dealer.addCard(card2);
		dealer.aceBuster();
		
		assertEquals(12, dealer.getValue());
	}

}