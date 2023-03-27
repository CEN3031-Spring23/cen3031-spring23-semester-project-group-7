import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class BlackJack extends JFrame {
	private JPanel buttonPanel;
	private JPanel dealerPanel;
	private JPanel playerPanel;
	private JPanel bettingPanel;
	private JPanel playerOptionsPanel;
	private JPanel chipsPanel;
	private JPanel deckPanel;
	private JButton homeButton;
	private JButton exitButton;
	private JLabel dealerValueLabel;
	private JLabel playerLabel;
	private JLabel betAmountLabel;
	private ButtonGroup bettingGroup;
	private JRadioButton allInButton;
	private JRadioButton minimumButton;
	private JRadioButton customBetButton;
	private JSpinner customBetSpinner;
	private JButton submitBetButton;
	private JButton hitButton;
	private JButton doubleDownButton;
	private JButton standButton;
	private JButton splitButton;
	private JLabel playerMoneyLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack frame = new BlackJack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlackJack() {
		setTitle("Black Jack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1303, 967);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonPanel.setBackground(new Color(128, 0, 255));
		buttonPanel.setBounds(530, 11, 211, 58);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(10, 11, 95, 36);
		buttonPanel.add(homeButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(106, 11, 95, 36);
		buttonPanel.add(exitButton);
		
		dealerPanel = new JPanel();
		dealerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dealerPanel.setBackground(new Color(255, 128, 128));
		dealerPanel.setBounds(10, 80, 451, 164);
		contentPane.add(dealerPanel);
		dealerPanel.setLayout(null);
		
		dealerValueLabel = new JLabel("Dealer: 0");
		dealerValueLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		dealerValueLabel.setBounds(10, 11, 176, 38);
		dealerPanel.add(dealerValueLabel);
		
		playerPanel = new JPanel();
		playerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		playerPanel.setBackground(new Color(0, 64, 128));
		playerPanel.setBounds(804, 753, 473, 164);
		contentPane.add(playerPanel);
		playerPanel.setLayout(null);
		
		playerLabel = new JLabel("Your Hand: 0");
		playerLabel.setBounds(283, 11, 180, 29);
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerPanel.add(playerLabel);
		
		bettingPanel = new JPanel();
		bettingPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bettingPanel.setBackground(new Color(255, 128, 64));
		bettingPanel.setBounds(962, 120, 315, 317);
		contentPane.add(bettingPanel);
		bettingPanel.setLayout(null);
		
		betAmountLabel = new JLabel("Betting: 0");
		betAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		betAmountLabel.setBounds(10, 5, 295, 70);
		bettingPanel.add(betAmountLabel);
		
		allInButton = new JRadioButton("All In (0)");
		allInButton.setBounds(10, 82, 96, 54);
		bettingPanel.add(allInButton);
		
		minimumButton = new JRadioButton("Minimum (5)");
		minimumButton.setBounds(10, 139, 96, 54);
		bettingPanel.add(minimumButton);
		
		customBetButton = new JRadioButton("Custom");
		customBetButton.setBounds(10, 196, 61, 54);
		bettingPanel.add(customBetButton);
		
		submitBetButton = new JButton("Submit Bet");
		submitBetButton.setBounds(79, 265, 155, 41);
		bettingPanel.add(submitBetButton);
		
		customBetSpinner = new JSpinner();
		customBetSpinner.setModel(new SpinnerNumberModel(5, 5, 1000, 1));
		customBetSpinner.setBounds(77, 209, 96, 41);
		bettingPanel.add(customBetSpinner);
		
		bettingGroup = new ButtonGroup();
		bettingGroup.add(allInButton);
		bettingGroup.add(minimumButton);
		bettingGroup.add(customBetButton);
		
		playerOptionsPanel = new JPanel();
		playerOptionsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		playerOptionsPanel.setBackground(new Color(0, 255, 64));
		playerOptionsPanel.setBounds(467, 753, 339, 164);
		contentPane.add(playerOptionsPanel);
		playerOptionsPanel.setLayout(null);
		
		hitButton = new JButton("Hit");
		hitButton.setBounds(10, 11, 145, 66);
		playerOptionsPanel.add(hitButton);
		
		doubleDownButton = new JButton("Double Down");
		doubleDownButton.setBounds(10, 88, 145, 66);
		playerOptionsPanel.add(doubleDownButton);
		
		standButton = new JButton("Stand");
		standButton.setBounds(184, 11, 145, 66);
		playerOptionsPanel.add(standButton);
		
		splitButton = new JButton("Split");
		splitButton.setBounds(184, 88, 145, 66);
		playerOptionsPanel.add(splitButton);
		
		chipsPanel = new JPanel();
		chipsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chipsPanel.setBackground(new Color(128, 64, 64));
		chipsPanel.setBounds(30, 536, 388, 381);
		contentPane.add(chipsPanel);
		chipsPanel.setLayout(null);
		
		playerMoneyLabel = new JLabel("$0");
		playerMoneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerMoneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		playerMoneyLabel.setBounds(131, 308, 116, 62);
		chipsPanel.add(playerMoneyLabel);
		
		deckPanel = new JPanel();
		deckPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		deckPanel.setBackground(new Color(128, 255, 255));
		deckPanel.setBounds(467, 322, 370, 273);
		contentPane.add(deckPanel);
		deckPanel.setLayout(null);
	}
}
