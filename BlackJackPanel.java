/**
 * The BlackJackPanel is a subclass of the JPanel class.
 * The BlackJackPanel provides users with a GUI to play 
 * Blackjack as well as submit bets for their games.
 */

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class BlackJackPanel extends JPanel {
	private JPanel playerPanel;
	private JPanel playerPanel2;
	private JLabel playerValueLabel;
	private JLabel playerValueLabel2;
	private JPanel dealerPanel;
	private JLabel dealerValueLabel;
	private JPanel playerOptionsPanel;
	private JPanel bettingPanel;
	private JLabel betAmountLabel;
	private JRadioButton allInButton;
	private JRadioButton minimumButton;
	private JRadioButton customBetButton;
	private ButtonGroup bettingGroup;
	private JPanel chipPanel;
	private JPanel deckPanel;
	private JSpinner customBetSpinner;
	public JButton homeButton;
	private JButton exitButton;
	private JPanel navigationPanel;
	private JLabel deckImg;
	private JButton playAgain;
	private JButton hitButton;
	private JButton standButton;
	private JButton doubleDownButton;
	private JButton splitButton;
	private int x;
	private CardPrinter cp;
	private JLabel[] pCards;
	private JLabel[] pCards2;
	private JLabel[] dCards;
	
	
	
	/**
	 * This is all of the private variables for the game logic
	 */
	private int bet;
	private int tokens;
	private Dealer dealer;
	private Player player;
	private Player player2;
	private Deck deck;
	private boolean gameOver;
	private boolean playerTurn;
	private boolean isSplit;
	private boolean player2Turn;
	
	
	

	/**
	 * Create the panel.
	 */
	public BlackJackPanel() {
		
		/**
		 * All of this is stuff that needs to be constructed on creation of a "game"
		 */
		bet = 0;
		tokens = 100;
		dealer = new Dealer();
		player = new Player();
		player2 = new Player();
		deck = new Deck();
		gameOver = false;
		playerTurn = true;
		isSplit = false;
		player2Turn = false;
		cp = new CardPrinter();
		pCards = new JLabel[11];
		pCards2 = new JLabel[11];
		dCards = new JLabel[11];
		
		try {
			Scanner fileScanner = new Scanner(new File ("playerChips.txt"));
			tokens = fileScanner.nextInt();
			fileScanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Missing Player Chips file");
			e.printStackTrace();
		}
		
		/**
		 * This is all related to the GUI no logic
		 */
		setBackground(new Color(29, 74, 146));
		setLayout(null);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(651, 539, 739, 172);
		add(playerPanel);
		playerPanel.setLayout(null);
		playerPanel.setOpaque(false);
		x = 0;
		for(int i = 0; i < 11; i++) {
			pCards[i] = new JLabel();
			pCards[i].setBounds(x, 0, 115, 172);
			pCards[i].setOpaque(false);
			playerPanel.add(pCards[i]);
			x += 57;
		}
		for(int i = 10; i >= 0; i--) {
			playerPanel.setComponentZOrder(pCards[i], 10 - i);
		}
		
		playerValueLabel = new JLabel("Your Hand: " + player.getHand());
		playerValueLabel.setBounds(450, 11, 300, 29);
		playerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerPanel.add(playerValueLabel);
		
		// Second card area only used when hand is split
		playerPanel2 = new JPanel();
		playerPanel2.setBounds(651, 365, 739, 172);
		add(playerPanel2);
		playerPanel2.setLayout(null);
		playerPanel2.setOpaque(false);
		
		x = 0;
		for(int i = 0; i < 11; i++) {
			pCards2[i] = new JLabel();
			pCards2[i].setBounds(x, 0, 115, 172);
			pCards2[i].setOpaque(false);
			playerPanel2.add(pCards2[i]);
			x += 57;
		}
		for(int i = 10; i >= 0; i--) {
			playerPanel2.setComponentZOrder(pCards2[i], 10 - i);
		}
		
		playerValueLabel2 = new JLabel("Your Hand: " + player.getValue());
		playerValueLabel2.setBounds(537, 11, 192, 29);
		playerValueLabel2.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerPanel2.add(playerValueLabel2);
		playerPanel2.setVisible(false);
		
		dealerPanel = new JPanel();
		dealerPanel.setBounds(10, 99, 739, 172);
		add(dealerPanel);
		dealerPanel.setLayout(null);
		dealerPanel.setOpaque(false);
		x = 0;
		for(int i = 0; i < 11; i++) {
			dCards[i] = new JLabel();
			dCards[i].setBounds(x, 0, 115, 172);
			dCards[i].setOpaque(false);
			dealerPanel.add(dCards[i]);
			x += 57;
		}
		for(int i = 10; i >= 0; i--) {
			dealerPanel.setComponentZOrder(dCards[i], 10 - i);
		}
		
		dealerValueLabel = new JLabel("Dealer: " + dealer.getValue());
		dealerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		dealerValueLabel.setBounds(537, 11, 197, 42);
		dealerPanel.add(dealerValueLabel);
		
		playerOptionsPanel = new JPanel();
		playerOptionsPanel.setBounds(411, 539, 232, 172);
		add(playerOptionsPanel);
		playerOptionsPanel.setLayout(null);
		playerOptionsPanel.setOpaque(false);
		
		hitButton = new JButton("Hit");
		hitButton.setBounds(10, 11, 95, 72);
		playerOptionsPanel.add(hitButton);
		hitButton.setEnabled(false);
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit();
				printHands();
				if(hasPlayerBusted() && player2Turn) {
					player2Turn = false;
					printHands();
					playerOptionsPanel.setLocation(411, 539);
				} else if(hasPlayerBusted()) {
					playerTurn = false;
					printHands();
					checkWinner();
				}
			}
		});
		
		standButton = new JButton("Stand");
		standButton.setBounds(127, 11, 95, 72);
		playerOptionsPanel.add(standButton);
		standButton.setEnabled(false);
		standButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stand();
			}
		});
		
		doubleDownButton = new JButton("<html><center>" + "Double" + "<br>" + "Down" + "</center></html>");
		doubleDownButton.setBounds(10, 94, 95, 72);
		playerOptionsPanel.add(doubleDownButton);
		doubleDownButton.setEnabled(false);
		doubleDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doubleDownButton.setEnabled(false);
				doubleDown();    
			}
		});

		splitButton = new JButton("Split");
		splitButton.setBounds(127, 94, 95, 72);
		playerOptionsPanel.add(splitButton);
		splitButton.setEnabled(false);
		splitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerOptionsPanel.setLocation(411,365);
				deckPanel.setLocation(506, 180);
				playerPanel2.setVisible(true);
				split();
			}
		});
		
		bettingPanel = new JPanel();
		bettingPanel.setBounds(1059, 99, 400, 272);
		add(bettingPanel);
		bettingPanel.setLayout(null);
		bettingPanel.setOpaque(false);
		
		betAmountLabel = new JLabel("Chips: " + tokens);
		betAmountLabel.setBounds(10, 11, 250, 37);
		betAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		bettingPanel.add(betAmountLabel);
		
		allInButton = new JRadioButton("All In");
		allInButton.setBounds(10, 67, 110, 43);
		bettingPanel.add(allInButton);
		allInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customBetSpinner.setValue(tokens);
			}
		});
		
		minimumButton = new JRadioButton("Minimum (1)");
		minimumButton.setBounds(10, 113, 110, 43);
		bettingPanel.add(minimumButton);
		minimumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customBetSpinner.setValue(1);
			}
		});
		
		customBetButton = new JRadioButton("Custom");
		customBetButton.setBounds(10, 159, 110, 43);
		bettingPanel.add(customBetButton);
		
		bettingGroup = new ButtonGroup();
		bettingGroup.add(allInButton);
		bettingGroup.add(minimumButton);
		bettingGroup.add(customBetButton);
		
		JButton submitBetButton = new JButton("Submit Bet");
		submitBetButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitBetButton.setBounds(97, 227, 116, 34);
		submitBetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitBetButton.setEnabled(false);
				int bet = (int) customBetSpinner.getValue();
				setBet(bet);
				deal();
				hitButton.setEnabled(true);
				standButton.setEnabled(true);
				doubleDownButton.setEnabled(true);
				handleResult(checkBlackJack());
			}
		});
		bettingPanel.add(submitBetButton);
		
		customBetSpinner = new JSpinner();
		customBetSpinner.setModel(new SpinnerNumberModel(5, 5, 1000, 1));
		customBetSpinner.setBounds(130, 159, 80, 43);
		bettingPanel.add(customBetSpinner);
		
		chipPanel = new JPanel();
		chipPanel.setBounds(33, 391, 296, 302);
		add(chipPanel);
		chipPanel.setOpaque(false);
		
		deckPanel = new JPanel();
		deckPanel.setBounds(506, 282, 310, 239);
		deckImg = new JLabel();
		deckImg.setIcon(cp.getBack());
		deckPanel.add(deckImg);
		deckPanel.setOpaque(false);
		add(deckPanel);
		
		navigationPanel = new JPanel();
		navigationPanel.setBounds(546, 11, 320, 56);
		add(navigationPanel);
		navigationPanel.setLayout(null);
		navigationPanel.setOpaque(false);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(5, 11, 100, 40);
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		navigationPanel.add(homeButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(108, 11, 100, 40);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		navigationPanel.add(exitButton);
		
		playAgain = new JButton("Play Again");
		playAgain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playAgain.setBounds(211, 11, 100, 40);
		navigationPanel.add(playAgain);
		playAgain.setEnabled(false);
		playAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAgain.setEnabled(false);
				playAgain();
				hitButton.setEnabled(false);
				standButton.setEnabled(false);
				submitBetButton.setEnabled(true);
			}
		});
		
		
	}
	
	public void printHands() {
		cp.update();
		displayPlayerHand();
		displayDealerHand();
		printDeck();
		getPlayerTokens();
	}
	
	public void printDeck() {
		cp.update();
		deckImg.setIcon(cp.getBack());
	}
	
	public void displayPlayerHand() {
		for(int i = 0; i < player.getNumOfCards(); i++) {
			pCards[i].setIcon(cp.getFace(player.getSuitOfCard(i), player.getRankOfCard(i) - 1));
		}
		playerValueLabel.setText("Your Hand " + player.getHand());
		if(isSplit) {
			for(int i = 0; i < player2.getNumOfCards(); i++) {
				pCards2[i].setIcon(cp.getFace(player2.getSuitOfCard(i), player2.getRankOfCard(i) - 1));
			}
			playerValueLabel2.setText("Your Hand " + player2.getHand());
		}
	}
	
	public void displayDealerHand() {
		if(playerTurn == true) {
			dCards[0].setIcon(cp.getBack());
			for(int i = 1; i < dealer.getNumOfCards(); i++) {
				dCards[i].setIcon(cp.getFace(dealer.getSuitOfCard(i), dealer.getRankOfCard(i) - 1));
			}
			dealerValueLabel.setText("Dealer: " + (dealer.getValue() - dealer.getCard(0).getValue()));
		}else {
			for(int i = 0; i < dealer.getNumOfCards(); i++) {
				dCards[i].setIcon(cp.getFace(dealer.getSuitOfCard(i), dealer.getRankOfCard(i) - 1));
			}
			dealerValueLabel.setText("Dealer: " + dealer.getValue());
		}
	}
	
	/**
	 * Under here will be the methods of the game logic
	 */
	public int checkBlackJack() {
		if((player.getValue() == 21) && (dealer.getValue() == 21)) {
			return 4;
		} else if(player.getValue() == 21) {
			return 1;
		} else if (dealer.getValue() == 21) {
			return 6;
		} else {
			return 0;
		}
	}

	// Checks for if the player has busted
	public boolean hasPlayerBusted() {
		if(player2Turn) {
			player2.aceBuster();
			if (player2.getValue() > 21) {
				return true;
			} else {
				return false;
			}
		} else {
			player.aceBuster();
			if (player.getValue() > 21) {
				return true;
			} else {
				return false;
			}
		}
	}

	// Checks for if the dealer has busted
	public boolean hasDealerBusted() {
		dealer.aceBuster();
		if (dealer.getValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	// Checks the winner and calls handle result depending on the outcome
	// Uses the hasPlayerBusted and hasDealerBusted to determine a winner as well as comparing the hand values
	public void checkWinner() {
		if(isSplit) {
			if(player2.getValue() > 21) {
				handleResult(3);
			} else if(hasDealerBusted()) {
				handleResult(2);
			}else if(dealer.getValue() > player2.getValue()) {
				handleResult(3);
			} else if(player2.getValue() > dealer.getValue()) {
				handleResult(2);
			} else {
				handleResult(4);
			}
		}
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

	// Function responsible for reseting the player and dealer hands as well as setting the turn to player
	public void playAgain() {
		player.clearHand();
		dealer.clearHand();
		if(isSplit) {
			player2.clearHand();
			playerPanel2.setVisible(false);
			deckPanel.setLocation(506, 282);
		}
		playerTurn = true;
		clearHands();
		isSplit = false;
		getPlayerTokens();
	}
	
	// The initial deal of the cards to dealer and player
	// Calls the handleResult function with the value of checkBlackJack
	public void deal() {
		deck.shuffle();
		for(int i = 0; i < 2; i++) {
			player.addCard(deck.getCard());
			dealer.addCard(deck.getCard());
		}
		printHands();
		if(player.getCard(0).getValue() == player.getCard(1).getValue()) {
			splitButton.setEnabled(true);
		}
		handleResult(checkBlackJack());
	}
	
	// Determines what the player receives for winning or loses
	// BlackJack pays out at a higher rate than a normal win
	public void getPayout(int type) {
		if(type == 1) {
			tokens += bet + (bet * (3/2));
		} else if(type == 2) {
			tokens += bet * 2;
		} else if(type == 3) {
			tokens += 0;
		} else {
			tokens += bet;
		}
		
		updatePlayerChips();
	}
	
	// This method is a middle method that is mainly responsible for displaying the correct
	// message depending on the outcome of the game. It also calls the payout method
	public void handleResult(int result) {
		if(result == 1) {
			getPayout(result);
			winner(); // blackjack
		} else if(result == 2) {
			getPayout(result);
			winner(); // straight up win
		} else if(result == 3) {
			getPayout(result);
			loser(); // dealer wins or you bust
		} else if(result == 4) {
			getPayout(result);
			push(); // push
		} else if(result == 6) {
			getPayout(3);
			loser();
		}
	}
	
	// Adds a card to players hand
	// Checks for the bust and if true goes through the end of game sequence
	// Else just prints the new hand
	public void hit() {
		if(player2Turn) {
			player2.addCard(deck.getCard());
		} else {
			player.addCard(deck.getCard());
		}
	}
	
	// Ends the players turn and calls the dealerTurn function to execute the dealers turn
	public void stand() {
		if(player2Turn) {
			player2Turn = false;
			playerOptionsPanel.setLocation(411, 539);
		} else {
			playerTurn = false;
			hitButton.setEnabled(false);
			standButton.setEnabled(false);
			dealerTurn();
		}
	}
	
	public void doubleDown() {
		tokens -= bet;
		updatePlayerChips();
		getPlayerTokens();
		bet = getBet() * 2;
		player.addCard(deck.getCard());
		printHands();
		playerTurn = false;
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
		if(hasPlayerBusted()) {
			printHands();
			checkWinner();
		} else {
			dealerTurn();
		}
	}
	
	public void split() {
		tokens -= bet;
		isSplit = true;
		player2Turn = true;
		player2.addCard(player.split());
		pCards[1].setIcon(null);
		printHands();
	}
	
	// The dealer hits as long as the value of the hand is less than 16 and less than the player
	// After each hit it reprints the hands
	// Calls checkWinner after its turn is over
	public void dealerTurn() {
		printHands();
		if(isSplit) {
			if(player.getValue() > 21 && player2.getValue() < 22) {
				while (dealer.getValue() <= 16 && dealer.getValue() < player2.getValue()) {
					dealer.addCard(deck.getCard());
					printHands();
				}
			} else if(player2.getValue() > 21 && player.getValue() < 22) {
				while (dealer.getValue() <= 16 && dealer.getValue() < player.getValue()) {
					dealer.addCard(deck.getCard());
					printHands();
				}
			} else if(player.getValue() > player2.getValue()) {
				while (dealer.getValue() <= 16 && dealer.getValue() < player.getValue()) {
					dealer.addCard(deck.getCard());
					printHands();
				}
			} else if(player2.getValue() > player.getValue()) {
				while (dealer.getValue() <= 16 && dealer.getValue() < player2.getValue()) {
					dealer.addCard(deck.getCard());
					printHands();
				}
			}
		} else {
			while (dealer.getValue() <= 16 && dealer.getValue() <= player.getValue()) {
				dealer.addCard(deck.getCard());
				printHands();
			}
		}
		checkWinner();
	}
	
	public void winner() {
		playerTurn = false;
		gameOver = true;
		JOptionPane.showMessageDialog(null, "You Win!");
		betAmountLabel.setText("Chips: " + tokens);
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
		doubleDownButton.setEnabled(false);
		splitButton.setEnabled(false);
		playAgain.setEnabled(true);
	}
	
	public void loser() {
		playerTurn = false;
		gameOver = true;
		JOptionPane.showMessageDialog(null, "You Lose!");
		betAmountLabel.setText("Chips: " + tokens);
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
		doubleDownButton.setEnabled(false);
		splitButton.setEnabled(false);
		playAgain.setEnabled(true);
	}
	
	public void push() {
		playerTurn = false;
		gameOver = true;
		JOptionPane.showMessageDialog(null, "Push, chips back");
		betAmountLabel.setText("Chips: " + tokens);
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
		doubleDownButton.setEnabled(false);
		splitButton.setEnabled(false);
		playAgain.setEnabled(true);
	}
	
	public void setBet(int newBet) {
		bet = newBet;
		tokens -= bet;
		updatePlayerChips();
	}
	
	public int getBet() {
		return bet;
	}
	
	public int getBet() {
		return bet;
	}
	
	public void clearHands() {
		for(int i = 0; i < 11; i++) {
			pCards[i].setIcon(null);
			dCards[i].setIcon(null);
			if(isSplit) {
				pCards2[i].setIcon(null);
			}
		}
		playerValueLabel.setText("Your Hand: " + player.getHand());
		dealerValueLabel.setText("Dealer: " + dealer.getValue());
		if(isSplit) {
			playerValueLabel2.setText("Your Hand " + player.getValue());
		}
	}
	
	/**
	 * Updates the playerChips.txt that the shop manager 
	 * needs to allow purchases
	 */
	public void updatePlayerChips() {
		FileWriter writer;
		try {
			writer = new FileWriter("playerChips.txt");
			writer.write(Integer.toString(tokens));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates tokens and the betAmountLabel based 
	 * on the value in playerChips.txt
	 */
	public void getPlayerTokens() {
		try {
			Scanner fileScanner = new Scanner(new File ("playerChips.txt"));
			tokens = fileScanner.nextInt();
			fileScanner.close();
			betAmountLabel.setText("Chips: " + tokens);
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Missing Player Chips file");
			e.printStackTrace();
		}
	}
}
