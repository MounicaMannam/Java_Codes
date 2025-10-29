import java.util.*;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> names = new ArrayList<>();

        // Add elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eva");

        System.out.println("Original List: " + names);

        // Remove an element
        names.remove("Charlie");
        System.out.println("After removing 'Charlie': " + names);

        // Filter elements that start with 'A' or 'E'
        System.out.println("\nNames starting with A or E:");
        for (String name : names) {
            if (name.startsWith("A") || name.startsWith("E")) {
                System.out.println(name);
            }
        }

        // Iterate using for-each
        System.out.println("\nIterating using for-each loop:");
        for (String name : names) {
            System.out.println(name);
        }

        // Iterate using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Add more elements
        names.add("Frank");
        names.add("Grace");

        System.out.println("\nFinal List: " + names);
    }
}
