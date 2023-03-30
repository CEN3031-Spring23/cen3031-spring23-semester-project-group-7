import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;

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

	/**
	 * Create the panel.
	 */
	public BlackJackPanel() {
		setBackground(new Color(0, 128, 255));
		setLayout(null);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(651, 539, 739, 172);
		add(playerPanel);
		playerPanel.setLayout(null);
		
		playerValueLabel = new JLabel("Your Hand: $0");
		playerValueLabel.setBounds(537, 11, 192, 29);
		playerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerPanel.add(playerValueLabel);
		
		dealerPanel = new JPanel();
		dealerPanel.setBounds(10, 99, 739, 172);
		add(dealerPanel);
		dealerPanel.setLayout(null);
		
		dealerValueLabel = new JLabel("Dealer: $0");
		dealerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		dealerValueLabel.setBounds(10, 11, 197, 42);
		dealerPanel.add(dealerValueLabel);
		
		playerOptionsPanel = new JPanel();
		playerOptionsPanel.setBounds(411, 539, 232, 172);
		add(playerOptionsPanel);
		playerOptionsPanel.setLayout(null);
		
		JButton hitButton = new JButton("Hit");
		hitButton.setBounds(10, 11, 95, 72);
		playerOptionsPanel.add(hitButton);
		
		JButton standButton = new JButton("Stand");
		standButton.setBounds(127, 11, 95, 72);
		playerOptionsPanel.add(standButton);
		
		JButton doubleDownButton = new JButton("Double Down");
		doubleDownButton.setBounds(10, 94, 95, 72);
		playerOptionsPanel.add(doubleDownButton);
		
		JButton splitButton = new JButton("Split");
		splitButton.setBounds(127, 94, 95, 72);
		playerOptionsPanel.add(splitButton);
		
		bettingPanel = new JPanel();
		bettingPanel.setBounds(1059, 99, 316, 272);
		add(bettingPanel);
		bettingPanel.setLayout(null);
		
		betAmountLabel = new JLabel("Betting: $0");
		betAmountLabel.setBounds(10, 11, 168, 37);
		betAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		bettingPanel.add(betAmountLabel);
		
		allInButton = new JRadioButton("All In ($0)");
		allInButton.setBounds(10, 67, 92, 43);
		bettingPanel.add(allInButton);
		
		minimumButton = new JRadioButton("Minimum ($0)");
		minimumButton.setBounds(10, 113, 92, 43);
		bettingPanel.add(minimumButton);
		
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
		bettingPanel.add(submitBetButton);
		
		customBetSpinner = new JSpinner();
		customBetSpinner.setModel(new SpinnerNumberModel(5, 5, 1000, 1));
		customBetSpinner.setBounds(108, 159, 80, 43);
		bettingPanel.add(customBetSpinner);
		
		chipPanel = new JPanel();
		chipPanel.setBounds(33, 391, 296, 302);
		add(chipPanel);
		
		deckPanel = new JPanel();
		deckPanel.setBounds(506, 282, 310, 239);
		add(deckPanel);

	}
}
