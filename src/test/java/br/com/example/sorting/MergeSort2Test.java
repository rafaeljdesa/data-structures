package br.com.example.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSort2Test {

    private MergeSort2 mergeSort;

    @Before
    public void setup() {
        mergeSort = new MergeSort2();
    }

    @Test
    public void sortTest() {
        int[] data = { 2, 1, 5, 3, 6, 4 };

        mergeSort.sort(data);

        int[] expected = { 1, 2, 3, 4, 5, 6 };
        assertArrayEquals(expected, data);
    }

    @Test
    public void sortTest2() {
        int[] data = { 11, 5, 6, 17, 9, 1, 13, 20, 4, 2, 15, 16, 12, 3, 7, 8, 10, 19, 18, 14 };

        mergeSort.sort(data);

        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        assertArrayEquals(expected, data);
    }

}