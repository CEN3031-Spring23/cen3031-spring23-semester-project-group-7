/**
 * The CardPrinter is responsible for setting and providing the
 * images of cards for the BlackJackPanel class.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CardPrinter {
	private String faceStyle;
	private String backStyle;
	private BufferedImage cardBack;
	private BufferedImage cardFaces;
	private BufferedImage[][] faces;
	
	public CardPrinter() {
		faceStyle = "simpleDeck.png";
		backStyle = "simpleCardBack.png";
	}
	
	public void setStyle(String faceStyle, String backStyle) {
		this.faceStyle = faceStyle;
		this.backStyle = backStyle;
	}
	
	/**
	 * Returns an ImageIcon for the back of a card 
	 * based on the set backStyle
	 */
	public ImageIcon getBack() {
		try {
			cardBack = ImageIO.read(new File("src/imgs/styles/" + backStyle));
			ImageIcon back = new ImageIcon(cardBack);
			return back;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns an ImageIcon for the face of a card
	 * by using the suit and rank to clip out an image
	 * from the set faceStlye
	 */
	public ImageIcon getFace(int suit, int rank) {
		try {
			cardFaces = ImageIO.read(new File("src/imgs/styles/" + faceStyle));
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
	
	/**
	 * Updates the current style based on the saved playerData.txt
	 */
	public void update() {
		try {
			Scanner fileScanner = new Scanner(new File ("playerData.txt"));
			fileScanner.useDelimiter(",");
			int selectedDeck = fileScanner.nextInt();
			fileScanner.close();
			if(selectedDeck == 1) {
				setStyle("simpleDeck.png","simpleCardBack.png");
			}
			
			if(selectedDeck == 2) {
				setStyle("jackDeck.png","jackBack.png");
			}
			
			if(selectedDeck == 3) {
				setStyle("landonCardsFinalResize.png","landonBackOfCard.png");
			}
			
			if(selectedDeck == 4) {
				setStyle("bdtDeckStyle.png","bdtBackOfCard.png");
			}
			
			if(selectedDeck == 5) {
				setStyle("Doodle_Deck.png","Doodle deck back.png");
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Missing Player Data file");
			e.printStackTrace();
		}
	}
}	