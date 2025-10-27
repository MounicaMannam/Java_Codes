import java.util.Scanner;

public class NumberUtilityProgram {

    // Method to check Even or Odd
    static void checkEvenOdd(int num) {
        if (num % 2 == 0)
            System.out.println(num + " is Even.");
        else
            System.out.println(num + " is Odd.");
    }

    // Method to find Factorial
    static void findFactorial(int num) {
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is: " + fact);
    }

    // Method to Reverse a number
    static void reverseNumber(int num) {
        int rev = 0, temp = num;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println("Reverse of " + temp + " is: " + rev);
    }

    // Method to check Palindrome
    static void checkPalindrome(int num) {
        int original = num;
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        if (rev == original)
            System.out.println(original + " is a Palindrome.");
        else
            System.out.println(original + " is not a Palindrome.");
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Number Utility Program ---");
            System.out.println("1. Check Even or Odd");
            System.out.println("2. Find Factorial");
            System.out.println("3. Reverse Number");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter a number: ");
                int num = sc.nextInt();

                switch (choice) {
                    case 1:
                        checkEvenOdd(num);
                        break;
                    case 2:
                        findFactorial(num);
                        break;
                    case 3:
                        reverseNumber(num);
                        break;
                    case 4:
                        checkPalindrome(num);
                        break;
                }
            } else if (choice == 5) {
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid choice! Please enter between 1 and 5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
