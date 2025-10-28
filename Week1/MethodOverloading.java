class Shape {
    // Method to calculate area of a rectangle
    double area(double length, double breadth) {
        System.out.println("Calculating area of rectangle...");
        return length * breadth;
    }

    // Overloaded method to calculate area of a circle
    double area(double radius) {
        System.out.println("Calculating area of circle...");
        return Math.PI * radius * radius;
    }

    // Overloaded method to calculate area of a square
    double area(int side) {
        System.out.println("Calculating area of square...");
        return side * side;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Shape s = new Shape();

        System.out.println("Area of rectangle: " + s.area(5.0, 3.0));
        System.out.println("Area of circle: " + s.area(4.0));
        System.out.println("Area of square: " + s.area(6));
    }
}
