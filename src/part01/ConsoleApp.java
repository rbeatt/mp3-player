package part01;

import java.util.Scanner;

/**
 * This class defines a console (menu-based) application to test (through an MP3Player instance) the interaction with Tune instances within 
 * the system. 
 * 
 * @author ryanbeattie 40324568
 *
 */

public class ConsoleApp {
	
	// Create Scanner

	static Scanner input = new Scanner(System.in); 
	
	// Create new MP3Player instance

	static MP3Player player = new MP3Player(); 
	

	public static void main(String[] args) {

		player.addTune("One", "U2", 120, Genre.POP); // 1
		player.addTune("With Or Without You", "U2", 180, Genre.POP); // 2
		player.addTune("Back In Black", "ACDC", 160, Genre.ROCK); // 3
		player.addTune("Shoot To Thrill", "ACDC", 140, Genre.ROCK); // 4
		player.addTune("Brother", "Kodaline", 120, Genre.POP); // 5
		player.addTune("Adventure Of A Lifetime", "Coldplay", 200, Genre.POP); // 6
		player.addTune("Birds", "Coldplay", 210, Genre.POP); // 7
		player.addTune("Our Love - Original Mix", "Archelix", 180, Genre.DANCE); // 8
		player.addTune("Fair Trade", "Drake", 190, Genre.POP); // 9
		player.addTune("Doing It Wrong", "Drake", 170, Genre.POP); // 10
		player.addTune("Girls Want Girls", "Drake", 145, Genre.POP); // 11
		
		// Menu

		String options[] = { "Add a Tune", "List All Tunes", "List Tunes by Artist", "Get Top 10", "Quit" };
		Menu myMenu = new Menu("\nMP3Player Menu", options); 

		boolean finished = false;

		do {
			int option = myMenu.getUserChoice(); // Calls method in Menu class
			switch (option) { // User options
			case 1:
				addTune();
				break;

			case 2:
				getTuneInfo();
				break;

			case 3:
				getTuneArtist();
				break;

			case 4:
				getTopTen();
				break;

			case 5:
				finished = true;
				break;

			default:
				System.out.println("\nNot a valid option.");
				break;

			}
		} while (!finished); // Ends if finished = true
	}

	/**
	 * This method retrieves input from the user to pass as parameters for the addTune() method in
	 * MP3Player.
	 */

	public static void addTune() {

		try {
			System.out.println("\nAdd a tune - OK");
			System.out.println("Enter title: ");
			String title = input.nextLine().trim();
			System.out.println("Enter artist: ");
			String artist = input.nextLine().trim();
			System.out.println("Enter duration: ");
			int duration = input.nextInt();

			input.nextLine();

			Genre style = selectGenre();

			player.addTune(title, artist, duration, style);

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

	public static Genre selectGenre() {

		String options[] = { "Rock", "Pop", "Dance", "Jazz", "Classical", "Other" };
		Menu genSelect = new Menu("\nSelect a Genre", options);
		int choice = genSelect.getUserChoice();

		switch (choice) {
		case 1:
			return Genre.ROCK;

		case 2:
			return Genre.POP;

		case 3:
			return Genre.DANCE;

		case 4:
			return Genre.JAZZ;

		case 5:
			return Genre.CLASSICAL;

		case 6:
			return Genre.OTHER;

		default:
			return Genre.OTHER;

		}

	}
	
	/**
	 * This method displays all the Tune objects in a String array returned from getTuneInfo() 
	 * in MP3Player. Retrieves input from the user to pass as a parameter for the playTune() method in
	 * MP3Player.
	 */

	public static void getTuneInfo() {
		System.out.println("\nGet Tune info - OK");
		String[] details = player.getTuneInfo();
		if (details != null) {

			System.out.println("\nDownloaded Songs" + "\n");
			System.out.println("----------------" + "\n");

			for (String str : details) {
				System.out.println(str);
			}

			System.out.println("\nEnter Tune Id: ");

			try {
				int id = input.nextInt();

				input.nextLine();

				System.out.println(player.playTune(id));

			} catch (Exception e) {
				System.out.println("\nInvalid option.");
				input.next();
			}

		}

	}
	
	/**
	 * This method displays the String returned from getTopTen() in MP3Player
	 */

	public static void getTopTen() {
		System.out.println("\nGet top ten - OK");
		System.out.println(player.getTopTen());
	}
	
	/**
	 * This method displays all the Tune objects in a String array returned from getTuneInfo() 
	 * in MP3Player. Retrieves input from the user to pass as a parameter for the getTuneInfo(artist) method in
	 * MP3Player which returns an array of Tune objects with the matching artist. The user can select a Tune by inputting
	 * the Tune Id, passed as a parameter to the playTune() method in MP3Player.
	 */

	public static void getTuneArtist() {
		System.out.println("\nGet Tune info by artist - OK");
		String[] details = player.getTuneInfo();
		if (details != null) {

			System.out.println("\nDownloaded Songs" + "\n");
			System.out.println("----------------" + "\n");

			for (String str : details) {
				System.out.println(str);
			}
			System.out.println("\nEnter artist name: ");
			String artist = input.nextLine().trim();
			String[] tunes = player.getTuneInfo(artist);
			boolean found = true;

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
					System.out.println(player.playTune(tuneid));
				} catch (Exception e) {
					System.out.println("\nInvalid option.");
					input.next();
					input.nextLine();
				}
			}
		}
	}

}
