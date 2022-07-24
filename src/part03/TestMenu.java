package part03;

import part01.Menu;

/**
 * Tester class for Genre enumeration class
 * 
 * @author ryanbeattie 40324568
 *
 */

public class TestMenu {

	public static void main(String[] args) {
		test13(); // Menu invalid data
	}

	public static void test13() {
		// Test Id: TC13
		// This method tests the behaviour of the Menu class following changes made to prevent invalid data
		// from being input.

		System.out.println("\n***** Test Case TC13 - Testing Menu class with invalid data *****");
		
		System.out.println("\nOutput: ");
		
		String options[] = { "Add a Tune", "Edit Cost Per Play", "View Tunes", "Quit" };
		Menu myMenu = new Menu("\nJukebox Menu", options);
		boolean finished = false;

		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("\nNot a valid option.");
				break;
			}
		} while (finished);

		System.out.println("\n***** Test Case TC13 - End of Test Method *****");
	}

}
