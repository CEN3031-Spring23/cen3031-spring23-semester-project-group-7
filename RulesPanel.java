import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RulesPanel extends JPanel {
	
	private JPanel rulesPanel;
	private JButton exitButton2;
	private JLabel rulesLabel; 
	private String rules;
	
	public RulesPanel () {
		
		rulesPanel = new JPanel(); 
		   Color wh = Color.white;
		   rulesPanel.setBackground(wh);
		   rulesPanel.setBounds(0, 0, 1400, 772);  
		   rulesPanel.setLayout(null);
		   rulesPanel.add(exitButton2);

		
	exitButton2 = new JButton("Exit");
	exitButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	rulesLabel = new JLabel(rules);
	rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
	rulesLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
	rulesLabel.setBounds(0, 0, 1000, 650);  //FIXLATER
	rulesPanel.add(rulesLabel);
	rules = "Blackjack hands are scored by their point total. The hand with the highest total wins as long as it doesn't exceed 21. a hand with a higher total than 21 is said to bust. Cards 2 through 10 are worth their face value, and face cards (jack, queen, king) are also worth 10. An ace's value is 11 unless this would cause the player to bust, in which case it is worth 1. A hand in which an ace's value is counted as 11 is called a soft hand, because it cannot be busted if the player draws another card.  The goal of each player is to beat the dealer by having the higher, unbusted hand.If both the player and the dealer have the same point value, it is called a push, and neither player nor dealer wins the hand.";
			rules += "\n";
	        rules += "Each player has an independent game with the dealer, so it is possible for the dealer to lose to one player, but still beat the other players in the same round. If the player has blackjack and the dealer doesn't, the dealer automatically loses. If the dealer has blackjack and the player doesn't, the player automatically loses. If both the dealer and the player have blackjack, then it is a push. If neither has blackjack then the player plays out their hand, then the dealer plays their hand.";
            rules += "\n";
	        rules += "The player's options for playing his or her hand are:";
			rules += "\n";
			rules += "Hit: Take another card.";
			rules += "\n";
			rules += "Stand: Take no more cards.";
			rules += "\n";
			rules += "Double down: Double the wager, take exactly one more card, and then stand.";
			rules += "\n";
			rules += "Once the player has finished playing their hand  the dealer will play their own hand by continuously hitting until the dealer's hand reaches 17. The dealer will hit on a soft 17 (for instance an ace and a 6).";


	}

}