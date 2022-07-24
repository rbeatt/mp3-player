package part02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import part01.MP3Player;
import part01.Genre;

/**
 * This class models a Jukebox object, which extends the behaviour of the MP3Player object, also defining 
 * some of its functions.
 *  
 * @author ryanbeattie 40324568
 */

public class Jukebox extends MP3Player {
	private int moneyAdded;
	private int costPerPlay;

	/**
	 * This is the constructor method for the Jukebox object. It sets moneyAdded to
	 * 0 and costPerPlay to 10 (10 pence). The constructor attempts to load the
	 * state of the Jukebox from a CSV file (if available).
	 * 
	 * @param csvFilePath - the CSV file path
	 * @param hasHeader   - a boolean to indicate whether or not the CSV file has a
	 *                    header
	 */

	public Jukebox(String csvFilePath, boolean hasHeader) {
		this.moneyAdded = 0;
		this.costPerPlay = 10;

		try {
			File myFile = new File(csvFilePath);
			Scanner mySc = new Scanner(myFile);

			if (hasHeader) {
				int cost = mySc.nextInt();
				setCostPerPlay(cost);
				mySc.nextLine();
			}
			while (mySc.hasNextLine()) {
				String record = mySc.nextLine();
				String[] parts = record.split(",");

				String title = parts[0].trim();
				String artist = parts[1].trim();
				int duration = Integer.parseInt(parts[2].trim());
				String genre = parts[3].trim();
				Genre style = Genre.valueOf(genre);

				addTune(title, artist, duration, style); // Adds Tune objects stored in CSV file
			}
			mySc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method takes a single integer parameter representing the value of a coin
	 * (in pence) and adds this to moneyAdded. Only 10p, 20p, 50p, 1 pound and
	 * 2-pound coins are allowed.
	 * 
	 * @param coin - the amount (in pence) to be added
	 */

	public void insertCoin(int coin) {
		if (coin == 10 || coin == 20 || coin == 50 || coin == 100 || coin == 200) {
			this.moneyAdded += coin;
			System.out.println("\nTotal amount: " + this.getMoneyAdded());
		} else {
			System.out.println("\nJukebox only accepts 10p, 20p, 50p, £1 and £2 coins.");
		}

	}

	/**
	 * This method sets new information into the costPerPlay instance variable of
	 * the Jukebox object.
	 * 
	 * @param costPerPlay - the cost of playing a Tune (in pence)
	 */

	public void setCostPerPlay(int costPerPlay) {
		this.costPerPlay = costPerPlay;
	}

	/**
	 * This method returns the money remaining in the Jukebox.
	 * 
	 * @return - the money remaining
	 */

	public int getMoneyAdded() {
		return this.moneyAdded;
	}
	
	/**
	 * This method returns the cost per play of the Jukebox.
	 * 
	 * @return - the cost per play
	 */

	public int getCostPerPlay() {
		return this.costPerPlay;
	}

	/**
	 * This method calls the play() method in Tune, subtracting the cost per play
	 * from the money added each time it is called. This method overrides 
	 * the playTune() method in MP3Player.
	 * 
	 * @param tuneId - the id of the Tune to be played
	 * 
	 * @return - calls the play() method in Tune, which returns a String containing
	 *         the name and artist of a tune.
	 */

	@Override
	public String playTune(int tuneId) {
		if (this.moneyAdded >= this.costPerPlay) {
			moneyAdded -= costPerPlay;
			System.out.println("\nAmount remaining: " + this.getMoneyAdded());
			return super.playTune(tuneId);

		} else {
			System.out.println("\nPlease insert coins to play Tune.");
			return null;
		}
	}
	
	/**
	 * This method writes Tune objects to the CSV file specified in the file path. Previous
	 * Tune objects are written first, to prevent Tunes from being overwritten, followed by
	 * the new Tune object to be added. 
	 * 
	 * @param title - the title of the Tune
	 * @param artist - the artist of the Tune
	 * @param duration - the duration of the Tune
	 * @param genre - the style of the Tune
	 * @param csvOutPath - the file path for the CSV file where Tune objects are stored
	 * @param hasHeader - boolean value defining whether or not the CSV file has a header
	 */

	public void exportTune(String title, String artist, int duration, String genre, String csvOutPath,
			boolean hasHeader) {
		try {
			File myFile = new File(csvOutPath);
			Scanner mySc = new Scanner(myFile);
			String record = ""; // String to store previous Tune objects to prevent them from being overwritten.

			if (hasHeader) {
				mySc.nextLine();
			}

			while (mySc.hasNextLine()) {
				record += mySc.nextLine() + "\n";
			}

			PrintWriter myPw = new PrintWriter(csvOutPath);

			myPw.print(record); 
			myPw.print(title + ", ");
			myPw.print(artist + ", ");
			myPw.print(duration + ", ");
			myPw.print(genre);

			myPw.close();
			mySc.close();

			System.out.println("\nWrite to CSV file completed successfully");

		} catch (FileNotFoundException e) { // Caught if file cannot be found
			e.printStackTrace();
		}

	}
	
	/**
	 * This method writes the cost per play of Tunes to the CSV file specified in the file path. The cost per play
	 * is stored in the header of the CSV file. Previous Tune objects are also written, to prevent Tunes from being 
	 * overwritten.
	 * 
	 * @param costPerPlay - the cost per play of Tunes
	 * @param csvOutPath - the CSV file path
	 * @param hasHeader - boolean value defining whether or not the CSV file has a header
	 */

	public void exportCostPerPlay(int costPerPlay, String csvOutPath, boolean hasHeader) {
		try {
			File myFile = new File(csvOutPath);
			Scanner mySc = new Scanner(myFile);
			String record = ""; // Stores previous Tune objects
			int cpp = this.getCostPerPlay(); 

			if (hasHeader) {
				mySc.nextLine();
			}

			while (mySc.hasNextLine()) {
				record += mySc.nextLine() + "\n";
			}

			PrintWriter myPw = new PrintWriter(csvOutPath);

			myPw.print(cpp + "\n"); // Writes cost per play
			myPw.print(record);
			myPw.close();
			mySc.close();

			System.out.println("\nWrite to CSV file completed successfully");

		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Caught if file cannot be found
		}
	}
}
