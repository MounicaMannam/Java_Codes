import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        int sum = 0;

        // Calculate sum of first N even numbers
        for (int i = 1; i <= n; i++) {
            sum += 2 * i;  // 2, 4, 6, 8, ...
        }

        System.out.println("Sum of first " + n + " even numbers is: " + sum);
    }
}
