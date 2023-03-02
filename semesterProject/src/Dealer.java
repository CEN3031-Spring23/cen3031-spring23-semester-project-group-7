package semesterProject;


public class Dealer {
	private static final int MAX_NUMBER_OF_CARDS = 11;
	private int value;
	private Card[] hand;
	private int numOfCards;
	private int aceValue;

	public Dealer() {
		value = 0;
		hand = new Card[MAX_NUMBER_OF_CARDS];
		numOfCards = 0;
		aceValue = 11;
	}
	
	public void addCard(Card newCard) {
		hand[numOfCards] = newCard;
		numOfCards++;
	}
	
	public void setAce(int newAceValue) {
		aceValue = newAceValue;
	}
	
	public void clearHand() {
		for(int i = 0; i < numOfCards; i++) {
			hand[i] = null;
		}
		numOfCards = 0;
		aceValue = 11;
		value = 0;
	}
	
	public int calculateHand() {
		for(int i = 0; i < numOfCards; i++) {
			if(hand[i].getRank() == 1)
				value += aceValue;
			else
				value += hand[i].getValue();
		}
		return value;
	}
	
	public String getHand() {
		String outputHand = "";
		for(int i = 0; i < numOfCards; i++) {
			outputHand += "Card " + (i + 1) + ": " 
					   + hand[i].getSuit() + ", " 
					   + hand[i].getValue() + ", " 
					   + hand[i].getRank() + "\n";
		}
		return outputHand;
	}
	
	public int getAceValue() {
		return aceValue;
	}
}
