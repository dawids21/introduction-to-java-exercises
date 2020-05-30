package dawids21;

public class Main {

    private static int numOfCall = 0;

    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println("Number of calls: " + numOfCall);
    }

    private static int fib(int index) {
        numOfCall++;
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        }
        return fib(index - 1) + fib(index - 2);
    }
}
