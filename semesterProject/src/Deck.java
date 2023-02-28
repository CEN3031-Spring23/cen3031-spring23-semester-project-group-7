import java.util.*;

public class Deck {
    private static final int COUNT = 52;
    Card cards[];

    public Deck() {
        Card cards = new Card[COUNT];
        int counter = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 14; j++) {
                if(j > 12) {
                    cards[counter] = Card(i, j, 11);
                } else if(j > 7) {
                    cards[counter] = Card(i, j, 10);
                } else {
                    cards[counter] = Card(i, j, j+2);
                }
            }
        }
    }

    public void shuffle() {
         Collections.shuffle(cards);
    }

    public Card getCard() {
        return cards[0];
    }
}
