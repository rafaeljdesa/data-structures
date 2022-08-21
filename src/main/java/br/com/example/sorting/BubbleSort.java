package br.com.example.sorting;

public class BubbleSort {

    public static void sort(int[] data) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = doSort(data);
        }
    }

    private static boolean doSort(int[] data) {
        boolean isSorted = true;
        for (int i = 0; i < data.length - 1; i++) {
            int next = i + 1;
            if (data[i] > data[next]) {
                isSorted = false;
                swap(data, i, next);
            }
        }
        return isSorted;
    }

    private static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

}
