import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel {
	public MenuPanel() {
		final JPanel btnHolder = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(29, 74, 146));
		panel.setBounds(0, 0, 1396, 772);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("/imgs/blackJackLogo7.png"));
		logo.setBounds(0, 0, 1390, 305);
		panel.add(logo);
		btnHolder.setBackground(new Color(29, 74, 146));
		btnHolder.setBounds(0, 317, 1396, 455);
		panel.add(btnHolder);
		btnHolder.setLayout(null);
		
		JButton start = new JButton("Start Game");
		start.setForeground(Color.WHITE);
		start.setBounds(630, 66, 183, 68);
		btnHolder.add(start);
		
		JButton rules = new JButton("Rules");
		rules.setForeground(Color.WHITE);
		rules.setBounds(630, 174, 183, 68);
		btnHolder.add(rules);
		
		JButton shop = new JButton("Shop");
		shop.setForeground(Color.WHITE);
		shop.setBounds(630, 279, 183, 68);
		btnHolder.add(shop);
		
		JLabel chipsIcon = new JLabel("");
		chipsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		chipsIcon.setIcon(new ImageIcon(("/imgs/chips2.png")));
		chipsIcon.setBounds(6, 6, 612, 443);
		btnHolder.add(chipsIcon);
	}

}
