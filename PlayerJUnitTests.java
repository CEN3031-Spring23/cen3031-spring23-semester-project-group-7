import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerJUnitTests {

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
