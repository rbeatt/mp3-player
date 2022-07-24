package part01;

import java.util.ArrayList;

/**
 * This class models an MP3Player object, also defining some functions.
 * 
 * @author ryanbeattie 40324568
 */

public class MP3Player implements IPlayer { // IPlayer interface

	private ArrayList<Tune> soundData;

	/**
	 * This is the constructor method for the MP3Player object. It sets up the
	 * ArrayList, soundData.
	 */

	public MP3Player() {
		this.soundData = new ArrayList<Tune>(); // Array list to store Tune data
	}

	/**
	 * This method calls the play() method in Tune
	 * 
	 * @param tuneId - the id of the Tune to be played
	 * @return - calls the play() method in Tune, which returns a String containing
	 *         the name and artist of a tune.
	 */

	public String playTune(int tuneId) { // Linear search used to find Tune with matching tuneId parameter
		Tune target = null;
		for (int index = 0; index < soundData.size(); index++) {
			Tune track = soundData.get(index);
			if (track.getId() == tuneId) { // Comparison for tuneId
				target = track;
				break;
			}
		}

		if (target != null) {
			return target.play(); // Calls the play() method in Tune
		} else {
			System.out.println("\nA Tune with this Id does not exist.");
			return null; // Returns null if the search returns no result
		}

	}

	/**
	 * This method returns an array of Strings where each String contains full
	 * details of a Tune, ordered by Title and covering all available Tune objects.
	 * The method returns null if no Tune object are available.
	 * 
	 * @return - an array of Strings where each String contains full details of a
	 *         Tune, ordered by Title and covering all available Tune objects.
	 */

	public String[] getTuneInfo() {
		String data[] = new String[soundData.size()];
		int index = 0;

		for (Tune track : soundData) {
			data[index] = track.toString(); // Calls the toString() method in Tune
			index++;

		}

		if (data.length == 0) {
			System.out.println("\nNo data to display.");
			return null;
		}

		return data;
	}

	/**
	 * This method returns an array for Tune objects by a specific artist, specified
	 * by the String parameter. The data is ordered by Title. The method returns
	 * null if no Tune objects are available.
	 * 
	 * @param artist - artist of the Tune to be searched
	 * 
	 * @return - an array for Tune objects by a specific artist, specified by the
	 *         String parameter.
	 */

	public String[] getTuneInfo(String artist) {

		ArrayList<String> results = new ArrayList<String>(); // ArrayList to store matching Tunes

		for (Tune track : soundData) {

			if (track.getArtist().equals(artist)) { // Comparison for artist
				results.add(track.toString()); // Calls toString() method in Tune
			}
		}

		String data[] = results.toArray(new String[results.size()]);

		if (data.length == 0) {
			System.out.println("\nNo data to display.");
			return null;
		}
		return data;

	}

	/**
	 * This method creates and add a new Tune object to the soundData ArrayList if
	 * it’s not already present. Two Tune objects are considered to be the same if
	 * they have the same title and artist.
	 * 
	 * @param title - title of the Tune
	 * @param artit - artist of the Tune
	 * @param duration - duration of the Tune
	 * @param style - style of the Tune
	 * 
	 * @return - True returned if the tune is added. False returned if the tune already exists.
	 */

	public boolean addTune(String title, String artist, int duration, Genre style) { // Insertion sort applied when
																						// adding new Tune
		if (title != null && title != "" && artist != null && artist != "" && duration != 0 && style != null) {

			Tune track = new Tune(title, artist, duration, style);

			int position = 0;
			for (Tune t : soundData) {
				if ((track.getTitle().equals(t.getTitle())) && (track.getArtist().equals(t.getArtist()))) {
					System.out.println("\na Tune with this title and artist already exists");
					return false;
				}
				if (track.getTitle().compareTo(t.getTitle()) < 0) {
					break;
				}
				position++;
			}

			soundData.add(position, track);

			return true;

		}

		else {

			System.out.println("\nFields cannot be blank or null. Duration must be greater than 0.");
			return false;
		}

	}

	/**
	 * This method returns a single String containing the title, artist and number
	 * of plays for the top ten Tune objects within the system (ordered by number of
	 * plays, highest to lowest)
	 * 
	 * @return - a single String containing the title, artist and number of plays
	 *         for the top ten Tune objects within the system (ordered by number of
	 *         plays, highest to lowest)
	 */

	public String getTopTen() {
		Tune data[] = new Tune[soundData.size()];

		boolean ascending = false;
		int swaps;
		int i = 0;

		for (Tune track : soundData) {
			data[i] = track;
			i++;
		}

		do { // Bubble sort
			swaps = 0;
			for (int index = 0; index < data.length - 1; index++) {
				if ((data[index].getPlayCount()) < (data[index + 1].getPlayCount()) && !ascending
						|| (data[index].getPlayCount()) > (data[index + 1].getPlayCount()) && ascending) {
					Tune temp = data[index];
					data[index] = data[index + 1];
					data[index + 1] = temp;
					swaps++;
				}
			}
		} while (swaps > 0);

		System.out.println("\nTop 10 Tunes");
		System.out.println("------------");

		String str = "";

		if (data != null && data.length > 0) {

			for (int index = 0; index <= 9 && index < data.length; index++) {

				str += "\n" + (index + 1) + ". " + data[index].getTitle() + ", played " + data[index].getPlayCount()
						+ " time(s)\n";

			}

			return str;

		}

		System.out.println("No data to display.");
		return null;

	}
}
