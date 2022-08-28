package br.com.example.sorting;

public class MergeSort {

    public static void sort(int[] data) {
        int[] temp = new int[data.length];
        mergeSort(data, temp, 0, data.length - 1);
    }

    private static void mergeSort(int[] data, int[] temp, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;
            mergeSort(data, temp, leftStart, middle);
            mergeSort(data, temp, middle + 1, rightEnd);
            mergeHalves(data, temp, leftStart, rightEnd);
        }
    }

    private static void mergeHalves(int[] data, int[] temp, int leftStart, int rightEnd) {
        for (int i = leftStart; i <= rightEnd; i++) {
            temp[i] = data[i];
        }

        int middle = (leftStart + rightEnd) / 2;

        int leftEnd = middle;
        int rightStart = middle + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (temp[left] <= temp[right]) {
                data[index] = temp[left];
                left++;
            } else {
                data[index] = temp[right];
                right++;
            }
            index++;
        }

        while (left <= leftEnd) {
            data[index] = temp[left];
            left++;
            index++;
        }

        while (right <= rightEnd) {
            data[index] = temp[right];
            right++;
            index++;
        }

    }

}
