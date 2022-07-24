package part01;

/**
 * This class models a Tune object, also defining some functions.
 * 
 * @author ryanbeattie 40324568
 *
 */

public class Tune implements ITune { // Tune interface
	private int id;
	private static int nextId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playCount;
	private Genre style;

	/**
	 * This is the constructor method for the Tune object. It sets up the title, the
	 * artist, the duration, the style and the id.
	 * 
	 * @param title    - the title of the Tune
	 * @param artist   - the artist of the Tune
	 * @param duration - the duration of the Tune
	 * @param style    - the style, or genre, of the Tune
	 */

	public Tune(String title, String artist, int duration, Genre style) {
		if (title != null && title.isEmpty() != true && artist != null && artist.isEmpty() != true 
				&& duration > 0 && style != null) {
			this.title = title;
			this.artist = artist;
			this.duration = duration;
			this.style = style;
			this.id = nextId;
			nextId++; // Increments each time a new tune is added
		} else {
			System.out.println("Fields cannot be null and duration must be greater than 0.");

		}
	}
	
	// Getters required for toString() and play()

	/**
	 * This method returns the title of the Tune
	 * 
	 * @return - the title of the Tune
	 */

	public String getTitle() {
		return this.title;
	}

	/**
	 * This method returns the artist of the Tune
	 * 
	 * @return - the artist of the Tune
	 */

	public String getArtist() {
		return this.artist;
	}

	/**
	 * This method returns the duration of the Tune
	 * 
	 * @return - the duration (in seconds) of the Tune
	 */

	public int getDuration() {
		return this.duration;
	}

	/**
	 * This method returns the style of the Tune
	 * 
	 * @return - the style of the Tune
	 */

	// Modified accessor for style (style)

	public String getStyle() {
		return this.style.toString();
	}

	/**
	 * This method returns the play count of the Tune
	 * 
	 * @return - the play count of the Tune
	 */

	public int getPlayCount() {
		return this.playCount;
	}

	/**
	 * This method returns the id of the Tune
	 * 
	 * @return - the id of the Tune
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * This method should return a String in the following format: “Now Playing ...
	 * Four Seasons Winter, by Vivaldi” where “Four Seasons Winter” is the title of
	 * a Tune by artist “Vivaldi”
	 * 
	 * @return - a String containing the name and artist of a tune
	 */

	public String play() {
		String str = "";
		str += "\nNow playing ... " + this.getTitle() + ", by " + this.getArtist();
		this.playCount++;
		return str;
	}

	/**
	 * This method returns a formatted String including all details of a Tune in
	 * single line
	 * 
	 * @return - a formatted String including all details of a Tune in a single
	 *         line.
	 */

	public String toString() {
		String str = "";
		str += this.getTitle() + ", " + this.getArtist() + ", " + this.getDuration() + " seconds" + ", "
				+ this.getStyle() + ", " + "id " + this.getId() + ", " + this.getPlayCount() + " play(s)" + '\n';
		return str;

	}

}
