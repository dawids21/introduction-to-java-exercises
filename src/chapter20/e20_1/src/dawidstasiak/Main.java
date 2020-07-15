package dawidstasiak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var listOfWords = new ArrayList<String>();
        try (var input = new Scanner(Main.class.getResourceAsStream("input.txt"))) {
            while (input.hasNext()) {
                listOfWords.add(input.next());
            }
        }
        Collections.sort(listOfWords);
        System.out.println(listOfWords.toString());
    }
}
