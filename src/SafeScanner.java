

import java.util.*;

/**
 * The SafeScanner class provides utility methods for safely reading user input
 * of various data types from the console, handling potential input errors.
 */
public class SafeScanner {
	private Scanner scanner;

	/**
	 * Constructs a new SafeScanner with the standard input stream (System.in).
	 */
	public SafeScanner() {
		scanner = new Scanner(System.in);
	}

	/**
	 * Safely reads an integer from the console.
	 *
	 * @param s A descriptive string to display to the user as a prompt.
	 * @return The integer entered by the user.
	 */
	public int safeNextInt(String prompt) {
		int n = 0;
		boolean flag;
		do {
			System.out.print(prompt);
			flag = true;
			try {
				n = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Wrong input");
				scanner.nextLine();
				flag = false;
			}
		} while (!flag);
		scanner.nextLine();
		return n;
	}

	/**
	 * Safely reads a boolean value from the console.
	 *
	 * @param s A descriptive string to display to the user as a prompt.
	 * @return The boolean value entered by the user.
	 */
	public boolean safeNextBoolean(String prompt) {
		boolean n = true;
		boolean flag;
		do {
			System.out.print(prompt);
			flag = true;
			try {
				n = scanner.nextBoolean();
			} catch (InputMismatchException e) {
				System.out.print("Wrong input");
				scanner.nextBoolean();
				flag = false;
			}
		} while (!flag);
		return n;
	}

	/**
	 * Safely reads a floating-point number from the console.
	 *
	 * @param s A descriptive string to display to the user as a prompt.
	 * @return The floating-point number entered by the user.
	 */
	public float safeNextFloat(String prompt) {
		float n = 0;
		boolean flag;
		do {
			System.out.print(prompt);
			flag = true;
			try {
				n = scanner.nextFloat();
			} catch (InputMismatchException e) {
				System.out.print("Wrong input");
				scanner.nextFloat();
				flag = false;
			}
		} while (!flag);
		return n;
	}

	/**
	 * Closes the Scanner to release associated resources.
	 */
	public void closeScanner() {
		scanner.close();
	}
}