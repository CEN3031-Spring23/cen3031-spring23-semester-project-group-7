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
		
		menu.start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swapPanel(game);
			}
		});

        game.homeButton.addActionListener(new ActionListener() {
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

