import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the list
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(23);
        numbers.add(56);

        System.out.println("Original List: " + numbers);

        // Sort in ascending order
        Collections.sort(numbers);
        System.out.println("Sorted List (Ascending): " + numbers);

        // Sort in descending order using Comparator
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted List (Descending): " + numbers);

        // Create another ArrayList of strings
        ArrayList<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Alex");
        names.add("John");
        names.add("Bella");

        System.out.println("\nOriginal Names List: " + names);

        // Sort strings alphabetically
        Collections.sort(names);
        System.out.println("Sorted Names (A-Z): " + names);

        // Sort strings in reverse (Z-A)
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Sorted Names (Z-A): " + names);
    }
}
