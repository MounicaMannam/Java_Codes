import java.io.*;
import java.util.*;

public class AppendToFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt"; // Same file used in previous example

        try {
            // Open file in append mode (true = append)
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            System.out.print("Enter number of lines to append: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter " + n + " new lines to append:");
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                writer.write(line);
                writer.newLine();
            }

            writer.close(); // Always close writer
            System.out.println("\nNew data appended to " + fileName + " successfully!");

            // Read updated file content
            System.out.println("\nUpdated file contents:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
