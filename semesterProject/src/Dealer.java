package semesterProject;


public class Dealer {
	private static final int MAX_NUMBER_OF_CARDS = 11;
	private int value;
	private Card[] hand;
	private int numOfCards;

	public Dealer() {
		value = 0;
		hand = new Card[MAX_NUMBER_OF_CARDS];
		numOfCards = 0;
		aceValue = 11;
	}
	
	public void addCard(Card newCard) {
		hand[numOfCards] = newCard;
		numOfCards++;
		value += newCard.getValue();
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
	
	public int getValue(){
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
	
	public void recalculateHand(){
		value = 0;
		for(int i = 0; i < numOfCards; i++){
			value += hand[i].getValue();
		}
	}
	
	public void aceBuster(){
		for(int i = 0; i < numOfCards; i++){
			if(hand[i].getRank == 1){
				if(value > 21){
					hand[i].setValue(1);
					recalculateHand();
				}
			}
		}
		
	}
}
