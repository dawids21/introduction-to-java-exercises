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
}
