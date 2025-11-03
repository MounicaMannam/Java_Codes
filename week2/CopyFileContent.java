import java.io.*;

public class CopyFileContent {
    public static void main(String[] args) {
        String sourceFile = "sample.txt";
        String destinationFile = "destination.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // To preserve line breaks
            }

            System.out.println("File content copied successfully from " + sourceFile + " to " + destinationFile);
        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
