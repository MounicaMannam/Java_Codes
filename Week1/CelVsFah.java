import java.util.Scanner;

public class CelVsFah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Formula: F = (C × 9/5) + 32
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}

