import java.util.Arrays;
import java.util.Comparator;

public class Sort {

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        for (int i = 1; i < list.length; i++) {
            boolean needForNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needForNextPass = true;
                }
            }
            if (!needForNextPass) {
                break;
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            boolean needForNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needForNextPass = true;
                }
            }
            if (!needForNextPass) {
                break;
            }
        }

    }

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            var firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            mergeSort(firstHalf);
            var secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] firstHalf, E[] secondHalf,
                                                        E[] dest) {
        var currentFirst = 0;
        var currentSecond = 0;
        var currentDest = 0;

        while (currentFirst < firstHalf.length && currentSecond < secondHalf.length) {
            if (firstHalf[currentFirst].compareTo(secondHalf[currentSecond]) <= 0) {
                dest[currentDest] = firstHalf[currentFirst];
                currentFirst++;
            } else {
                dest[currentDest] = secondHalf[currentSecond];
                currentSecond++;
            }
            currentDest++;
        }

        if (currentFirst == firstHalf.length) {
            System.arraycopy(secondHalf, currentSecond, dest, currentDest,
                             secondHalf.length - currentSecond);
        }

        if (currentSecond == secondHalf.length) {
            System.arraycopy(firstHalf, currentFirst, dest, currentDest,
                             firstHalf.length - currentFirst);
        }
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            var firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            mergeSort(firstHalf, comparator);
            var secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(secondHalf, comparator);
            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    private static <E> void merge(E[] firstHalf, E[] secondHalf, E[] dest,
                                  Comparator<? super E> comparator) {
        var currentFirst = 0;
        var currentSecond = 0;
        var currentDest = 0;

        while (currentFirst < firstHalf.length && currentSecond < secondHalf.length) {
            if (comparator.compare(firstHalf[currentFirst], secondHalf[currentSecond]) <=
                0) {
                dest[currentDest] = firstHalf[currentFirst];
                currentFirst++;
            } else {
                dest[currentDest] = secondHalf[currentSecond];
                currentSecond++;
            }
            currentDest++;
        }

        if (currentFirst == firstHalf.length) {
            System.arraycopy(secondHalf, currentSecond, dest, currentDest,
                             secondHalf.length - currentSecond);
        }

        if (currentSecond == secondHalf.length) {
            System.arraycopy(firstHalf, currentFirst, dest, currentDest,
                             firstHalf.length - currentFirst);
        }
    }
}
