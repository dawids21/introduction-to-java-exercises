import java.util.ArrayDeque;

public class Hanoi {
    public static void hanoi(int numOfDisk, char fromTower, char toTower, char auxTower) {
        if (numOfDisk <= 0) {
            throw new IllegalArgumentException();
        }
        var fromTowerStack = new ArrayDeque<Integer>();
        var toTowerStack = new ArrayDeque<Integer>();
        var auxTowerStack = new ArrayDeque<Integer>();
        for (var i = numOfDisk; i > 0; i--) {
            fromTowerStack.push(i);
        }
        if (numOfDisk % 2 == 0) {
            char temp = toTower;
            toTower = auxTower;
            auxTower = temp;
        }

        var numOfMovesTotal = (int) (Math.pow(2, numOfDisk) - 1);

        for (var i = 1; i <= numOfMovesTotal; i++) {
            if (i % 3 == 1) {
                moveDisk(fromTowerStack, toTowerStack, fromTower, toTower);
            } else if (i % 3 == 2) {
                moveDisk(fromTowerStack, auxTowerStack, fromTower, auxTower);
            } else {
                moveDisk(auxTowerStack, toTowerStack, auxTower, toTower);
            }
        }
    }

    private static void moveDisk(ArrayDeque<Integer> fromStack,
                                 ArrayDeque<Integer> toStack,
                                 char fromDisk,
                                 char toDisk) {
        if (fromStack.isEmpty()) {
            printMovement(toDisk, fromDisk, toStack.peek());
            fromStack.push(toStack.pop());
        } else if (toStack.isEmpty()) {
            printMovement(fromDisk, toDisk, fromStack.peek());
            toStack.push(fromStack.pop());
        } else if (fromStack.peek() > toStack.peek()) {
            printMovement(toDisk, fromDisk, toStack.peek());
            fromStack.push(toStack.pop());
        } else {
            printMovement(fromDisk, toDisk, fromStack.peek());
            toStack.push(fromStack.pop());
        }
    }

    private static void printMovement(char fromDisk, char toDisk, int disk) {
        System.out.println("Move " + disk + " from " + fromDisk + " to " + toDisk);
    }
}
