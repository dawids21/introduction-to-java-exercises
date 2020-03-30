package chapter11.Triangle;

import java.util.Scanner;

import chapter12.IllegalTriangleException.IllegalTriangleException;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sides(3): ");
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = input.nextDouble();
        }
        System.out.print("Enter color of the triangle: ");
        String color = input.next();
        System.out.print("Triangle should be filled? (true/false): ");
        boolean filled = input.nextBoolean();
        input.close();
        Triangle triangle;
        try {
            triangle = new Triangle(sides[0], sides[1], sides[2]);
        } catch (IllegalTriangleException ex) {
            System.out.println(ex.getMessage());
        } finally {
            triangle = new Triangle();
        }
        triangle.setColor(color);
        triangle.setFilled(filled);
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
    }

}