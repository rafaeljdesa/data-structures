package br.com.example.sorting;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void sortTest() {
        int[] data = { 2, 1, 5, 3, 6, 4 };

        BubbleSort.sort(data);

        int[] expected = { 1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, data);
    }
}