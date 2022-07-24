package part03;

import part01.Genre;
import part01.MP3Player;

/**
 * Tester class for MP3Player
 * 
 * @author ryanbeattie 40324568
 *
 */

public class TestMP3Player {

	// Common test data

	static String title = "One";
	static String artist = "U2";
	static int duration = 120;
	static Genre style = Genre.POP;
	static MP3Player player = new MP3Player();

	public static void main(String[] args) {
		player.addTune(title, artist, duration, style);
		test1(); // playTune() Id that exists
		test2(); // playTune() Id that doesn't exist
		test3(); // getTuneInfo()
		test4(); // getTuneInfo() with an empty ArrayList
		test5(); // getTuneInfo(artist) Artist that exists
		test6(); // getTuneInfo(artist) Artist that doesn't exist
		test7(); // addTune() valid data
		test8(); // addTune() Tune that exists
		test9(); // addTune() all instance variables invalid
		test10(); // addTune() invalid artist
		test11(); // addTune() invalid title
		test12(); // getTopTen()
		test13(); // getTopTen() empty ArrayList
		test14(); // addTune() invalid duration
		test15(); // addTune() invalid style
		test16(); // getTuneInfo(artist) empty ArrayList
	}

	public static void test1() {
		// Test Id: TC1
		// This method tests the behaviour of the playTune() method using an Id that
		// exists

		System.out.println("\n***** Test Case TC1 - Testing playTune() for an Id that exists *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		int testId = 1;

		String result = player.playTune(testId);
		System.out.println("\nOutput: " + result);
		System.out.println("\n***** Test Case TC1 - End of Test Method *****");
	}

	public static void test2() {
		// Test Id: TC2
		// This method tests the behaviour of the playTune() method using an Id that
		// doesn't exist

		System.out.println("\n***** Test Case TC2 - Testing playTune() using an Id that doesn't exist *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		int testId = 0; // All Tune objects have an Id greater than 0

		System.out.println("\nOutput: ");
		if (player.playTune(testId) == null) {
			System.out.println("Test successful - null value returned");
		}
		System.out.println("\n***** Test Case TC2 - End of Test Method *****");
	}

	public static void test3() {
		// Test Id: TC3
		// This method tests the behaviour of the getTuneInfo() method

		System.out.println("\n***** Test Case TC3 - Testing getTuneInfo() *****");

		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nOutput: ");
		String[] details = player.getTuneInfo();
		for (String str : details) {
			System.out.println("\n" + str);
		}

		System.out.println("\n***** Test Case TC3 - End of Test Method *****");
	}

	public static void test4() {
		// Test Id: TC4
		// This method tests the behaviour of the getTuneInfo() method with an empty
		// ArrayList

		System.out.println("\n***** Test Case TC4 - Testing getTuneInfo() with an empty ArrayList *****");
		MP3Player test = new MP3Player();

		System.out.println("\nOutput: ");

		if (test.getTuneInfo() == null) {
			System.out.println("\nTest successful - null value returned");
		} else {
			System.out.println("\nTest unsuccessful - null value not returned");
		}

		System.out.println("\n***** Test Case TC4 - End of Test Method *****");

	}

	public static void test5() {
		// Test Id: TC5
		// This method tests the behaviour of the getTuneInfo(artist) method using an
		// artist that exists

		System.out.println("\n***** Test Case TC5 - Testing getTuneInfo(artist) using an artist that exists *****");

		String testArtist = "U2";
		String testTitle = "Beautiful Day";
		int testDuration = 180;
		Genre testGenre = Genre.POP;

		player.addTune(testTitle, testArtist, testDuration, testGenre); // Adding a second tune to test sorting

		System.out.println("\nInput test data: " + testArtist);

		System.out.println("\nOutput: ");
		String[] details = player.getTuneInfo(testArtist);

		for (String str : details) {
			System.out.println("\n" + str);
		}

		System.out.println("\n***** Test Case TC5 - End of Test Method *****");

	}

	public static void test6() {
		// Test Id: TC6
		// This method tests the behaviour of the getTuneInfo(artist) method using an
		// artist that doesn't exist

		System.out.println(
				"\n***** Test Case TC6 - Testing getTuneInfo(artist) using an artist that doesn't exist *****");

		String testArtist = "One Direction";

		System.out.println("\nInput test data: " + testArtist);

		System.out.println("\nOutput: ");
		String[] details = player.getTuneInfo(testArtist);

		if (details == null) {
			System.out.println("\nTest successful - null value returned.");
		} else {

			for (String str : details) {
				System.out.println("\n" + str);
			}
			System.out.println("\nTest unsuccessful - null value not returned.");
		}

		System.out.println("\n***** Test Case TC6 - End of Test Method *****");
	}

	public static void test7() {
		// Test Id: TC7
		// This method tests the behaviour of the addTune() method for valid data

		System.out.println("\n***** Test Case TC7 - Testing addTune() for valid data *****");

		String testTitle = "Back In Black";
		String testArtist = "ACDC";
		int testDuration = 100;
		Genre testStyle = Genre.ROCK;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle.toString());

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune is added: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - Tune not added");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC7 - End of Test Method *****");
	}

	public static void test8() {
		// Test Id: TC8
		// This method tests the behaviour of the addTune() method if the Tune already
		// exists (same Title/Artist)

		System.out.println("\n***** Test Case TC8 - Testing addTune() for a Tune that already exists *****");

		String testTitle = "Back In Black";
		String testArtist = "ACDC";
		int testDuration = 100;
		Genre testStyle = Genre.ROCK;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle.toString());

		System.out.println("\nOutput: ");

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune isn't added twice: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - Tune not added");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC8 - End of Test Method *****");
	}

	public static void test9() {
		// Test Id: TC9
		// This method tests the behaviour of the addTune() method when all instance
		// variables are invalid

		System.out.println("\n***** Test Case TC9 - Testing addTune() when all instance variables are invalid *****");

		System.out.println("\nOutput: ");

		try {
			if (player.addTune(null, null, 0, null) == false) {

				System.out.println("\nOutput from getTuneInfo() to check Tune isn't added with null values: ");
				String[] details = player.getTuneInfo();

				for (String str : details) {
					System.out.println("\n" + str);
				}

			} else {
				System.out.println("\nTest failed - true returned");
			}

		} catch (Exception e) {
			System.out.println("\nTest failed - exception caught");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC9 - End of Test Method *****");
	}

	public static void test10() {
		// Test Id: TC10
		// This method tests the behaviour of the addTune() method when artist instance
		// variable is invalid

		System.out.println("\n***** Test Case TC10 - Testing addTune() when artist instance variable is invalid *****");
		String testTitle = "Shoot To Thrill";
		String testArtist = "";
		int testDuration = 120;
		Genre testStyle = Genre.ROCK;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle.toString());

		System.out.println("\nOutput: ");

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune isn't added with null values: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - exception caught");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC10 - End of Test Method *****");
	}

	public static void test11() {
		// Test Id: TC11
		// This method tests the behaviour of the addTune() method when title instance
		// variable is invalid

		System.out.println("\n***** Test Case TC11 - Testing addTune() when title instance variable is invalid *****");
		String testTitle = "";
		String testArtist = "One Direction";
		int testDuration = 120;
		Genre testStyle = Genre.ROCK;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle.toString());

		System.out.println("\nOutput: ");

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune isn't added with null values: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - exception caught");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC11 - End of Test Method *****");
	}

	public static void test12() {
		// Test Id: TC12
		// This method tests the behaviour of the getTopTen() method

		System.out.println("\n***** Test Case TC12 - Testing getTopTen() *****");
		System.out.println("\nPlay tunes to increment playCount: ");
		player.playTune(1);
		player.playTune(1);
		player.playTune(1);
		player.playTune(2);

		System.out.println("Output: ");
		System.out.println(player.getTopTen()); // Displays additional play from a previous test - can be ignored
		System.out.println("\n***** Test Case TC12 - End of Test Method *****");

	}

	public static void test13() {
		// Test Id: TC13
		// This method tests the behaviour of the getTopTen() method with an empty
		// ArrayList

		MP3Player testPlayer = new MP3Player();

		System.out.println("\n***** Test Case TC13 - Testing getTopTen() with an empty ArrayList *****");

		System.out.println("Output: ");
		if (testPlayer.getTopTen() == null) {
			System.out.println("Test successful - null returned");
		} else {
			System.out.println("Test unsuccessful - null not returned");
		}
		System.out.println("\n***** Test Case TC13 - End of Test Method *****");
	}

	public static void test14() {
		// Test Id: TC14
		// This method tests the behaviour of the addTune() method when duration
		// instance
		// variable is invalid

		System.out
				.println("\n***** Test Case TC14 - Testing addTune() when duration instance variable is invalid *****");
		String testTitle = "Steal My Girl";
		String testArtist = "One Direction";
		int testDuration = 0;
		Genre testStyle = Genre.ROCK;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle.toString());

		System.out.println("\nOutput: ");

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune isn't added with null values: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - exception caught");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC14 - End of Test Method *****");
	}

	public static void test15() {
		// Test Id: TC15
		// This method tests the behaviour of the addTune() method when style instance
		// variable is invalid

		System.out.println("\n***** Test Case TC15 - Testing addTune() when style instance variable is invalid *****");
		String testTitle = "Steal My Girl";
		String testArtist = "One Direction";
		int testDuration = 120;
		Genre testStyle = null;

		System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
				+ testDuration + ", Style: " + testStyle);

		System.out.println("\nOutput: ");

		try {
			player.addTune(testTitle, testArtist, testDuration, testStyle);
			System.out.println("\nOutput from getTuneInfo() to check Tune isn't added with null values: ");
			String[] details = player.getTuneInfo();

			for (String str : details) {
				System.out.println("\n" + str);
			}

		} catch (Exception e) {
			System.out.println("Test failed - exception caught");
			e.printStackTrace();
		}

		System.out.println("\n***** Test Case TC15 - End of Test Method *****");

	}

	public static void test16() {
		// Test Id: TC16
		// This method tests the behaviour of the getTuneInfo(artist) method with an
		// empty ArrayList

		System.out.println("\n***** Test Case TC16 - Testing getTuneInfo(artist) with an empty ArrayList *****");

		String testArtist = "One Direction";

		MP3Player test = new MP3Player();

		System.out.println("\nInput test data: " + testArtist);

		System.out.println("\nOutput: ");
		String[] details = test.getTuneInfo(testArtist);

		if (details == null) {
			System.out.println("\nTest successful - null value returned.");
		} else {

			for (String str : details) {
				System.out.println("\n" + str);
			}
			System.out.println("\nTest unsuccessful - null value not returned.");
		}

		System.out.println("\n***** Test Case TC16 - End of Test Method *****");

	}

}
