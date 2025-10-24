import java.util.Scanner;

class Shape {
    double length;
    double breadth;

    // Method to calculate area
    double area() {
        return length * breadth;
    }

    // Method to calculate perimeter
    double perimeter() {
        return 2 * (length + breadth);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape rectangle = new Shape();

        System.out.print("Enter length: ");
        rectangle.length = sc.nextDouble();

        System.out.print("Enter breadth: ");
        rectangle.breadth = sc.nextDouble();

        System.out.println("\nArea of Rectangle: " + rectangle.area());
        System.out.println("Perimeter of Rectangle: " + rectangle.perimeter());

        sc.close();
    }
}
