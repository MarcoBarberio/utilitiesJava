package utilities;

import java.io.*;

/**
 * Utility class for file management. Provides methods to check the existence of
 * files and directories, determine whether a path corresponds to a file or a
 * directory, check if a directory is empty, and create a new directory if it
 * doesn't already exist.
 */
public class FileUtilities {

	/**
	 * Checks if a file exists.
	 *
	 * @param filePath Path of the file to check.
	 * @return True if the file exists, otherwise false.
	 */
	public static boolean exists(String filePath) {
		return (new File(filePath)).exists();
	}

	/**
	 * Checks if the specified path corresponds to an existing directory.
	 *
	 * @param directoryPath Path of the directory to check.
	 * @return True if the path is an existing directory, otherwise false.
	 */
	public static boolean isDirectory(String directoryPath) {
		if (exists(directoryPath))
			return (new File(directoryPath)).isDirectory();
		return false;
	}

	/**
	 * Checks if the specified path corresponds to an existing file.
	 *
	 * @param filePath Path of the file to check.
	 * @return True if the path is an existing file, otherwise false.
	 */
	public static boolean isFile(String filePath) {
		if (exists(filePath))
			return (new File(filePath)).isFile();
		return false;
	}

	/**
	 * Checks if a directory is empty.
	 *
	 * @param directoryPath Path of the directory to check.
	 * @return True if the directory is empty or does not exist, otherwise false.
	 */
	public static boolean directoryIsEmpty(String directoryPath) {
		if (isDirectory(directoryPath)) {
			File file = new File(directoryPath);
			String[] files = file.list();
			return (files == null || files.length == 0);
		}
		return false;
	}

	/**
	 * Creates a new directory if it doesn't already exist.
	 *
	 * @param newDirectoryPath Path of the new directory to create.
	 */
	public static void createDirectory(String newDirectoryPath) {
		if (!exists(newDirectoryPath))
			new File(newDirectoryPath).mkdir();
	}

	/**
	 * Gets the extension of a file.
	 *
	 * @param filePath Path of the file to get the extension from.
	 * @return The file extension, or an empty string if it's a directory or not a
	 *         file.
	 */
	public static String getExtension(String filePath) {
		if (isDirectory(filePath)) {
			System.out.println("Error: The file is a directory");
			return "";
		}
		if (!isFile(filePath)) {
			System.out.println("Error: It is not a file");
		}
		String[] words = filePath.split("\\.");
		return "." + words[words.length - 1];
	}

	/**
	 * Checks if a file is compressed with Gzip.
	 *
	 * @param filePath Path of the file to check.
	 * @return True if the file has a ".gz" extension, indicating Gzip compression.
	 */
	public static boolean isCompressedWithGzip(String filePath) {
		return getExtension(filePath).equals(".gz");
	}

	/**
	 * Checks if a file is a text file.
	 *
	 * @param filePath Path of the file to check.
	 * @return True if the file has a ".txt" extension, indicating a text file.
	 */
	public static boolean isTextFile(String filePath) {
		return getExtension(filePath).equals(".txt");
	}

	/**
	 * Checks if a file is a binary file.
	 *
	 * @param filePath Path of the file to check.
	 * @return True if the file has a ".dat" extension, indicating a binary file.
	 */
	public static boolean isBinaryFile(String filePath) {
		return getExtension(filePath).equals(".dat");
	}

	/**
	 * Reads the content of a text file.
	 *
	 * @param inputFilePath Path of the text file to read.
	 * @return The content of the text file, or an empty string if there's an error.
	 */
	public static String readFromTextFile(String inputFilePath) {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
			String result = "";
			String tmp;
			try {
				while ((tmp = inputReader.readLine()) != null) {
					result += tmp+"\n";
				}
				inputReader.close();
				return result;
			} catch (IOException e) {
				System.out.println("IO exception");
				return "";
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't read from file. It doesn't exist");
			return "";
		}
	}

	/**
	 * Overloaded method to read from a text file using a File object.
	 *
	 * @param inputFile File object representing the text file to read.
	 * @return The content of the text file, or an empty string if there's an error.
	 */
	public static String readFromTextFile(File inputFile) {
		return readFromTextFile(inputFile.getAbsolutePath());
	}

	/**
	 * Writes text to a text file.
	 *
	 * @param outputFilePath Path of the text file to write.
	 * @param textToWrite    Text to write to the file.
	 */
	public static void writeToTextFile(String outputFilePath, String textToWrite) {
		try {
			BufferedWriter outputStream = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(outputFilePath)));
			try {
				outputStream.write(textToWrite);
				outputStream.close();
			} catch (IOException e) {
				System.out.println("IO exception");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't read from file. It doesn't exist");
		} catch (SecurityException e) {
			System.out.println("Can't access to the file");
		}
	}

	/**
	 * Overloaded method to write to a text file using a File object.
	 *
	 * @param outputFile  File object representing the text file to write.
	 * @param textToWrite Text to write to the file.
	 */
	public static void writeToTextFile(File outputFile, String textToWrite) {
		writeToTextFile(outputFile.getAbsolutePath(), textToWrite);
	}

	/**
	 * Reads the content of a binary file.
	 *
	 * @param inputFilePath Path of the binary file to read.
	 * @return The content of the binary file, or null if there's an error.
	 */
	public static byte[] readFromFile(String inputFilePath) {
		try {
			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFilePath));
			byte[] result = new byte[inputStream.available()];
			result = inputStream.readAllBytes();
			inputStream.close();
			return result;

		} catch (IOException e) {
			System.out.println("IO exception");
		}
		return null;
	}

	/**
	 * Overloaded method to read from a binary file using a File object.
	 *
	 * @param inputFile File object representing the binary file to read.
	 * @return The content of the binary file, or null if there's an error.
	 */
	public static byte[] readFromFile(File inputFile) {
		return readFromFile(inputFile.getAbsolutePath());
	}

	/**
	 * Writes data to a binary file.
	 *
	 * @param outputFilePath Path of the binary file to write.
	 * @param data           Data to write to the file.
	 */
	public static void writeToFile(String outputFilePath, byte[] data) {
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath));
			outputStream.write(data);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}

	/**
	 * Overloaded method to write to a binary file using a File object.
	 *
	 * @param outputFile File object representing the binary file to write.
	 * @param data       Data to write to the file.
	 */
	public static void writeToFile(File outputFile, byte[] data) {
		writeToFile(outputFile.getAbsoluteFile(), data);
	}

	/**
	 * Duplicates the content of a text file to another file.
	 *
	 * @param inputFilePath  Path of the source text file.
	 * @param outputFilePath Path of the destination text file.
	 */
	public static void duplicateTextFile(String inputFilePath, String outputFilePath) {
		writeToTextFile(outputFilePath, readFromTextFile(inputFilePath));
	}

	/**
	 * Overloaded method to duplicate a text file using File objects.
	 *
	 * @param inputFile  File object representing the source text file.
	 * @param outputFile File object representing the destination text file.
	 */
	public static void duplicateTextFile(File inputFile, File outputFile) {
		duplicateTextFile(inputFile.getAbsoluteFile(), outputFile.getAbsoluteFile());
	}

	/**
	 * Duplicates the content of a binary file to another file.
	 *
	 * @param inputFilePath  Path of the source file.
	 * @param outputFilePath Path of the destination file.
	 */
	public static void duplicateFile(String inputFilePath, String outputFilePath) {
		writeToFile(outputFilePath, readFromFile(inputFilePath));
	}

	/**
	 * Overloaded method to duplicate a binary file using File objects.
	 *
	 * @param inputFile  File object representing the source file.
	 * @param outputFile File object representing the destination file.
	 */
	public static void duplicateFile(File inputFile, File outputFile) {
		duplicateFile(inputFile.getAbsoluteFile(), outputFile.getAbsoluteFile());
	}

	/**
	 * Counts the number of lines in a text file.
	 *
	 * @param inputFilePath Path of the text file to count lines from.
	 * @return The number of lines in the text file, or -1 if there's an error.
	 */
	public static int countLines(String inputFilePath) {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
			int count = 0;
			while ((inputReader.readLine()) != null) {
				count++;
			}
			inputReader.close();
			return count;
		} catch (IOException e) {
			System.out.println("IOException");
			return -1;
		}
	}

	/**
	 * Overloaded method to count lines in a text file using a File object.
	 *
	 * @param inputFile File object representing the text file to count lines from.
	 * @return The number of lines in the text file, or -1 if there's an error.
	 */
	public static int countLines(File inputFile) {
		return countLines(inputFile.getAbsolutePath());
	}
}
