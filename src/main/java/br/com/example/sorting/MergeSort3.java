package br.com.example.sorting;

import java.util.Arrays;

public class MergeSort3 {

    int[] data;

    public void sort(int[] data) {
        this.data = data;
        mergeSort( 0, data.length - 1);
    }

    private void mergeSort(int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int leftEnd = getMiddle(leftStart, rightEnd);
        int rightStart = leftEnd + 1;
        mergeSort(leftStart, leftEnd);
        mergeSort(rightStart, rightEnd);
        merge(leftStart, rightEnd);
    }

    private void merge(int leftStart, int rightEnd) {

        int leftEnd = getMiddle(leftStart, rightEnd);
        int rightStart = leftEnd + 1;
        int index = leftStart;

        int[] left = Arrays.copyOfRange(data, leftStart, leftEnd + 1);
        int[] right = Arrays.copyOfRange(data, rightStart, rightEnd + 1);

        int leftI = 0;
        int rightI = 0;

        while (leftI < left.length && rightI < right.length) {
            data[index++] = left[leftI] <= right[rightI] ? left[leftI++] : right[rightI++];
        }

        while (leftI < left.length) {
            data[index++] = left[leftI++];
        }

        while (rightI < right.length) {
            data[index++] = right[rightI++];
        }

    }

    private int getMiddle(int leftStart, int rightEnd) {
        return (leftStart + rightEnd) / 2;
    }
}
