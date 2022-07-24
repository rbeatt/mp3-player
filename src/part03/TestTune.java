package part03;

import part01.Tune;
import part01.Genre;

/**
 * Tester class for Tune
 * 
 * @author ryanbeattie 40324568
 *
 */

public class TestTune {

	// Common test data

	static String title = "One";
	static String artist = "U2";
	static int duration = 120;
	static Genre style = Genre.POP;

	public static void main(String[] args) {
		test1(); // toString()
		test2(); // play()
		test3(); // getTitle()
		test4(); // getArtist()
		test5(); // getDuration()
		test6(); // getStyle()
		test7(); // getId()
		test8(); // getPlayCount()
		test9(); // Tune() valid data
		test10(); // Tune() invalid data
		test11(); // nextId
		test14(); // Tune() empty Strings

	}

	public static void test1() {
		// Test Id: TC1
		// This method tests the behaviour of the toString() method

		Tune t1 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC1 - Testing toString() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());
		String result = t1.toString();
		System.out.println("Output: " + result);
		System.out.println("***** Test Case TC1 - End of Test Method *****");
	}

	public static void test2() {
		// Test Id: TC2
		// This method tests the behaviour of the play() method

		Tune t2 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC2 - Testing play() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());
		String result = t2.play();
		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC2 - End of Test Method *****");

	}


	public static void test3() {
		// Test Id: TC3
		// This method tests the accessor method getTitle()

		Tune t3 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC3 - Testing getTitle() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nExpected result: " + title);

		String result = t3.getTitle();

		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC3 - End of Test Method *****");
	}

	public static void test4() {
		// Test Id: TC4
		// This method tests the accessor method getArtist()

		Tune t4 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC4 - Testing getArtist() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nExpected result: " + artist);

		String result = t4.getArtist();

		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC4 - End of Test Method *****");

	}

	public static void test5() {
		// Test Id: TC5
		// This method tests the acccessor method getDuration()

		Tune t5 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC5 - Testing getDuration() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nExpected result: " + duration);

		int result = t5.getDuration();

		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC5 - End of Test Method *****");

	}


	public static void test6() {
		// Test Id : TC6
		// This method tests the accessor method getStyle()

		Tune t6 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC6 - Testing getStyle() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nExpected result: " + style);

		String result = t6.getStyle();

		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC6 - End of Test Method *****");

	}

	public static void test7() {
		// Test Id: TC7
		// This method tests the accessor method getId()

		Tune t7 = new Tune(title, artist, duration, style);

		int id = 7;

		System.out.println("\n***** Test Case TC7 - Testing getId() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		System.out.println("\nExpected result: " + id);

		int result = t7.getId();

		System.out.println("Output: " + result);
		System.out.println("\n***** Test Case TC7 - End of Test Method *****");

	}

	public static void test8() {
		// Test Id: TC8
		// This method tests the accessor method getPlayCount()

		Tune t8 = new Tune(title, artist, duration, style);

		System.out.println("\n***** Test Case TC8 - Testing getPlayCount() *****");
		System.out.println("\nInput test data - Title: " + title + ", Artist: " + artist + ", Duration: " + duration
				+ ", Style: " + style.toString());

		int expectedCount = 2;

		System.out.println("\nExpected result: " + expectedCount);

		System.out.println(t8.play());
		System.out.println(t8.play());

		int result = t8.getPlayCount();

		System.out.println("\nOutput: " + result);
		System.out.println("\n***** Test Case TC8 - End of Test Method *****");
	}

	public static void test9() {
		// Test Id: TC9
		// This method tests the Tune() constructor method for valid data

		try {

			String testTitle = "Baby";
			String testArtist = "Justin Bieber";
			int testDuration = 120;
			Genre testStyle = Genre.POP;

			System.out.println("\n***** Test Case TC9 - Testing Tune() for valid data *****");
			System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
					+ testDuration + ", Style: " + testStyle);

			System.out.println("\nOutput: ");

			Tune t9 = new Tune(testTitle, testArtist, testDuration, testStyle);

			if (t9.getId() != 0) {
				System.out.println("\nTune object created successfully.");
			}

			System.out.println("\n***** Test Case TC9 - End of Test Method *****");

		} catch (Exception e) {
			System.out.println("\nTest failed - exception caught");
			e.printStackTrace();
		}

	}

	public static void test10() {
		// Test Id: TC10
		// This method tests the Tune() constructor method for invalid data

		try {

			// Test data

			String testTitle = null;
			String testArtist = null;
			int testDuration = 0;
			Genre testStyle = null;

			System.out.println("\n***** Test Case TC10 - Testing Tune() for invalid data *****");
			System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
					+ testDuration + ", Style: " + testStyle);

			System.out.println("\nOutput: ");

			Tune t10 = new Tune(testTitle, testArtist, testDuration, testStyle);

			if (t10.getId() != 0) {
				System.out.println("\nTune object created successfully.");
			}

			System.out.println("\n***** Test Case TC10 - End of Test Method *****");

		} catch (Exception e) {
			System.out.println("\nTest failed - exception caught");
			e.printStackTrace();
		}

	}

	public static void test11() {
		// Test Id: TC11
		// This method tests nextId in the Tune() constructor method. It should
		// increment each time a new Tune object is added.

		System.out.println("\n***** Test Case TC11 - Testing nextId *****");

		String testTitle = "Shoot To Thrill";
		String testArtist = "ACDC";
		int testDuration = 160;
		Genre testStyle = Genre.ROCK;

		Tune t11 = new Tune(title, artist, duration, style);
		Tune testTune = new Tune(testTitle, testArtist, testDuration, testStyle);

		System.out.println("\nInput test data: " + t11.toString() + "\n" + testTune.toString());

		System.out.println(t11.getTitle() + ", " + t11.getId());
		System.out.println(testTune.getTitle() + ", " + testTune.getId());

		if (testTune.getId() > t11.getId()) {
			System.out.println("\nTest successful - Id increments");
		} else {
			System.out.println("\nTest failed - Id does not increment");
		}

		System.out.println("\n***** Test Case TC11 - End of Test Method *****");

	}
	
	public static void test14() {
		// Test Id: TC14
		// This method tests the Tune() constructor using empty Strings for title and artist
		
		try {

			// Test data

			String testTitle = "";
			String testArtist = "";
			int testDuration = 120;
			Genre testStyle = Genre.OTHER;

			System.out.println("\n***** Test Case TC14 - Testing Tune() with empty Strings *****");
			System.out.println("\nInput test data - Title: " + testTitle + ", Artist: " + testArtist + ", Duration: "
					+ testDuration + ", Style: " + testStyle);

			System.out.println("\nOutput: ");

			Tune t10 = new Tune(testTitle, testArtist, testDuration, testStyle);

			if (t10.getId() != 0) {
				System.out.println("\nTune object created successfully.");
			}

			System.out.println("\n***** Test Case TC14 - End of Test Method *****");

		} catch (Exception e) {
			System.out.println("\nTest failed - exception caught");
			e.printStackTrace();
		}

	}

}
