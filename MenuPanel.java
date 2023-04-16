import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel {
	private JPanel panel;
	private JLabel logo;
	private JPanel btnHolder;
	public JButton start;
	public JButton rules;
	public JButton shop;
	private JLabel chipsIcon;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		panel = new JPanel();
		btnHolder = new JPanel();
		
		panel.setBackground(new Color(29, 74, 146));
		panel.setBounds(0, 0, 1400, 772);
		panel.setLayout(null);
		
		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(MenuPanel.class.getResource("/imgs/blackJackLogo7.png")));
		logo.setBounds(0, 0, 1400, 305);
		panel.add(logo);
		btnHolder.setBackground(new Color(29, 74, 146));
		btnHolder.setBounds(0, 317, 1396, 455);
		panel.add(btnHolder);
		btnHolder.setLayout(null);
		
		start = new JButton("Start Game");
		start.setForeground(Color.BLACK);
		start.setBounds(619, 66, 183, 68);
		btnHolder.add(start);
		
		rules = new JButton("Rules");
		rules.setForeground(Color.BLACK);
		rules.setBounds(619, 174, 183, 68);
		btnHolder.add(rules);
		
		shop = new JButton("Shop");
		shop.setForeground(Color.BLACK);
		shop.setBounds(619, 279, 183, 68);
		btnHolder.add(shop);
		
		chipsIcon = new JLabel("");
		chipsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		chipsIcon.setIcon(new ImageIcon(MenuPanel.class.getResource("/imgs/chips2.png")));
		chipsIcon.setBounds(6, 6, 612, 443);
		btnHolder.add(chipsIcon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MenuPanel.class.getResource("/imgs/cardsLogo.png")));
		lblNewLabel.setBounds(833, 6, 557, 443);
		btnHolder.add(lblNewLabel);
	}
	
	public JPanel getMenu() { 
		return panel;
	}
}
