import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ArrayList
        ArrayList<String> items = new ArrayList<>();

        // Get number of elements from user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input elements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            items.add(element);
        }

        System.out.println("\nOriginal List: " + items);

        // Sets for unique and duplicate detection
        HashSet<String> unique = new HashSet<>();
        HashSet<String> duplicates = new HashSet<>();

        for (String item : items) {
            if (!unique.add(item)) {
                duplicates.add(item);
            }
        }

        // Display results
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate elements found!");
        } else {
            System.out.println("Duplicate Elements: " + duplicates);
        }

        sc.close();
    }
}
