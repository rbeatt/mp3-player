package part03;

import part01.Genre;

/**
 * Tester class for Genre enumeration class
 * 
 * @author ryanbeattie 40324568
 *
 */

public class TestGenre {

	public static void main(String[] args) {
		test12(); // toString() Genre
	}

	public static void test12() {
		// Test Id: TC12
		// This method tests the behaviour of toString() in the Genre enumeration class.

		System.out.println("\n***** Test Case TC12 - Testing toString() in Genre Enumeration *****");

		System.out.println("\nOutput for Genre.ROCK: " + Genre.ROCK.toString());
		System.out.println("\nOutput for Genre.POP: " + Genre.POP.toString());
		System.out.println("\nOutput for Genre.DANCE: " + Genre.DANCE.toString());
		System.out.println("\nOutput for Genre.JAZZ: " + Genre.JAZZ.toString());
		System.out.println("\nOutput for Genre.CLASSICAL: " + Genre.CLASSICAL.toString());
		System.out.println("\nOutput for Genre.OTHER: " + Genre.OTHER.toString());

		System.out.println("\n***** Test Case TC12 - End of Test Method *****");
	}

}
