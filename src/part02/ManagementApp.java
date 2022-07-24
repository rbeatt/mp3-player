package part02;

import java.io.File;
import java.util.Scanner;

import part01.Genre;
import part01.Menu;

/**
 * This class defines a console-based application to allow a  user (owner) to manage the data associated with a Jukebox. The application 
 * should also provide some features.
 * 
 * @author ryanbeattie 40324568
 */

public class ManagementApp {

	static Scanner input = new Scanner(System.in);

	static String csvFilePath = "jukebox.csv";

	static File myFile = new File(csvFilePath);

	static Jukebox box = new Jukebox(csvFilePath, true);

	public static void main(String[] args) {

		String options[] = { "Add a Tune", "Edit Cost Per Play", "View Tunes", "Quit" };
		Menu myMenu = new Menu("\nJukebox Menu", options);
		boolean finished = false;

		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				addTune();
				break;
			case 2:
				costPerPlay();
				break;
			case 3:
				viewTunes();
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
	 * This method retrieves input from the user to pass as parameters for the addTune() method in
	 * MP3Player. The exportTune() method in Jukebox is called to write the Tune object to the CSV file.
	 */

	public static void addTune() {
		try {
			System.out.println("\nAdd a Tune - OK");
			System.out.println("\nEnter title: ");
			String title = input.nextLine().trim();
			System.out.println("\nEnter artist: ");
			String artist = input.nextLine().trim();
			System.out.println("\nEnter duration: ");
			int duration = input.nextInt();

			input.nextLine();

			String genre = selectGenre();

			Genre style = Genre.valueOf(genre);

			if (box.addTune(title, artist, duration, style) == false) {
				return;
			}

			box.exportTune(title, artist, duration, genre, csvFilePath, false);

		} catch (Exception e) {
			System.out.println("\nInvalid option.");
			input.next();
			input.nextLine();
		}
	}
	
	/**
	 * This method uses a switch to retrieve input for the style instance variable
	 * when adding a new Tune object.
	 */

	public static String selectGenre() {
		String options[] = { "Rock", "Pop", "Dance", "Jazz", "Classical", "Other" };
		Menu genSelect = new Menu("\nSelect a Genre", options);

		int choice = genSelect.getUserChoice();

		switch (choice) {
		case 1:
			return "ROCK";

		case 2:
			return "POP";

		case 3:
			return "DANCE";

		case 4:
			return "JAZZ";

		case 5:
			return "CLASSICAL";

		case 6:
			return "OTHER";

		default:
			return "OTHER";

		}

	}
	
	/**
	 * This method retrieves input from the user to pass as a parameter to the setCostPerPlay()
	 * method in Jukebox. The exportCostPerPlay() method in Jukebox is called to write the cost per play
	 * to the CSV file.
	 */

	public static void costPerPlay() {
		System.out.println("\nUpdate cost per play - OK");
		try {
			System.out.println("\nEnter new cost per play: ");
			int costPerPlay = input.nextInt();
			input.nextLine();
			box.setCostPerPlay(costPerPlay);
			box.exportCostPerPlay(costPerPlay, csvFilePath, true);
			System.out.println("\nCost per play updated to: " + box.getCostPerPlay() + " pence.");
		} catch (Exception e) {
			System.out.println("\nInvalid option.");
			input.next();
		}

	}
	
	/**
	 * This method displays all the Tune objects in a String array returned from getTuneInfo() 
	 * in MP3Player. 
	 */

	public static void viewTunes() {
		System.out.println("\nGet Tune info - OK");
		String details[] = box.getTuneInfo();

		if (details != null) {
			System.out.println("\nJukebox Tunes" + "\n");
			System.out.println("-------------" + "\n");

			for (String str : details) {
				System.out.println(str);
			}
		}
	}

}
