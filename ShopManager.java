/**
 * The ShopManager class is responsible for purchasing, unlocking, and selecting
 * different deck styles. The ShopManager class is also responsible for providing
 * information about the status of which decks are unlocked, their price, and their
 * file path for their images.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShopManager {
	private final int CLASSIC_DECK_PRICE = 150;
	private final int RETRO_DECK_PRICE = 200;
	private final int RANDOM_DECK_PRICE = 250;
	private final int DOODLE_DECK_PRICE = 500;
	private final String FILEPATH = "/imgs/styles/";
	private int currentDeck;
	private int selectedDeck;
	private int chips;
	private boolean classicDeckUnlocked;
	private boolean retroDeckUnlocked;
	private boolean randomDeckUnlocked;
	private boolean doodleDeckUnlocked;
	
	public ShopManager() {
		chips = 100;
		selectedDeck = 1;
		currentDeck = 1;
		classicDeckUnlocked = false;
		retroDeckUnlocked = false;
		randomDeckUnlocked = false;
		doodleDeckUnlocked = false;
	}
	
	public void setCurrentDeck(int newDeckNumber) {
		currentDeck = newDeckNumber;
	}
	
	public boolean isClassicDeckUnlocked() {
		return classicDeckUnlocked;
	}
	
	public void setClassicDeckUnlocked(boolean classicDeckUnlocked) {
		this.classicDeckUnlocked = classicDeckUnlocked;
	}
	
	public boolean isRetroDeckUnlocked() {
		return retroDeckUnlocked;
	}
	
	public void setRetroDeckUnlocked(boolean retroDeckUnlocked) {
		this.retroDeckUnlocked = retroDeckUnlocked;
	}
	
	public boolean isRandomDeckUnlocked() {
		return randomDeckUnlocked;
	}
	
	public void setRandomDeckUnlocked(boolean randomDeckUnlocked) {
		this.randomDeckUnlocked = randomDeckUnlocked;
	}
	
	public boolean isDoodleDeckUnlocked() {
		return doodleDeckUnlocked;
	}
	
	public void setDoodleDeckUnlocked(boolean doodleDeckUnlocked) {
		this.doodleDeckUnlocked = doodleDeckUnlocked;
	}
	
	public String getDeck() {
		String imageName;
		if(currentDeck == 2) {
			imageName = "jackDeck.png";
		}
		
		else if(currentDeck == 3) {
			imageName = "landonCardsFinalResize.png";
		}
		
		else if(currentDeck == 4){
			imageName = "bdtDeckStyle.png";
		}
		
		else if(currentDeck == 5){
			imageName = "Doodle_Deck.png";
		}
		
		else {
			imageName = "simpleDeck.png";
		}
		
		return FILEPATH + imageName;
	}
	
	public String getBack() {
		String imageName;
		if(currentDeck == 2) {
			imageName = "jackBack.png";
		}
		
		else if(currentDeck == 3) {
			imageName = "landonBackOfCard.png";
		}
		
		else if(currentDeck == 4){
			imageName = "bdtBackOfCard.png";
		}
		
		else if(currentDeck == 5){
			imageName = "Doodle deck back.png";
		}
		
		else {
			imageName = "simpleCardBack.png";
		}
		
		return FILEPATH + imageName;
	}
	
	public int getPrice() {
		if(currentDeck == 2) {
			return CLASSIC_DECK_PRICE;
		}
		
		else if(currentDeck == 3) {
			return RETRO_DECK_PRICE;
		}
		
		else if(currentDeck == 4) {
			return RANDOM_DECK_PRICE;
		}
		
		else if(currentDeck == 5) {
			return DOODLE_DECK_PRICE;
		}
		
		else {
			return -1;
		}
	}
	
	public String getPriceLabel() {
		String priceLabel;
		
		if(currentDeck == selectedDeck) {
			priceLabel = "SELECTED";
		}
		else {
			if(currentDeck == 2) {
				if(classicDeckUnlocked) {
					priceLabel = "PURCHASED";
				}
				else {
					priceLabel = "Price: $" + CLASSIC_DECK_PRICE;
				}
			}
			
			else if(currentDeck == 3) {
				if(retroDeckUnlocked) {
					priceLabel = "PURCHASED";
				}
				else {
					priceLabel = "Price: $" + RETRO_DECK_PRICE;
				}
			}
			
			else if(currentDeck == 4) {
				if(randomDeckUnlocked) {
					priceLabel = "PURCHASED";
				}
				else {
					priceLabel = "Price: $" + RANDOM_DECK_PRICE;
				}
			}
			
			else if(currentDeck == 5) {
				if(doodleDeckUnlocked) {
					priceLabel = "PURCHASED";
				}
				else {
					priceLabel = "Price: $" + DOODLE_DECK_PRICE;
				}
			}
			
			else {
				priceLabel = "UNLOCKED";
			}
		}
		
		return priceLabel;
		
	}
	
	public boolean isCurrentUnlocked() {
		if(currentDeck == 2) {
			return classicDeckUnlocked;
		}
		
		else if(currentDeck == 3) {
			return retroDeckUnlocked;
		}
		
		else if(currentDeck == 4) {
			return randomDeckUnlocked;
		}
		
		else if(currentDeck == 5) {
			return doodleDeckUnlocked;
		}
		
		else {
			return true;
		}
	}
	
	public void unlock() {
		if(currentDeck == 2) {
			classicDeckUnlocked = true;
		}
		
		else if(currentDeck == 3) {
			retroDeckUnlocked = true;
		}
		
		else if(currentDeck == 4) {
			randomDeckUnlocked = true;
		}
		
		else if(currentDeck == 5) {
			doodleDeckUnlocked = true;
		}
	}
	
	public void select() {
		if(isCurrentUnlocked()) {
			selectedDeck = currentDeck;
		}
	}
	
	/**
	 * Reads from the playerChips.txt file to update the chip
	 * total to what the player currently has
	 */
	public int getChips() {
		try {
			Scanner fileScanner = new Scanner(new File ("playerChips.txt"));
			chips = fileScanner.nextInt();
			fileScanner.close();
			return chips;
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Missing Player Chips file");
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Determines whether or not a player can purchase the current
	 * deck style they are previewing as well as if they have already
	 * unlocked the deck style
	 */
	public boolean canPurchase() {
			if (getChips() > getPrice() + 1 && !isCurrentUnlocked()) {
				return true;
			}
			
			else {
				return false;
			}
	}
	
	/**
	 * Writes the updated chip total to the
	 * playerChips.txt file after a purchase has been made
	 */
	public void purchase() {
		FileWriter writer;
		chips = getChips() - getPrice();
		try {
			writer = new FileWriter("playerChips.txt");
			writer.write(Integer.toString(chips));
			writer.close();
			unlock();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String printInfo() {
		return selectedDeck + "," + classicDeckUnlocked + "," + retroDeckUnlocked + "," + randomDeckUnlocked + "," + doodleDeckUnlocked;
	}
	
	/**
	 * Writes the ShopManager's info to the 
	 * playerData.txt file for persistence
	 */
	public void updatePlayerData() {
		FileWriter writer;
		try {
			writer = new FileWriter("playerData.txt");
			writer.write(printInfo());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads from the playerData.txt file to update 
	 * the ShopManager's instance variables
	 */
	public void updateShopData() {
		try {
			Scanner fileScanner = new Scanner(new File ("playerData.txt"));
			fileScanner.useDelimiter(",");
			selectedDeck = fileScanner.nextInt();
			classicDeckUnlocked = fileScanner.nextBoolean();
			retroDeckUnlocked = fileScanner.nextBoolean();
			randomDeckUnlocked = fileScanner.nextBoolean();
			doodleDeckUnlocked = fileScanner.nextBoolean();
			fileScanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Missing Player Data file");
			e.printStackTrace();
		}
	}
	
}
