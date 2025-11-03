import java.util.*;

public class StudentMarksMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a HashMap to store studentName → marks
        HashMap<String, Integer> studentMarks = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Add entries to HashMap
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline

            studentMarks.put(name, marks);
        }

        // Display all entries
        System.out.println("\nStudent Marks List:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }

        // Check if a student exists
        System.out.print("\nEnter a student name to search: ");
        String searchName = sc.nextLine();

        if (studentMarks.containsKey(searchName)) {
            System.out.println(searchName + "'s marks: " + studentMarks.get(searchName));
        } else {
            System.out.println(searchName + " not found in records.");
        }

        sc.close();
    }
}
