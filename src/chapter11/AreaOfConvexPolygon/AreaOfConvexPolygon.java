package chapter11.AreaOfConvexPolygon;

import java.util.ArrayList;
import java.util.Scanner;

import chapter10.MyPoint.MyPoint;

public class AreaOfConvexPolygon {
    public static void main(String[] args) {
        ArrayList<MyPoint> points = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();
        System.out.println("Enter the coordinates of the points: ");
        for (int i = 0; i < numberOfPoints; i++) {
            double x = input.nextDouble();
            double y = input.nextDouble();
            points.add(new MyPoint(x, y));
        }
        input.close();
        double area = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            area += (points.get(i).getX() * points.get(i + 1).getY());
            area -= (points.get(i).getY() * points.get(i + 1).getX());
        }
        area += (points.get(points.size() - 1).getX() * points.get(0).getY());
        area -= (points.get(points.size() - 1).getY() * points.get(0).getX());
        area /= 2.0;
        area = Math.abs(area);
        System.out.format("The total area is %.3f\n", area);
    }
}