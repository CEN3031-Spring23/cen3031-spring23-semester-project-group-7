import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class DeckTests {

	Deck d1;

	@Test
	void testDeckCreation() {
		d1 = new Deck();
		int value;
		d1.setTopCard(51);
		value = d1.getCard().getRank();
		assertEquals(13, value);
	}

	@Test
	void testGetCard() {
		d1 = new Deck();
		int value;
		int suit;
		value = d1.getCard().getValue();
		suit = d1.getCard().getSuit();
		assertEquals(11, value);
		assertEquals(0, suit);
	}

	@Test
	void testShuffle() {
		d1 = new Deck();
		int rank1, rank2, rank3, rank4;
		int suit1, suit2, suit3, suit4;

		d1.setTopCard(20);
		rank1 = d1.getCard().getRank();
		d1.setTopCard(20);
		suit1 = d1.getCard().getSuit();

		d1.setTopCard(40);
		rank2 = d1.getCard().getRank();
		d1.setTopCard(40);
		suit2 = d1.getCard().getSuit();

		d1.shuffle();

		d1.setTopCard(20);
		rank3 = d1.getCard().getRank();
		d1.setTopCard(20);
		suit3 = d1.getCard().getSuit();
		d1.setTopCard(40);
		rank4 = d1.getCard().getRank();
		d1.setTopCard(40);
		suit4 = d1.getCard().getSuit();

		if((rank1 == rank3) && (suit1 == suit3) && (rank2 == rank4) && (rank2 == rank4)) {
			fail();
		}
	}
}

class CardTests {

	Card cards = new Card(3, 10, 12);

    @Test
    public void suitTest() {
        assertEquals(3, cards.getSuit());
    }

    @Test
    public void valueTest() {
        assertEquals(10, cards.getValue());
    }

    @Test
    public void rankTest() {
        assertEquals(12, cards.getRank());
    }

	@Test
	public void setValueTest() {
		cards.setValue(10);
		assertEquals(10, cards.getValue());
	}

}

/*
class GameTests {
	Game g1;
	Player p1;
	Dealer d1;

	@Test
	void hasPlayerBustedTest() {
		p1 = new Player();
		Card card1 = new Card(0,10,12);
		Card card2 = new Card(1,10,12);
		Card card3 = new Card(2,10,12);
		p1.addCard(card1);
		p1.addCard(card2);
		p1.addCard(card3);

		boolean playerBust = g1.hasPlayerBusted();

		assertEquals(true, playerBust);
	}
	
	@Test
	void hasDealerBustedTest() {
		d1 = new Dealer();
		Card card1 = new Card(0,10,12);
		Card card2 = new Card(1,10,12);
		Card card3 = new Card(2,10,12);
		d1.addCard(card1);
		d1.addCard(card2);
		d1.addCard(card3);

		boolean playerBust = g1.hasPlayerBusted();

		assertEquals(true, playerBust);
	}
}
*/

class DealerJUnitTester {

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

class PlayerJUnitTest {

	@Test
	void createPlayerTest() {
		Player player = new Player();

		assertEquals(0, player.getValue());
	}

	@Test
	void addCardPlayerTest() {
		Player player = new Player();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);

		player.addCard(card1);
		player.addCard(card2);

		assertEquals(12, player.getValue());
	}
	
	@Test
	void getPlayerHandTest() {
		Player player = new Player();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);

		player.addCard(card1);
		assertEquals("Player Hand: 2 of Spades", player.getHand());
		player.addCard(card2);
		assertEquals("Player Hand: 2 of Spades, Queen of Hearts", player.getHand());
	}

	@Test
	void clearPlayerHandTest() {
		Player player = new Player();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);


		player.addCard(card1);
		player.addCard(card2);
		player.clearHand();

		assertEquals("Player Hand: ", player.getHand());

	}
	
	@Test
	void aceBusterPlayerTest() {
		Player player = new Player();
		Card card1 = new Card(1, 11, 1);
		Card card2 = new Card(2, 11, 1);
		
		player.addCard(card1);
		player.addCard(card2);
		player.aceBuster();
		
		assertEquals(12, player.getValue());
	}

}
