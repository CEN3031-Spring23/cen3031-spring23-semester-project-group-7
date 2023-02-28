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
		value = d1.deck[51].getValue();
		assertEquals(14, value);
	}

	@Test
	void testGetCard() {



	}

	@Test 
	void testShuffle() {

	}
}


class CardTests {

}
