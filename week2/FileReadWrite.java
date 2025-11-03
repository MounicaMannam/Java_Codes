import java.io.*;
import java.util.*;

public class FileReadWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt"; // You can change this to any file name

        try {
            // ------------------------------
            // Step 1: Write to file
            // ------------------------------
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            System.out.print("Enter number of lines to write: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter " + n + " lines:");
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                writer.write(line);
                writer.newLine();
            }

            writer.close(); // Always close writer
            System.out.println("\nData written to " + fileName + " successfully!");

            // ------------------------------
            // Step 2: Read from file
            // ------------------------------
            System.out.println("\nReading contents of " + fileName + ":");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }

            reader.close(); // Always close reader

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
