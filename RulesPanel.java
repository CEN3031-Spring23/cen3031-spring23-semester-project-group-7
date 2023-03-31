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
	private JLabel rulesLabel; 
	private String rules;
	public JButton exitButton2;
	
	public RulesPanel () {
		
		   rulesPanel = new JPanel(); 
		   Color wh =  new Color(29, 74, 146);
		   rulesPanel.setBackground(wh);
		   rulesPanel.setBounds(0, 0, 1400, 772);  
		   rulesPanel.setLayout(null);
		   exitButton2 = new JButton("Exit");
		   exitButton2.setForeground(Color.BLACK);
		   exitButton2.setBounds(0, 0, 100, 45);
		   rulesPanel.add(exitButton2);
	
	rules = "<html>Blackjack hands are scored by their point total. The hand with the highest total wins as long as it doesn't exceed 21. a hand with a higher total than 21 is said to bust.";
	rules += " Cards 2 through 10 are worth their face value, and face cards (jack, queen, king) are also worth 10. An ace's value is 11 unless this would cause the player to bust, in which case it is worth 1.";
	rules += " A hand in which an ace's value is counted as 11 is called a soft hand, because it cannot be busted if the player draws another card.";
	rules += " The goal of each player is to beat the dealer by having the higher, unbusted hand.If both the player and the dealer have the same point value, it is called a push, and neither player nor dealer wins the hand.";
	rules += "<br/>";
	rules += "<br/>";
        rules += "Each player has an independent game with the dealer, so it is possible for the dealer to lose to one player, but still beat the other players in the same round.";
        rules += " If the player has blackjack and the dealer doesn't, the dealer automatically loses. If the dealer has blackjack and the player doesn't, the player automatically loses.";
    	rules += " If both the dealer and the player have blackjack, then it is a push. If neither has blackjack then the player plays out their hand, then the dealer plays their hand.";
    	rules += "<br/>";
    	rules += "<br/>";
    	rules += "The player's options for playing his or her hand are:";
	rules += "<br/>";
	rules += "Hit: Take another card.";
	rules += "<br/>";
	rules += "Stand: Take no more cards.";
	rules += "<br/>";
	rules += "Double down: Double the wager, take exactly one more card, and then stand.";
	rules += "<br/>";
	rules += "<br/>";
	rules += "Once the player has finished playing their hand  the dealer will play their own hand by continuously hitting until the dealer's hand reaches 17. The dealer will hit on a soft 17 (for instance an ace and a 6).</html>";
	rulesLabel = new JLabel(rules, SwingConstants.CENTER);
	rulesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	rulesLabel.setForeground(Color.GREEN);
	rulesLabel.setBounds(0, 0, 1350, 690);  
	rulesPanel.add(rulesLabel);
	


	}
	
	public JPanel getRules() {
		return rulesPanel;
	}

}
