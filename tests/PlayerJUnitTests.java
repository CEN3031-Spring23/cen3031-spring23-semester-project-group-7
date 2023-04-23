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
		assertEquals("2", player.getHand());
		player.addCard(card2);
		assertEquals("12", player.getHand());
	}

	@Test
	void clearPlayerHandTest() {
		Player player = new Player();
		Card card1 = new Card(1, 2, 2);
		Card card2 = new Card(3, 10, 12);


		player.addCard(card1);
		player.addCard(card2);
		
		assertEquals("12", player.getHand());
		player.clearHand();
		assertEquals("0", player.getHand());

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
	
	@Test
	void handWithAceTests() {
		Player player = new Player();
		Card card1 = new Card(1, 9, 9);
		Card card2 = new Card(2, 11, 1);
		Card card3 = new Card (3,2,2);
		
		player.addCard(card1);
		player.addCard(card2);
		
		assertEquals("20/10", player.getHand());
		
	}
	
	@Test
	void handWithTwoAcesTests() {
		Player player = new Player();
		Card card1 = new Card(1, 9, 9);
		Card card2 = new Card(2, 11, 1);
		Card card3 = new Card (3,11,1);
		
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		player.aceBuster();
		
		assertEquals("21/11", player.getHand());
		
	}
	
	@Test
	void handWithThreeAcesTests() {
		Player player = new Player();
		Card card1 = new Card(1, 5, 5);
		Card card2 = new Card(2, 11, 1);
		Card card3 = new Card (3,11,1);
		Card card4 = new Card(1,11,1);
		
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		player.addCard(card4);
		player.aceBuster();
		
		assertEquals("18/8", player.getHand());
		
	}
	
	@Test
	void handWithFourAcesTests() {
		Player player = new Player();
		Card card1 = new Card(1, 3, 3);
		Card card2 = new Card(2, 11, 1);
		Card card3 = new Card (3,11,1);
		Card card4 = new Card(1,11,1);
		Card card5 = new Card(4,11,1);
		
		player.addCard(card1);
		player.addCard(card2);
		player.addCard(card3);
		player.addCard(card4);
		player.addCard(card5);
		player.aceBuster();
		
		assertEquals("17/7", player.getHand());
		
	}

}
