package j1.s.p0104;

/**
 *
 * @author ADMIN
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSearch {

    public static void main(String[] args) {
        // 1. User input directory of file
        String filePath = enterFile("Please enter directory of file:");
        // 2. User input string to search
        String searchStr = enterStringToSearch("Please enter string to search:");
        // 3. Find string or letter words that contain the input string
        List<String> searchResults = findStringInFile(filePath, searchStr);
        // 4.Display the search results
        displayResult(searchResults);
    }

    private static String enterFile(String message) {
    Scanner scanner = new Scanner(System.in);
    String filePath = null;
    boolean isValid = false;

    do {
        try {
            System.out.print(message);
            filePath = scanner.nextLine();

            if (filePath == null || filePath.trim().isEmpty()) {
                throw new NullPointerException();
            }

            // Validate if the file exists and is readable
            FileReader fileReader = new FileReader(filePath);
            fileReader.close();

            isValid = true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file");
        } catch (NullPointerException e) {
            System.out.println("No file path entered");
        }
    } while (!isValid);

    return filePath;
}


    private static String enterStringToSearch(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    private static List<String> findStringInFile(String filePath, String searchStr) {
        List<String> results = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchStr)) {
                    results.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file.");
        }

        return results;
    }

    private static void displayResult(List<String> searchResults) {
        System.out.println("Search results:");
        for (String result : searchResults) {
            System.out.println("\t" + result);
        }
    }
}
