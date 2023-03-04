import java.util.Scanner;

public class Display {

    public static void main(String[] args) {
        Game g1 = new Game();
        
        String playerMove = "";
        char keepPlaying = ' ';
        Scanner in = new Scanner(System.in);
        
        do {
            g1.deal();
            g1.printHands();
        
            while(g1.isPlayersTurn() == true) {
                System.out.println("hit or stand?");
                playerMove = in.next();
            
                if(playerMove.equals("hit")) {
                    g1.hit();
                } else if(playerMove.equals("stand")) {
                    g1.stand();
                }
            }
            
            System.out.println("Play again? (y/n)");
            keepPlaying = in.next().charAt(0);
            g1.playAgain(keepPlaying);
        } while(keepPlaying != 'n');
    }
}