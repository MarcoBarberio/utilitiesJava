

import java.io.File;

/**
 * Utility class for file management. Provides methods to check the existence
 * of files and directories, determine whether a path corresponds to a file or a directory,
 * check if a directory is empty, and create a new directory if it doesn't already exist.
 */
public class FileUtilities {

    /**
     * Checks if a file exists.
     *
     * @param fileLocation Path of the file to check.
     * @return True if the file exists, otherwise false.
     */
    public static boolean exists(String fileLocation) {
        return new File(fileLocation).exists();
    }

    /**
     * Checks if the specified path corresponds to an existing directory.
     *
     * @param directoryLocation Path of the directory to check.
     * @return True if the path is an existing directory, otherwise false.
     */
    public static boolean isDirectory(String directoryLocation) {
        if (exists(directoryLocation))
            return (new File(directoryLocation)).isDirectory();
        return false;
    }

    /**
     * Checks if the specified path corresponds to an existing file.
     *
     * @param fileLocation Path of the file to check.
     * @return True if the path is an existing file, otherwise false.
     */
    public static boolean isFile(String fileLocation) {
        if (exists(fileLocation))
            return (new File(fileLocation)).isFile();
        return false;
    }

    /**
     * Checks if a directory is empty.
     *
     * @param directoryLocation Path of the directory to check.
     * @return True if the directory is empty or does not exist, otherwise false.
     */
    public static boolean directoryIsEmpty(String directoryLocation) {
        if (isDirectory(directoryLocation)) {
            File file = new File(directoryLocation);
            String[] files = file.list();
            return (files == null || files.length == 0);
        }
        return false;
    }

    /**
     * Creates a new directory if it doesn't already exist.
     *
     * @param newDirectoryLocation Path of the new directory to create.
     */
    public static void createDirectory(String newDirectoryLocation) {
        if (!exists(newDirectoryLocation))
            new File(newDirectoryLocation).mkdir();
    }
}
