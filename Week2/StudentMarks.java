import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int sum = 0;

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        // Initialize min and max
        int max = marks[0];
        int min = marks[0];

        // Find max and min
        for (int i = 1; i < n; i++) {
            if (marks[i] > max)
                max = marks[i];
            if (marks[i] < min)
                min = marks[i];
        }

        double average = (double) sum / n;

        // Display results
        System.out.println("\n----- Student Marks Summary -----");
        System.out.println("Maximum Marks: " + max);
        System.out.println("Minimum Marks: " + min);
        System.out.println("Average Marks: " + average);

        sc.close();
    }
}
