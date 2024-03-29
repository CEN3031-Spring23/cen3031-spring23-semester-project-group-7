/**
The Player class handles the game for the user.
It will calculate the values neccessary for the
user's game to work and create their deck
*/

public class Player {
	private static final int MAX_VALUE = 11;
	private int value;
	private Card hand[];
	private int numOfCards;

	public Player() {
		value = 0;
		hand = new Card[MAX_VALUE];
		numOfCards = 0;
	}
	
	public void addCard(Card card) {
		hand[numOfCards] = card;
		numOfCards++;
		value += card.getValue();
	}
	
	public void clearHand() {
		for (int i = 0; i < numOfCards; i++) {
			hand[i] = null;
		}
		numOfCards = 0;
		value = 0;
	}
	
	public int getValue() {
		return value;
	}

	public void recalculateHand() {
		value = 0;
		for (int i = 0; i < numOfCards; i++) {
			value += hand[i].getValue();
		}
	}
	
	/**
	 * Recalculates the player's hand when they have at
	 * least one ace and have busted
	 */
	public void aceBuster() {
		for (int i = 0; i < numOfCards; i++) {
			if (hand[i].getRank() == 1) {
				if (value > 21) {
					hand[i].setValue(1);
					recalculateHand();
				}
			}
		}
	}
	
	public Card split() {
		Card temp = new Card();
		temp = hand[1];
		hand[1] = null;
		numOfCards = 1;
		recalculateHand();
		return temp;
  }

	public String getHand() {
		String handValue = "";
		int tempValue = getValue();
		
		handValue += tempValue;
		for(int i = 0; i < numOfCards; i++) {
			if(hand[i].getRank() == 1 && hand[i].getValue() != 1) {
				tempValue -= 10;
				handValue += "/" + tempValue;
			}
				
		}
		return handValue;
	}
	
	public int getNumOfCards() {
		return numOfCards;
	}
	
	public Card getCard(int card) {
		return hand[card];
	}
	
	public int getRankOfCard(int card) {
		return hand[card].getRank();
	}
	
	public int getSuitOfCard(int card) {
		return hand[card].getSuit();
	}

}
