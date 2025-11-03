import java.util.*;

public class IterateMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a HashMap to store studentName -> marks
        HashMap<String, Integer> studentMarks = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Take input for each student
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline

            studentMarks.put(name, marks);
        }

        // -------------------------------
        // Iterating using entrySet()
        // -------------------------------
        System.out.println("\nIteration using entrySet():");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // -------------------------------
        // Iterating using keySet()
        // -------------------------------
        System.out.println("\nIteration using keySet():");
        for (String key : studentMarks.keySet()) {
            Integer value = studentMarks.get(key);
            System.out.println(key + " -> " + value);
        }

        sc.close();
    }
}
