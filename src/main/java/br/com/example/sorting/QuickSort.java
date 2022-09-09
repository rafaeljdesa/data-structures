package br.com.example.sorting;

public class QuickSort {

    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int leftStartIndex, int rightEndIndex) {
        if (leftStartIndex >= rightEndIndex) {
            return;
        }

        int index = partition(data, leftStartIndex, rightEndIndex);

        quickSort(data, leftStartIndex, index - 1);
        quickSort(data, index + 1, rightEndIndex);
    }

    private int partition(int[] data, int leftStartIndex, int rightEndIndex) {
        int pivot = data[rightEndIndex];
        int leftIndex = leftStartIndex;
        int rightIndex = rightEndIndex - 1;

        while (leftIndex < rightIndex) {
            while (data[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (data[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            swap(data, leftIndex, rightIndex);
        }
        if (data[leftIndex] > data[rightEndIndex]) {
            swap(data, leftIndex, rightEndIndex);
        } else {
            leftIndex = rightEndIndex;
        }
        return leftIndex;
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

}
