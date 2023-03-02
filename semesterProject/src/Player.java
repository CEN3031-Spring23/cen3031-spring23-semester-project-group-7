
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
	
	public void recalculate() {
		value = 0;
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
	
	public void addCard(Card card) {
		hand[numCards] = card;
		numCards++;
		value += hand[i].getValue();
	}
	
	public void aceBuster() {
		for (int i = 0; i < MAX_VALUE; i++) {
			if (hand[i].getRank() == 1) {
				if (value > 21) {
					hand[i].setValue(1);	
					recalculate();
				}
			}
		}
	}

}
