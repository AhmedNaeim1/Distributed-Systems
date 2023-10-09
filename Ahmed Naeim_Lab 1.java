import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Question 1
abstract class Shape {
    abstract double calculateArea();

    abstract double calculatePerimeter();
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1: Testing Shape classes");
        Rectangle rectangle = new Rectangle(5, 4);
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        System.out.println("Triangle Area: " + triangle.calculateArea());
        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());

        System.out.println("\nTask 2: Testing file reading");
        try {
            readFile("naeim.txt");
        } catch (IOException e) {
            System.out.println("File not found or error reading the file: " + e.getMessage());
        }

        System.out.println("\nTask 3: Testing vowel checking");
        try {
            checkForVowels("Hello, World!");
        } catch (Exception e) {
            System.out.println("No vowels found in the input string: " + e.getMessage());
        }
    }

    // Question 2
    static void readFile(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    // Question 3
    static void checkForVowels(String input) throws Exception {
        if (!input.matches(".*[AEIOUaeiou].*")) {
            throw new Exception("No vowels found in the input string.");
        } else {
            System.out.println("Vowels have been found");
        }
    }
}
