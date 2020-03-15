package chapter9.Stopwatch;

import java.util.Random;

import chapter7.SelectionSort.SelectionSort;

public class TestStopwatch {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        int[] array = new int[100000];
        fillArray(array);
        stopwatch.start();
        SelectionSort.sort(array, array.length, true);
        stopwatch.stop();
        System.out.println("Time elapsed: " + stopwatch.getElapsedTime() + "ms");
    }

    private static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt();
        }
    }
}