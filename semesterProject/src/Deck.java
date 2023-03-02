import java.util.*;

public class Deck {
    private static final int COUNT = 52;
    private int topCard = 0;
    private Card cards[];

    public Deck() {
        cards = new Card[COUNT];
        int counter = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < 14; j++) {
                if(j == 1) {
                    cards[counter] = new Card(i, 11, j);
                } else if(j < 11) {
                    cards[counter] = new Card(i, j, j);
                } else {
                    cards[counter] = new Card(i, j, 10);
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
         Collections.shuffle(cards);
         topCard = 0;
    }

    public Card getCard() {
        topCard++;
        return cards[topCard-1];
    }
}
