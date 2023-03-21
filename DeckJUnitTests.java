import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckJUnitTests {

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
