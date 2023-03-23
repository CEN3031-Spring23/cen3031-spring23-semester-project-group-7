
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
	
	public String getHand() {
		String outputHand = "Dealer Hand: ";
		for(int i = 0; i < numOfCards; i++) {
			if(i == numOfCards - 1) {
				if(hand[i].getSuit() == 0) {
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Clubs";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Clubs";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Clubs";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Clubs";
					} else {
						outputHand += hand[i].getRank() + " of Clubs";
					}
				} else if(hand[i].getSuit() == 1){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Spades";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Spades";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Spades";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Spades";
					} else {
						outputHand += hand[i].getRank() + " of Spades";
					}
				} else if(hand[i].getSuit() == 2){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Diamonds";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Diamonds";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Diamonds";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Diamonds";
					} else {
						outputHand += hand[i].getRank() + " of Diamonds";
					}
				} else if(hand[i].getSuit() == 3){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Hearts";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Hearts";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Hearts";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Hearts";
					} else {
						outputHand += hand[i].getRank() + " of Hearts";
					}
			    }
			} else {
				if(hand[i].getSuit() == 0) {
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Clubs, ";
					} else if(hand[i].getRank() == 11) {
					outputHand += "Jack of Clubs, ";
					} else if(hand[i].getRank() == 12) {
					outputHand +=  "Queen of Clubs, ";
					} else if(hand[i].getRank() == 13) {
					outputHand +=  "King of Clubs, ";
					} else {
					outputHand += hand[i].getRank() + " of Clubs, ";
					}
				} else if(hand[i].getSuit() == 1){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Spades, ";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Spades, ";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Spades, ";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Spades, ";
					} else {
						outputHand += hand[i].getRank() + " of Spades, ";
					}
				} else if(hand[i].getSuit() == 2){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Diamonds, ";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Diamonds, ";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Diamonds, ";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Diamonds, ";
					} else {
						outputHand += hand[i].getRank() + " of Diamonds, ";
					}
				} else if(hand[i].getSuit() == 3){
					if(hand[i].getRank() == 1) {
						outputHand += "Ace of Hearts, ";
					} else if(hand[i].getRank() == 11) {
						outputHand += "Jack of Hearts, ";
					} else if(hand[i].getRank() == 12) {
						outputHand +=  "Queen of Hearts, ";
					} else if(hand[i].getRank() == 13) {
						outputHand +=  "King of Hearts, ";
					} else {
						outputHand += hand[i].getRank() + " of Hearts, ";
					}
				}
			}
		}
		return outputHand;
	}
	
	public int getNumOfCards() {
		return numOfCards;
	}
	
	public Card getCard(int card) {
		return hand[card];
	}
}
