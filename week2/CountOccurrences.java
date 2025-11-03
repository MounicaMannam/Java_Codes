import java.util.*;

public class CountOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a list to store input elements
        ArrayList<String> elements = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Take input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            elements.add(sc.nextLine());
        }

        // Create a HashMap to store frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String item : elements) {
            // If item already exists, increment count; else add it with count 1
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }

        // Display frequency of each element
        System.out.println("\nElement Frequencies:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}
