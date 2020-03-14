package chapter7.BubbleSort;

public class BubbleSort {
    public static int[] sort(int[] array, boolean ascending)
    {
        boolean are_swapped;
        do {
            are_swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (ascending && array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    are_swapped = true;
                }
                else if (!ascending && array[i] < array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    are_swapped = true;
                }
            }
        } while(are_swapped);
        return array;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 3, 7};
        sort(arr, false);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }    
}