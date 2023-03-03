public class Game {
	private int bet;
	private int payout;
	private int tokens;
	private Dealer dealer;
	private Player player;

	public Game() {
		bet = 0;
		payout = 0;
		tokens = 0;
		dealer = new Dealer();
		player = new Player();
	}

	public boolean checkBlackjack() {
		if(player.calculateHand() == 21)
			return true;
		else
			return false;

	}

	public boolean hasPlayerBusted() {
		if (player.calcluateHand() > 21)
			return true;
		else
			return false;
	}

	public boolean hasDealerBusted() {
		if (dealer.calcluateHand() > 21)
			return true;
		else
			return false;
	}

	public int checkWinner() {
		if (!hasPlayerBusted()) {
			return 1;
		}
		else if(!hasDealerBusted()) {
			return -1;
		}

		else if (player.calculate() > dealer.calculate())
			return 1;

		else if (dealer.calculate() > player.calculate())
			return -1;

		else
			return 0;
	}

	public boolean playAgain(char continue) {
	 if (continue == 'n'|| continue == 'N')
		 return false;
	 else
		 return true;
	}

}
