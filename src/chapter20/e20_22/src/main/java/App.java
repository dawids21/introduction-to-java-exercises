import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Write number of disks: ");
        int numOfDisks = input.nextInt();

        Hanoi.hanoi(numOfDisks, 'A', 'C', 'B');
    }
}
