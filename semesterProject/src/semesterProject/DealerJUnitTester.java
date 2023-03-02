package semesterProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DealerJUnitTester {

	@Test
	void createDealerTest() {
		Dealer dealer = new Dealer();
		
		assertEquals(0, dealer.calculateHand());
		assertEquals("", dealer.getHand());
	}
	
	@Test
	void aceValueTest() {
		Dealer dealer = new Dealer();
		
		assertEquals(11, dealer.getAceValue());
		
		dealer.setAce(1);
		assertEquals(1, dealer.getAceValue());
	}
	
	@Test
	void dealerHandTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);
		
		dealer.addCard(card1);
		assertEquals("Card 1: 1, 2, 2\n", dealer.getHand());
		dealer.addCard(card2);
		assertEquals("Card 1: 1, 2, 2\nCard 2: 3, 10, 12\n", dealer.getHand());
	}
	
	@Test
	void calculateDealerHandTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);
		
		dealer.addCard(card1);
		dealer.addCard(card2);
		
		assertEquals(12, dealer.calculateHand());
	}
	
	@Test
	void clearDealerHandTest() {
		Dealer dealer = new Dealer();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);
		
		
		dealer.addCard(card1);
		dealer.addCard(card2);
		dealer.clearHand();
		
		assertEquals("", dealer.getHand());
		
	}

}