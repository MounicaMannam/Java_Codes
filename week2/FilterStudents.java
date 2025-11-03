import java.util.*;

public class FilterStudents {
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

        // Display all students
        System.out.println("\nAll Students:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Filter and display students with marks > 50
        System.out.println("\nStudents with marks > 50:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            if (entry.getValue() > 50) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        sc.close();
    }
}
