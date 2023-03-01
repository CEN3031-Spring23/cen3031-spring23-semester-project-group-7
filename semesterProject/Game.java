public class Game {
	
	public boolean checkBlackjack() {
		if(player.calculate == 21) 
			return true;
		else
			return false;
		
	}
	
	public boolean checkBust() {
		if (player.calcluate() > 21)
			retrun true;
		else 
			return false;
	}
	
	public int checkWinner() {
		if (player.calculate() > 21)
			return -1;
		if (player.calculate() > dealer.calculate())
			return 1;
		else if (player.calculate() > dealer.calculate()) 
			return -1;
		else if(player.calculate() == dealer.calculate())
			return 0;
	}
 
	public boolean playAgain(char continue) {
	 if (continue == 'n'|| continue == 'N')
		 return false;
	 else 
		 return true;
 }
    
}
