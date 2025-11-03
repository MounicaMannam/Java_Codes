import java.io.*;

public class CountWordsInFile {
    public static void main(String[] args) {
        String fileName = "sample.txt"; // You can use any existing text file
        int wordCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split line into words based on spaces
                String[] words = line.trim().split("\\s+");
                if (line.trim().length() > 0) {
                    wordCount += words.length;
                }
            }

            reader.close();
            System.out.println("Total number of words in " + fileName + ": " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
