package br.com.example.sorting;

public class SelectionSort {

    public static void sort(int[] data) {
        int targetIndex = 0;
        boolean sorted = false;
        while (!sorted) {
            int currentMinIndex = targetIndex;
            for (int i = currentMinIndex; i < data.length; i++) {
                if (data[i] < data[currentMinIndex]) {
                    currentMinIndex = i;
                }
            }
            swap(data, targetIndex, currentMinIndex);
            if (++targetIndex == data.length) {
                sorted = true;
            }
        }
    }

    private static void swap(int[] data, int fromIndex, int toIndex) {
        int temp = data[fromIndex];
        data[fromIndex] = data[toIndex];
        data[toIndex] = temp;
    }

}
