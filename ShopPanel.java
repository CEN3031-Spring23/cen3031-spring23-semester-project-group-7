import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ShopPanel extends JPanel {

	private JPanel shopPanel;
	private JLabel display;
	public JButton deck1;
	public JButton deck2;
	public JButton deck3;
	public JButton deck4;
	public JButton deck5;
	private JLabel title;
	public JButton front;
	public JButton back;
	private JTextField txtPrice;
	
	private int currentDeck;
	
	public ShopPanel() {
		
		
		shopPanel = new JPanel();
		display = new JLabel("");
		display.setLocation(255, 237);
		display.setSize(745, 468);
		shopPanel.add(display);
		shopPanel.setBackground(new Color(29, 74, 146));
		front = new JButton("Front");
		front.setBounds(255, 712, 111, 34);
		back = new JButton("Back");
		back.setBounds(381, 712, 111, 34);
		
		deck1 = new JButton("Deck 1");
		deck1.setBounds(37, 237, 183, 68);
		shopPanel.setLayout(null);
		deck1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = 1;
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/landonCardsFinalResize.png"));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
			}
		});
		
		shopPanel.add(deck1);
		
		deck2 = new JButton("Deck 2");
		deck2.setBounds(37, 337, 183, 68);
		deck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = 2;
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/simpleDeck.png"));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
			}
		});
		
		shopPanel.add(deck2);
		
		deck3 = new JButton("Deck 3");
		deck3.setBounds(37, 437, 183, 68);
		deck3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = 3;
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/jackDeck.png"));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
			}
		});
		shopPanel.add(deck3);

		deck4 = new JButton("Deck 4");
		deck4.setBounds(37, 537, 183, 68);
		deck4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = 4;
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/bdtDeckStyle.png"));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
			}
		});
		shopPanel.add(deck4);

		deck5 = new JButton("Deck 5");
		deck5.setBounds(37, 637, 183, 68);
		deck5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDeck = 5;
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/Doodle_Deck.png"));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
			}
		});
		shopPanel.add(deck5);
		
		title = new JLabel("");
		title.setIcon(new ImageIcon(ShopPanel.class.getResource("/imgs/shoptitle.png")));
		title.setBounds(255, 37, 745, 170);
		shopPanel.add(title);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentDeck == 1) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/landonBackOfCard.png"));
					display.setIcon(back1);
				}
				if(currentDeck == 2) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/simpleCardBack.png"));
					display.setIcon(back1);
				}
				if(currentDeck == 3) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/jackBack.png"));
					display.setIcon(back1);
				}
				if(currentDeck == 4) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/bdtBackOfCard.png"));
					display.setIcon(back1);
				}
				if(currentDeck == 5) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/Doodle deck back.png"));
					display.setIcon(back1);
				}
			}
		});	
		
		front.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentDeck == 1) {
					currentDeck = 1;
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/landonCardsFinalResize.png"));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
				}
				if(currentDeck == 2) {
					currentDeck = 2;
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/simpleDeck.png"));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
				}
				if(currentDeck == 3) {
					currentDeck = 3;
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/jackDeck.png"));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
				}
				if(currentDeck == 4) {
					currentDeck = 4;
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/bdtDeckStyle.png"));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
				}
				if(currentDeck == 5) {
					currentDeck = 5;
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource("/imgs/styles/Doodle_Deck.png"));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
				}
			}
		});	
		
		
		shopPanel.add(front);
		shopPanel.add(back);
		
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setBounds(1037, 671, 111, 34);
		shopPanel.add(btnNewButton);
		
		txtPrice = new JTextField();
		txtPrice.setText("Price:");
		txtPrice.setBounds(1037, 626, 111, 34);
		shopPanel.add(txtPrice);
		txtPrice.setColumns(10);
	}
	
	public JPanel getShop() {
		return shopPanel;
	}
}
