package br.com.example.sorting;

public class MergeSort2 {

    int[] data;
    int[] temp;

    public void sort(int[] data) {
        this.data = data;
        this.temp = new int[data.length];
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
        for (int i = leftStart; i <= rightEnd; i++) {
            temp[i] = data[i];
        }

        int leftEnd = getMiddle(leftStart, rightEnd);
        int rightStart = leftEnd + 1;
        int index = leftStart;
        int left = leftStart;
        int right = rightStart;

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

        while(right <= rightEnd) {
            data[index] = temp[right];
            right++;
            index++;
        }
    }

    private int getMiddle(int leftStart, int rightEnd) {
        return (leftStart + rightEnd) / 2;
    }
}
