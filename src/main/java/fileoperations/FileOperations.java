package fileoperations;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileOperations {

    public static void main(String[] args) {

        String filePath = "test.txt";
        String directoryPath = "testDirectory";

        try {
            checkFileExists(filePath);
            deleteFile(filePath);
            createDirectory(directoryPath);
            createEmptyFile(directoryPath, "exampleFile.txt");
            listFilesAndDirectories(".");
        } catch (IOException e) {
            System.out.println("Error in File IO");
        }
    }


    /**
     * Method to list all files and directories
     *
     * @param directoryPath
     * @throws IOException
     */
    private static void listFilesAndDirectories(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        String[] filesAndDirs = directory.list();

        System.out.println("Files and Directories in " + directoryPath + ":");
        if (filesAndDirs != null) {
            for(String s:filesAndDirs){
                System.out.println(s);
            }
        }
    }

    /**
     * Method to create file
     *
     * @param directoryPath
     * @param fileName
     * @throws IOException
     */
    private static void createEmptyFile(String directoryPath, String fileName) throws IOException  {
        File file = new File(directoryPath, fileName);
        if (!file.exists()) {
            System.out.println("Creating empty file: " + file.getName());
            file.createNewFile();
        } else {
            System.out.println("File already exists.");
        }
    }

    /**
     * method to create directory
     *
     * @param directoryPath
     */
    private static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Creating directory: " + directory.getName());
            directory.mkdir();
        } else {
            System.out.println("Directory already exists.");
        }
    }


    /**
     * Method to delete file
     *
     * @param filePath
     * @throws IOException
     */
    private static void deleteFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Deleting file: " + file.getName());
            file.delete();
        } else {
            System.out.println("File does not exist.");
        }
    }

    /**
     * Method for checking file exist
     *
     * @param filePath
     * @throws IOException
     */
    private static void checkFileExists(String filePath) throws IOException {
        File file = new File(filePath);
        System.out.println("File exists: " + file.exists());
    }

}
