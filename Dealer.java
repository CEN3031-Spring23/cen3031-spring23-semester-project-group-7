public class Dealer {
	private static final int MAX_NUMBER_OF_CARDS = 11;
	private int value;
	private Card[] hand;
	private int numOfCards;

	public Dealer() {
		value = 0;
		hand = new Card[MAX_NUMBER_OF_CARDS];
		numOfCards = 0;
	}

	public void addCard(Card newCard) {
		hand[numOfCards] = newCard;
		numOfCards++;
		value += newCard.getValue();
	}

	public void clearHand() {
		for(int i = 0; i < numOfCards; i++) {
			hand[i] = null;
		}
		numOfCards = 0;
		value = 0;
	}

	public int getValue(){
		return value;
	}

	public void recalculateHand(){
		value = 0;
		for(int i = 0; i < numOfCards; i++){
			value += hand[i].getValue();
		}
	}
	
	/**
	 * Recalculates the dealer's hand when they have at
	 * least one ace and have busted
	 */
	public void aceBuster(){
		for(int i = 0; i < numOfCards; i++){
			if(hand[i].getRank() == 1){
				if(value > 21){
					hand[i].setValue(1);
					recalculateHand();
				}
			}
		}
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
