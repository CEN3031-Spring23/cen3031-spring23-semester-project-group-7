
public class Player {
	private int value;
	private Card hand[];
	private int numCards;
	private int aceValue;
	private static final int MAX_VALUE = 11;
	
	public Player() {
		value = 0;
		hand = new Card[MAX_VALUE];
		aceValue = 1;
	}
	
	public int calculate() {
		for (int i = 0; i < numCards; i++) {
			value += hand[i].getValue();
		}
	}
	
	public void clear() {
		for (int i = 0; i < numCards; i++) {
			hand[i] = null;
		}
		numCards = 0;
		value = 0;
	}
	
	public int chooseAce() {
		if (aceValue + value + 10 <= 21) {
			aceValue = 11;	
		}
		return aceValue;
	}
	
	public void addCard(Card card) {
		hand[numCards] = card;
		numCards++;
	}

}
