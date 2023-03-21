import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardJUnitTests {

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