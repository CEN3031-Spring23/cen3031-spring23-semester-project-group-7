import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class DeckTests {

	Deck d1;
	@BeforeAll
	void createDeck() {
		d1.Deck();
	}

	@Test
	void testDeckCreation() {
		int value;
		value = d1.cards[51].getValue();
		assertEquals(14, value);
	}

	@Test
	void testGetCard() {
		int value;
		int suit;
		value = d1.getCard().getValue();
		suit = d1.getCard().getValue();
		assertEquals(2, value);
		assertEquals(1, suit);
	}

	@Test
	void testShuffle() {
		int rank1, rank2, rank3, rank4;
		int suit1, suit2, suit3, suit4;

		rank1 = d1.cards[20].getRank();
		suit1 = d1.cards[20].getSuit();
		rank2 = d1.cards[40].getRank();
		suit2 = d1.cards[40].getSuit();

		d1.shuffle();

		rank3 = d1.cards[20].getRank();
		suit3 = d1.cards[20].getSuit();
		rank4 = d1.cards[40].getRank();
		suit4 = d1.cards[40].getSuit();

		if((rank1 == rank3) && (suit1 == suit3) && (rank2 == rank4) && (rank2 == rank4)) {
			fail();
		}
		return;
	}
}


class CardTests {

	Card cards = new Card(3, 10, 12); //Order is Suit, Value, Rank

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

}

class GameTests {
	Game g1;
	Player p1;

	void testGetBet() {
		g1.Game(false, 20, 0, 100);
		int bet = g1.getBet();
		assertEquals(20, bet);
	}

	void testDoubleDown() {
		g1.Game(false, 20, 0, 100);
		int doubledBet = g1.douleDown();
		assertEquals(40, bet);
	}

	void testCheckBet() {
		g1.Game(false, -10, 0, 100);
		assertEquals(false, g1.checkBet());
	}

	void testCheckBust() {
		Card[] testHand = {Card(1, 8, 10), Card(2, 8, 10), Card(3, 8, 10)};
		p1.hand = testHand;
		int value = p1.calculate();
		assertEquals(true, g1.getBust());
	}

	void testPlayAgain() {
		boolean goAgain = false;
		goAgain = g1.playAgain('y');
		assertEquals(true, goAgain);
	}


}

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

class PlayerJUnitTest {

	@Test
	void chooseAceTest() {
		Player player = new player();
		Card card1 = new Card(1, 2, 12);
		Card card2 = new Card(1, 8, 12);

		player.addCard(card1);
		player.addCard(card2);

		assertEquals(1, player.chooseAce());
	}

	@Test
	void calculateTest() {
		Player player = new Player();
		Card card1 = new Card(1, 2, 12);
		Card card2 = new Card(1, 8, 12);

		player.addCard(card1);
		player.addCArd(card2);

		assertEquals(10, player.calculate());
	}

	@Test
	void clearTest() {
		Player player = new Player();
		Card card = new Card()1, 2, 12;

		player.addCard(card);
		player.clear();

		assertEquals(0, value);
		assertEquals(0, numCards);
	}

}