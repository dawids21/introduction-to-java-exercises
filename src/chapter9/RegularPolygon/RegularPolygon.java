package chapter9.RegularPolygon;

class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    RegularPolygon() {

    }

    RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    int getN() {
        return n;
    }

    void setN(int n) {
        this.n = n;
    }

    double getSide() {
        return side;
    }

    void setSide(double side) {
        this.side = side;
    }

    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }

    double getPerimeter() {
        return (n * side);
    }

    double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}