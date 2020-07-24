import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var mapOfOccurrences = new HashMap<Integer, Integer>();

        System.out.print("Enter the numbers: ");
        String[] numbers = input.nextLine()
                                .split("\\s+");
        input.close();

        Arrays.stream(numbers)
              .filter(App::isInteger)
              .map(Integer::parseInt)
              .forEach(integer -> {
                  if (mapOfOccurrences.containsKey(integer)) {
                      mapOfOccurrences.put(integer, mapOfOccurrences.get(integer) + 1);
                  } else {
                      mapOfOccurrences.put(integer, 1);
                  }
              });

        int maxOccurrences = Collections.max(mapOfOccurrences.values());
        mapOfOccurrences.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == maxOccurrences)
                        .forEach(entry -> System.out.print(entry.getKey() + " "));
    }

    private static boolean isInteger(String number) {
        boolean integer;
        try {
            Integer.parseInt(number);
            integer = true;
        } catch (NumberFormatException e) {
            integer = false;
        }
        return integer;
    }
}
