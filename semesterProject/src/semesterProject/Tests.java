package semesterProject;

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
			return;
		}
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
