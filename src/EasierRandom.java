/**
 * The EasierRandom class provides methods for generating random numbers or random integers within a specified range.
 * It includes both traditional random number generation using java.util.Random and more efficient thread-safe alternatives using ThreadLocalRandom.
 */


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The EasierRandom class provides methods for generating random numbers or
 * random integers within a specified range.
 */
public class EasierRandom {

	// Random instance for generating random values
	private static Random random = new Random();

	/**
	 * Constructor for the EasierRandom class that initializes the Random instance.
	 */
	public EasierRandom() {
	}

	/**
	 * Generates a random digit between 0 and 9 (inclusive).
	 *
	 * @return A random digit between 0 and 9.
	 */
	public static int generateDigit() {
		return Math.abs(random.nextInt() % 10);
	}

	/**
	 * Generates a random number between 1 and 10 (inclusive).
	 *
	 * @return A random number between 1 and 10.
	 */
	public static int generateFromOneToTen() {
		return Math.abs(random.nextInt() % 10) + 1;
	}

	/**
	 * Generates a random number between 0 and the specified upper bound
	 * (inclusive).
	 *
	 * @param n The upper bound for the random number generation.
	 * @return A random number between 0 and n (inclusive).
	 */
	public static int generateFromZeroToN(int n) {
		return Math.abs(random.nextInt() % (n + 1));
	}

	/**
	 * Generates a random number between 1 and the specified upper bound
	 * (inclusive).
	 *
	 * @param n The upper bound for the random number generation.
	 * @return A random number between 1 and n.
	 */
	public static int generateFromOneToN(int n) {
		return Math.abs(random.nextInt() % n) + 1;
	}

	/**
	 * Generates a random digit efficiently using ThreadLocalRandom.
	 *
	 * @return A random digit between 0 and 9.
	 */
	public static int generateDigitThreadEfficient() {
		return ThreadLocalRandom.current().nextInt(0, 10);
	}

	/**
	 * Generates a random number between 1 and 10 efficiently using
	 * ThreadLocalRandom.
	 *
	 * @return A random number between 1 and 10.
	 */
	public static int generateFromOneToTenThreadEfficient() {
		return ThreadLocalRandom.current().nextInt(0, 10) + 1;
	}

	/**
	 * Generates a random number between 0 and the specified upper bound (inclusive)
	 * efficiently using ThreadLocalRandom.
	 *
	 * @param n The upper bound for the random number generation.
	 * @return A random number between 0 and n (inclusive).
	 */
	public static int generateFromZeroToNThreadEfficient(int n) {
		return ThreadLocalRandom.current().nextInt(0, n + 1);
	}

	/**
	 * Generates a random number between 1 and the specified upper bound (inclusive)
	 * efficiently using ThreadLocalRandom.
	 *
	 * @param n The upper bound for the random number generation.
	 * @return A random number between 1 and n.
	 */
	public static int generateFromOneToNThreadEfficient(int n) {
		return ThreadLocalRandom.current().nextInt(0, n) + 1;
	}

	/**
	 * Generates a random number between n (inclusive) and m (inclusive) efficiently
	 * using ThreadLocalRandom.
	 *
	 * @param n The lower bound for the random number generation (inclusive).
	 * @param m The upper bound for the random number generation (inclusive).
	 * @return A random number between n (inclusive) and m (inclusive).
	 */
	public static int generateFromNToMThreadEfficient(int n, int m) {
		return ThreadLocalRandom.current().nextInt(n, m + 1);
	}
}
