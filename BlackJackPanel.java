import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlackJackPanel extends JPanel {
	private JPanel playerPanel;
	private JLabel playerValueLabel;
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
	private int x;
	private CardPrinter cp;
	private JLabel[] pCards;
	private JLabel[] dCards;
	
	
	
	/**
	 * This is all of the private variables for the game logic
	 */
	private int bet;
	private int tokens;
	private Dealer dealer;
	private Player player;
	private Deck deck;
	private boolean gameOver;
	private boolean playerTurn;
	
	
	

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
		deck = new Deck();
		gameOver = false;
		playerTurn = true;
		cp = new CardPrinter();
		pCards = new JLabel[11];
		dCards = new JLabel[11];
		
		
		
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
		
		playerValueLabel = new JLabel("Your Hand: " + player.getValue());
		playerValueLabel.setBounds(537, 11, 192, 29);
		playerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerPanel.add(playerValueLabel);
		
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
		
		JButton hitButton = new JButton("Hit");
		hitButton.setBounds(10, 11, 95, 72);
		playerOptionsPanel.add(hitButton);
		hitButton.setEnabled(false);
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit();
				printHands();
				if(hasPlayerBusted()) {
					checkWinner();
				}
			}
		});
		
		JButton standButton = new JButton("Stand");
		standButton.setBounds(127, 11, 95, 72);
		playerOptionsPanel.add(standButton);
		standButton.setEnabled(false);
		standButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stand();
				hitButton.setEnabled(false);
				standButton.setEnabled(false);
			}
		});
		
		JButton doubleDownButton = new JButton("Double Down");
		doubleDownButton.setBounds(10, 94, 95, 72);
		playerOptionsPanel.add(doubleDownButton);
		doubleDownButton.setEnabled(false);
		
		JButton splitButton = new JButton("Split");
		splitButton.setBounds(127, 94, 95, 72);
		playerOptionsPanel.add(splitButton);
		splitButton.setEnabled(false);
		
		bettingPanel = new JPanel();
		bettingPanel.setBounds(1059, 99, 316, 272);
		add(bettingPanel);
		bettingPanel.setLayout(null);
		bettingPanel.setOpaque(false);
		
		betAmountLabel = new JLabel("Chips: " + tokens);
		betAmountLabel.setBounds(10, 11, 168, 37);
		betAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		bettingPanel.add(betAmountLabel);
		
		allInButton = new JRadioButton("All In ($0)");
		allInButton.setBounds(10, 67, 92, 43);
		bettingPanel.add(allInButton);
		allInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customBetSpinner.setValue(tokens);
			}
		});
		
		minimumButton = new JRadioButton("Minimum (1)");
		minimumButton.setBounds(10, 113, 92, 43);
		bettingPanel.add(minimumButton);
		minimumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customBetSpinner.setValue(1);
			}
		});
		
		customBetButton = new JRadioButton("Custom");
		customBetButton.setBounds(10, 159, 92, 43);
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
				printHands();
				handleResult(checkBlackJack());
				hitButton.setEnabled(true);
				standButton.setEnabled(true);
			}
		});
		bettingPanel.add(submitBetButton);
		
		customBetSpinner = new JSpinner();
		customBetSpinner.setModel(new SpinnerNumberModel(5, 5, 1000, 1));
		customBetSpinner.setBounds(108, 159, 80, 43);
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
		navigationPanel.setBounds(546, 11, 300, 56);
		add(navigationPanel);
		navigationPanel.setLayout(null);
		navigationPanel.setOpaque(false);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(10, 11, 85, 40);
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		navigationPanel.add(homeButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitButton.setBounds(108, 11, 85, 40);
		navigationPanel.add(exitButton);
		
		playAgain = new JButton("Play Again");
		playAgain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playAgain.setBounds(206, 11, 85, 40);
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
		displayPlayerHand();
		displayDealerHand();
	}
	
	public void displayPlayerHand() {
		for(int i = 0; i < player.getNumOfCards(); i++) {
			pCards[i].setIcon(cp.getFace(player.getSuitOfCard(i), player.getRankOfCard(i) - 1));
		}
		playerValueLabel.setText("Your Hand " + player.getValue());
	}
	
	public void displayDealerHand() {
		for(int i = 0; i < dealer.getNumOfCards(); i++) {
			dCards[i].setIcon(cp.getFace(dealer.getSuitOfCard(i), dealer.getRankOfCard(i) - 1));
		}
		dealerValueLabel.setText("Dealer: " + dealer.getValue());
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
			return 0;
		} else {
			return 0;
		}
	}

	// Checks for if the player has busted
	public boolean hasPlayerBusted() {
		player.aceBuster();
		if (player.getValue() > 21) {
			return true;
		} else {
			return false;
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
		playerTurn = true;
		clearHands();
	}
	
	// The initial deal of the cards to dealer and player
	//Calls the handleResult function with the value of checkBlackJack
	public void deal() {
		deck.shuffle();
		for(int i = 0; i < 2; i++) {
			player.addCard(deck.getCard());
			dealer.addCard(deck.getCard());
		}
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
		}
	}
	
	// Adds a card to players hand
	// Checks for the bust and if true goes through the end of game sequence
	// Else just prints the new hand
	public void hit() {
		player.addCard(deck.getCard());
	}
	
	// Ends the players turn and calls the dealerTurn function to execute the dealers turn
	public void stand() {
		playerTurn = false;
		dealerTurn();
	}
	
	// The dealer hits as long as the value of the hand is less than 16 and less than the player
	// After each hit it reprints the hands
	// Calls checkWinner after its turn is over
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
		JOptionPane.showMessageDialog(null, "You Win!");
		betAmountLabel.setText("Chips: " + tokens);
		playAgain.setEnabled(true);
	}
	
	public void loser() {
		playerTurn = false;
		gameOver = true;
		JOptionPane.showMessageDialog(null, "You Lose!");
		betAmountLabel.setText("Chips: " + tokens);
		playAgain.setEnabled(true);
	}
	
	public void push() {
		playerTurn = false;
		gameOver = true;
		JOptionPane.showMessageDialog(null, "Push, chips back");
		betAmountLabel.setText("Chips: " + tokens);
		playAgain.setEnabled(true);
	}
	
	public void setBet(int newBet) {
		bet = newBet;
		tokens -= bet;
	}
	
	public void clearHands() {
		for(int i = 0; i < 11; i++) {
			pCards[i].setIcon(null);
			dCards[i].setIcon(null);
		}
		playerValueLabel.setText("Your Hand " + player.getValue());
		dealerValueLabel.setText("Dealer: " + dealer.getValue());
	}
}
