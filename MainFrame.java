import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private JLayeredPane layeredPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame newframe = new MainFrame();
					newframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1400,800);
		setResizable(false);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1400, 772);
		layeredPane.setLayout(new CardLayout(0,0));
		layeredPane.setVisible(true);
		contentPane.add(layeredPane);
		
		MenuPanel menu = new MenuPanel();
		layeredPane.add(menu.getMenu(), "menuPanel");
		BlackJackPanel game = new BlackJackPanel();
		layeredPane.add(game);
		RulesPanel rules = new RulesPanel();
		layeredPane.add(rules.getRules());
		ShopPanel shop = new ShopPanel();
		layeredPane.add(shop.getShop());
		
		menu.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swapPanel(game);
			}
		});
		
		menu.rules.addActionListener(new ActionListener () { 
			public void actionPerformed(ActionEvent e) {
				swapPanel(rules.getRules());			
			}
		});

        game.homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swapPanel(menu.getMenu());
            }
        });
        
        rules.exitButton2.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		swapPanel(menu.getMenu());
        	}
        });
        
        menu.shop.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		swapPanel(shop.getShop());
        	}
        });
		
	shop.homeButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		swapPanel(menu.getMenu());
        	}
        });
		
	}
	
	public void swapPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
}

