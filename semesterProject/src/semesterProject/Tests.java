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
		int value1, value2, value3, value4;
		int suit1, suit2, suit3, suit4;

		value1 = d1.cards[20].getValue();
		suit1 = d1.cards[20].getSuit();
		value2 = d1.cards[40].getValue();
		suit2 = d1.cards[40].getSuit();

		d1.shuffle();

		value3 = d1.cards[20].getValue();
		suit3 = d1.cards[20].getSuit();
		value4 = d1.cards[40].getValue();
		suit4 = d1.cards[40].getSuit();

		if((value1 == value3) && (suit1 == suit3) && (value2 == value4) && (value2 == value4)) {
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
