/**
 * The ShopPanel is a subclass of the JPanel class. 
 * The ShopPanel is responsible for displaying a GUI
 * for a user to view, purchase, and select a custom
 * deck.
 */

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class ShopPanel extends JPanel {

	private JPanel shopPanel;
	private JLabel display;
	public JButton deck1;
	public JButton deck2;
	public JButton deck3;
	public JButton deck4;
	public JButton deck5;
	private JLabel title;
	private JButton front;
	private JButton back;
	public JButton homeButton;
	private JButton selectButton;
	private JButton purchaseButton;
	private JLabel priceLabel;
	private ShopManager shop;
	
	public ShopPanel() {
		
		shop = new ShopManager();
		shop.updateShopData();
		shopPanel = new JPanel();
		display = new JLabel("");
		display.setLocation(255, 237);
		display.setSize(745, 468);
		shopPanel.add(display);
		shopPanel.setBackground(new Color(29, 74, 146));
		priceLabel = new JLabel();
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setBackground(Color.LIGHT_GRAY);
		priceLabel.setBounds(255, 202, 194, 34);
		shopPanel.add(priceLabel);
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		selectButton = new JButton("Select");
		selectButton.setVisible(true);
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.select();
				shop.updatePlayerData();
				priceLabel.setText(shop.getPriceLabel());
			}
		});
		selectButton.setBounds(245, 716, 111, 34);
		shopPanel.add(selectButton);
		
		purchaseButton = new JButton("Purchase");
		purchaseButton.setVisible(false);
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shop.canPurchase()) {
					shop.purchase();
					priceLabel.setText((shop.getPriceLabel()));
					shop.updatePlayerData();
					purchaseButton.setVisible(false);
					selectButton.setVisible(true);
				}
			}
		});
		purchaseButton.setBounds(366, 716, 111, 34);
		shopPanel.add(purchaseButton);
		
		front = new JButton("Front");
		front.setBounds(487, 716, 111, 34);
		back = new JButton("Back");
		back.setBounds(608, 716, 111, 34);
		
		deck1 = new JButton("Simple");
		deck1.setBounds(37, 237, 183, 68);
		shopPanel.setLayout(null);
		deck1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setCurrentDeck(1);
				priceLabel.setText(shop.getPriceLabel());
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
				selectButton.setVisible(true);
				purchaseButton.setVisible(false);
			}
		});
		
		shopPanel.add(deck1);
		
		deck2 = new JButton("Classic");
		deck2.setBounds(37, 337, 183, 68);
		deck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setCurrentDeck(2);
				priceLabel.setText(shop.getPriceLabel());
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
				if(shop.isCurrentUnlocked()) {
					purchaseButton.setVisible(false);
					selectButton.setVisible(true);
				}
				else {
					selectButton.setVisible(false);
					purchaseButton.setVisible(true);
				}
			}
		});
		
		shopPanel.add(deck2);
		
		deck3 = new JButton("Retro");
		deck3.setBounds(37, 437, 183, 68);
		deck3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setCurrentDeck(3);
				priceLabel.setText(shop.getPriceLabel());
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
				if(shop.isCurrentUnlocked()) {
					selectButton.setVisible(true);
					purchaseButton.setVisible(false);
				}
				else {
					selectButton.setVisible(false);
					purchaseButton.setVisible(true);
				}
			}
		});
		shopPanel.add(deck3);

		deck4 = new JButton("Random");
		deck4.setBounds(37, 537, 183, 68);
		deck4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setCurrentDeck(4);
				priceLabel.setText(shop.getPriceLabel());
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
				if(shop.isCurrentUnlocked()) {
					selectButton.setVisible(true);
					purchaseButton.setVisible(false);
				}
				else {
					selectButton.setVisible(false);
					purchaseButton.setVisible(true);
				}
			}
		});
		shopPanel.add(deck4);

		deck5 = new JButton("Doodle");
		deck5.setBounds(37, 637, 183, 68);
		deck5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.setCurrentDeck(5);
				priceLabel.setText(shop.getPriceLabel());
				shop.setCurrentDeck(5);
				ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
				Image image = i1.getImage();
				Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
				i1 = new ImageIcon(scaleImage);
				display.setIcon(i1);
				if(shop.isCurrentUnlocked()) {
					selectButton.setVisible(true);
					purchaseButton.setVisible(false);
				}
				else {
					selectButton.setVisible(false);
					purchaseButton.setVisible(true);
				}
			}
		});
		shopPanel.add(deck5);
		
		title = new JLabel("");
		title.setIcon(new ImageIcon(ShopPanel.class.getResource("/imgs/shoptitle.png.png")));
		title.setBounds(255, 37, 770, 170);
		shopPanel.add(title);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ImageIcon back1 = new ImageIcon(ShopPanel.class.getResource(shop.getBack()));
					display.setIcon(back1);
			}
		});	
		
		front.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ImageIcon i1 = new ImageIcon(ShopPanel.class.getResource(shop.getDeck()));
					Image image = i1.getImage();
					Image scaleImage = image.getScaledInstance(745, 468, Image.SCALE_DEFAULT);
					i1 = new ImageIcon(scaleImage);
					display.setIcon(i1);
			}
		});	
		
		
		shopPanel.add(front);
		shopPanel.add(back);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(37, 139, 183, 68);
		shopPanel.add(homeButton);
		
	}
	
	public JPanel getShop() {
		return shopPanel;
	}
	
}
