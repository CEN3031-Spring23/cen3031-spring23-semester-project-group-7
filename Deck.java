import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private int topCard = 0;
    public ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < 14; j++) {
                if(j == 1) {
                    Card card = new Card(i, 11, j);
                	cards.add(card);
                } else if(j < 11) {
                    Card card = new Card(i, j - 1, j);
                    cards.add(card);
                } else {
                    Card card = new Card(i, 10, j);
                    cards.add(card);
                }
            }
        }
    }

    public void shuffle() {
         Collections.shuffle(cards);
         topCard = 0;
    }

    public Card getCard() {
        topCard++;
        return cards.get(topCard -1);
    }

    public void setTopCard(int newTopCard) {
        topCard = newTopCard;
    }
}
