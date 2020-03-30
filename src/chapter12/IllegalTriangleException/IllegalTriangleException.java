package chapter12.IllegalTriangleException;

public class IllegalTriangleException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalTriangleException() {
        super("Each side must be shorter than sum ot two others");
    }
}