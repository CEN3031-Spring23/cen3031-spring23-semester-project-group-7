public class Game {
	private int bet;
	private int payout;
	private int tokens;
	private Dealer dealer;
	private Player player;
	private char keepPlaying;

	public Game() {
		bet = 0;
		payout = 0;
		tokens = 0;
		dealer = new Dealer();
		player = new Player();
	}

	public boolean checkBlackjack() {
		if(player.getValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPlayerBusted() {
		if (player.getValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasDealerBusted() {
		if (dealer.getValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	public int checkWinner() {
		if (!hasPlayerBusted()) {
			return 1;
		} else if(!hasDealerBusted()) {
			return -1;
		} else if (player.getValue() > dealer.getValue()) {
			return 1;
		} else if (dealer.getValue() > player.getValue()) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean playAgain(char keepPlaying) {
		if (keepPlaying == 'n'|| keepPlaying == 'N') {
			return false;
		} else {
		 return true;
		 }
	}
}
