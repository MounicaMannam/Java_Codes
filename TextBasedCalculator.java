import java.util.Scanner;

public class TextBasedCalculator {

    // Method for Addition
    static void add(double a, double b) {
        System.out.println("Result: " + (a + b));
    }

    // Method for Subtraction
    static void subtract(double a, double b) {
        System.out.println("Result: " + (a - b));
    }

    // Method for Multiplication
    static void multiply(double a, double b) {
        System.out.println("Result: " + (a * b));
    }

    // Method for Division
    static void divide(double a, double b) {
        if (b == 0)
            System.out.println("Error! Division by zero is not allowed.");
        else
            System.out.println("Result: " + (a / b));
    }

    // Method for Power
    static void power(double base, double exp) {
        double result = Math.pow(base, exp);
        System.out.println(base + " raised to " + exp + " is: " + result);
    }

    // Method to Reverse a Number
    static void reverseNumber(int num) {
        int rev = 0, temp = num;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println("Reverse of " + temp + " is: " + rev);
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Text-Based Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Reverse Number");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    double a1 = sc.nextDouble();
                    double b1 = sc.nextDouble();
                    add(a1, b1);
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    double a2 = sc.nextDouble();
                    double b2 = sc.nextDouble();
                    subtract(a2, b2);
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    double a3 = sc.nextDouble();
                    double b3 = sc.nextDouble();
                    multiply(a3, b3);
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    double a4 = sc.nextDouble();
                    double b4 = sc.nextDouble();
                    divide(a4, b4);
                    break;

                case 5:
                    System.out.print("Enter base and exponent: ");
                    double base = sc.nextDouble();
                    double exp = sc.nextDouble();
                    power(base, exp);
                    break;

                case 6:
                    System.out.print("Enter an integer to reverse: ");
                    int num = sc.nextInt();
                    reverseNumber(num);
                    break;

                case 7:
                    System.out.println("Exiting Calculator. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        sc.close();
    }
}
