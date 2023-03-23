import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameJUnitTests {
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
