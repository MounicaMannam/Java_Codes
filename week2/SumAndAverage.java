import java.util.*;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ArrayList to store numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Take input from user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }

        System.out.println("\nNumbers in the list: " + numbers);

        // Calculate sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Calculate average
        double average = (double) sum / numbers.size();

        // Display results
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Average of numbers: " + average);

        sc.close();
    }
}
