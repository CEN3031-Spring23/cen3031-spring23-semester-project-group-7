
public class Card {
    private int suit;
    private int value;
    private int rank;

    public Card() {
        suit = 0;
        value = 0;
        rank = 0;
    }

    public Card(int sVal, int vVal, int rVal) {
        suit = sVal;
        value = vVal;
        rank = rVal;
    }

    public int getSuit() {
      return suit;
    }

    public void setValue(int newValue) {
    	value = newValue;
    }
    
    public int getValue() {
      return value;
    }

    public int getRank() {
        return rank;
      }
    }