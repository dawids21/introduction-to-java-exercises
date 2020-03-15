package chapter9.Rectangle;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle(4, 40);
        rectangles[1] = new Rectangle(3.5, 35.9);
        for (int i = 0; i < 2; i++) {
            System.out.format(  "Rectangle %d\nWidth: %.2f\nHeight: %.2f\nArea: %.2f\nPerimeter: %.2f\n\n",
                                i, rectangles[i].width, rectangles[i].height, rectangles[i].getArea(),
                                rectangles[i].getPerimeter());
        }
    }    
}