public class Game {
	private int bet;
	private int tokens;
	private Dealer dealer;
	private Player player;
	private Deck deck;
	private boolean gameOver;
	private boolean playerTurn;

	public Game() {
		bet = 0;
		tokens = 100;
		dealer = new Dealer();
		player = new Player();
		deck = new Deck();
		gameOver = false;
		playerTurn = true;
	}

	public int checkBlackJack() {
		if((player.getValue() == 21) && (dealer.getValue() == 21)) {
			return 4;
		} else if(player.getValue() == 21) {
			return 1;
		} else if (dealer.getValue() == 21) {
			return 0;
		} else {
			return 0;
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

	public void checkWinner() {
		if(hasPlayerBusted() == true) {
			handleResult(3);
		} else if(hasDealerBusted()) {
			handleResult(2);
		} else if(dealer.getValue() > player.getValue()){
			handleResult(3);
		} else if(player.getValue() > dealer.getValue()) {
			handleResult(2);
		} else {
			handleResult(4);
		}
	}

	public void playAgain(char keepPlaying) {
		if (keepPlaying != 'n'|| keepPlaying != 'N') {
			player.clearHand();
			dealer.clearHand();
			playerTurn = true;
		}
	}
	
	public void deal() {
		deck.shuffle();
		for(int i = 0; i < 2; i++) {
			player.addCard(deck.getCard());
			dealer.addCard(deck.getCard());
		}
		handleResult(checkBlackJack());
	}
	
	public void getPayout(int type) {
		if(type == 1) {
			tokens += bet + (bet * (3/2));
		} else if(type == 2) {
			tokens += bet * 2;
		} else if(type == 3) {
			tokens -= bet;
		}
	}
	
	public void handleResult(int result) {
		if(result == 1) {
			getPayout(result);
			winner(); // blackjack
		} else if(result == 2) {
			getPayout(2);
			winner(); // straight up win
		} else if(result == 3) {
			getPayout(3);
			loser(); // dealer wins or you bust
		} else if(result == 4) {
			tie(); // tie
		}
	}
	
	public void hit() {
		player.addCard(deck.getCard());
		if(hasPlayerBusted() == true) {
			printHands();
			checkWinner();
		} else {
			printHands();
		}
	}
	
	public void stand() {
		playerTurn = false;
		dealerTurn();
	}
	
	public void dealerTurn() {
		while(dealer.getValue() <= 16 && dealer.getValue() < player.getValue()) {
			dealer.addCard(deck.getCard());
			printHands();
		}
		checkWinner();
	}
	
	public void winner() {
		playerTurn = false;
		gameOver = true;
		System.out.println("You won!");
	}
	
	public void loser() {
		playerTurn = false;
		gameOver = true;
		System.out.println("You lost!");
	}
	
	public void tie() {
		playerTurn = false;
		gameOver = true;
		System.out.println("Tie, chips back");
	}
	
	public void setBet(int newBet) {
		bet = newBet;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public int getTokens() {
		return tokens;
	}
	
	public boolean isPlayersTurn() {
		return playerTurn;
	}
	
	public void printHands() {
		System.out.println("Dealer Hand: " + dealer.getValue());
		System.out.println(dealer.getHand());
		
		System.out.println("Player Hand: " + player.getValue());
		System.out.println(player.getHand());
		System.out.println();
	}
}
