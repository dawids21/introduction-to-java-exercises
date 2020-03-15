package chapter9.Rectangle;

class Rectangle {
    double width = 1;
    double height = 1;

    Rectangle() {

    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return (width * height);
    }

    double getPerimeter() {
        return (2 * width + 2 * height);
    }
}