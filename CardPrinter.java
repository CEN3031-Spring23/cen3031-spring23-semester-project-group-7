import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CardPrinter {
	private String faceStyle;
	private String backStyle;
	private BufferedImage cardBack;
	private BufferedImage cardFaces;
	private BufferedImage[][] faces;
	private int playerX;
	private int playerY;
	private int dealerX;
	private int dealerY;
	
	public CardPrinter() {
		faceStyle = "default.png";
		backStyle = "defaultBack.png";
		playerX = 0;
		playerY = 0;
		dealerX = 0;
		dealerY = 0;
	}
	
	public void setStyle(String faceStyle, String backStyle) {
		this.faceStyle = faceStyle;
		this.backStyle = backStyle;
	}
	
	public ImageIcon getBack() {
		try {
			cardBack = ImageIO.read(new File("src/imgs/styles/defaultBack.png"));
			ImageIcon back = new ImageIcon(cardBack);
			return back;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ImageIcon getFace(int suit, int rank) {
		try {
			cardFaces = ImageIO.read(new File("src/imgs/styles/default.png"));
			faces = new BufferedImage[4][13];
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 13; j++) {
					faces[i][j] = cardFaces.getSubimage(j*1497/13, i*690/4, 1497/13, 690/4);
				}
			}
			ImageIcon face = new ImageIcon(faces[suit][rank]);
			return face;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}	