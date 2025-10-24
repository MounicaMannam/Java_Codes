class Shape {
    double length;
    double breadth;

    // Default constructor
    Shape() {
        length = 1;
        breadth = 1;
        System.out.println("Default constructor called.");
    }

    // Parameterized constructor (for rectangle)
    Shape(double l, double b) {
        length = l;
        breadth = b;
        System.out.println("Parameterized constructor called for rectangle.");
    }

    // Parameterized constructor (for square)
    Shape(double side) {
        length = side;
        breadth = side;
        System.out.println("Parameterized constructor called for square.");
    }

    // Method to calculate area
    double area() {
        return length * breadth;
    }

    // Method to calculate perimeter
    double perimeter() {
        return 2 * (length + breadth);
    }
}

public class ShapeConstructor {
    public static void main(String[] args) {
        // Using default constructor
        Shape s1 = new Shape();
        System.out.println("Area: " + s1.area());
        System.out.println("Perimeter: " + s1.perimeter());

        // Using rectangle constructor
        Shape s2 = new Shape(5, 3);
        System.out.println("\nArea: " + s2.area());
        System.out.println("Perimeter: " + s2.perimeter());

        // Using square constructor
        Shape s3 = new Shape(4);
        System.out.println("\nArea: " + s3.area());
        System.out.println("Perimeter: " + s3.perimeter());
    }
}
