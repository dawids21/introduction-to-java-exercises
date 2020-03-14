package chapter7.SelectionSort;


public class SelectionSort {
    public static int[] sort(int[] array, int length, boolean ascending) {
        if (ascending) {
            int minIndex;
            for (int i = 0; i < length - 1; i++) {
                minIndex = minValue(array, i, length);
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        else {
            int maxIndex;
            for (int i = 0; i < length - 1; i++) {
                maxIndex = maxValue(array, i, length);
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
        return array;
    }
    
    public static int maxValue(int[] array, int startIndex, int length) {
        int index = startIndex;
        int max = array[startIndex];
        for (int i = startIndex + 1; i < length; i++) {
            if (array[i] > max) {
                index = i;
                max = array[i];
            }
        }
        return index;
    }

    public static int minValue(int[] array, int startIndex, int length) {
        int index = startIndex;
        int min = array[startIndex];
        for (int i = startIndex + 1; i < length; i++) {
            if (array[i] < min) {
                index = i;
                min = array[i];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 3, 7};
        sort(arr, arr.length, false);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}