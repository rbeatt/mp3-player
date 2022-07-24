package part02;

import java.io.File;
import java.util.Scanner;
import part01.Menu;

/**
 * This class defines a console-based application to allow a user to interact with a  
 * Jukebox instance. The application should provide several user features.
 * 
 * @author ryanbeattie 40324568
 *
 */

public class UserApp {

	static Scanner input = new Scanner(System.in); // Creates a Scanner for reading inputs

	static String csvFilePath = "jukebox.csv"; // Defines CSV file path

	static File myFile = new File(csvFilePath); // Creates a Scanner for CSV file

	static Jukebox box = new Jukebox(csvFilePath, true); // Creates a new Jukebox instance, loads CSV data

	public static void main(String[] args) {

		String options[] = { "Select a Tune", "Select a Tune by Artist", "Insert Money", "Quit" };
		Menu myMenu = new Menu("\nJukebox Menu", options);
		boolean finished = false;

		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				playTune();
				break;
			case 2:
				playTuneArtist();
				break;
			case 3:
				insertMoney();
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("\nNot a valid option.");
				break;
			}
		} while (!finished);

	}
	
	/**
	 * This method displays all the Tune objects in a String array returned from getTuneInfo(). 
	 * Retrieves input from the user to pass as a parameter for the playTune() method in
	 * Jukebox.
	 * 
	 */

	public static void playTune() {
		System.out.println("\nPlay a Tune - OK");
		
		String data[] = box.getTuneInfo();
			if (data != null) {

				System.out.println("\nJukebox Tunes" + "\n-------------\n");

				for (String str : data) {
					System.out.println(str);
				}

		try {

				System.out.println("\nEnter Tune Id: ");
				int tuneid = input.nextInt();

				input.nextLine();

				System.out.println(box.playTune(tuneid));

		} catch (Exception e) {
			System.out.println("\nInvalid option.");
			input.next();
		}
		
			}
	}
	
	/**
	 * This method displays all the Tune objects in a String array returned from getTuneInfo(). 
	 * Retrieves input from the user to pass as a parameter for the getTuneInfo(artist) method which 
	 * returns an array of Tune objects with the matching artist. The user can select a Tune by inputting
	 * the Tune Id, passed as a parameter to the playTune() method in Jukebox.
	 */
	

	public static void playTuneArtist() {
		System.out.println("\nGet Tune info - OK");
		String data[] = box.getTuneInfo();

		if (data != null) {

			System.out.println("\nJukebox Tunes" + "\n");
			System.out.println("----------------" + "\n");

			for (String str : data) {
				System.out.println(str);
			}

			System.out.println("\nPlay a Tune by artist - OK");
			System.out.println("\nEnter artist name: ");
			String artist = input.nextLine().trim();
			String[] tunes = box.getTuneInfo(artist);
			boolean found = false;

			if (tunes != null) {

				for (String track : tunes) {
					System.out.println("\n" + track);
					found = true;
				}
			} else {
				found = false;

			}

			if (found) {
				try {
					System.out.println("\nEnter Tune Id: ");
					int tuneid = input.nextInt();
					input.nextLine();
					System.out.println(box.playTune(tuneid));
				} catch (Exception e) {
					System.out.println("\nInvalid option.");
					input.next();
					input.nextLine();
				}
			}
		}
	}
	
	/**
	 * This method passes an integer input by the user as a parameter to insertCoin in Jukebox.
	 * Simulates inserting a coin into the Jukebox. Only a specific amount can be added. Adds to
	 * the moneyAdded instance variable.
	 */

	public static void insertMoney() {
		try {
			System.out.println("\nInsert coin value in pence: ");
			int coin = input.nextInt();

			input.nextLine();

			box.insertCoin(coin);
		} catch (Exception e) {
			System.out.println("\nInvalid option.");
			input.next();
		}

	}
}
