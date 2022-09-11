package br.com.example.sorting;

public class InsertionSort {

    int[] data;

    public void sort(int[] data) {
        this.data = data;
        insertionsort();
    }

    private void insertionsort() {
        int current = 1;
        int previous = 0;
        while (current < data.length) {
            int temp = data[current];
            while (previous >= 0 && data[previous] > temp) {
                // move to right
                data[previous + 1] = data[previous];
                previous--;
            }
            // insert
            data[previous + 1] = temp;

            previous = current++;
        }
    }
}
