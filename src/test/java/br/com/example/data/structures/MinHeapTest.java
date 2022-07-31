package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    private MinHeap minHeap;

    @Before
    public void setup() {
        minHeap = new MinHeap();
    }

    @Test
    public void insertTest() {
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(20);
        minHeap.insert(18);
        minHeap.insert(42);
        minHeap.insert(1);
        minHeap.insert(3);
        assertArrayEquals(new int[] { 1, 5, 3, 18, 42, 20, 4 }, minHeap.toArray());
    }

    @Test
    public void getMinTest() {
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(20);
        minHeap.insert(18);
        minHeap.insert(42);
        minHeap.insert(1);
        minHeap.insert(3);
        assertEquals(1, minHeap.getMin());
    }

    @Test
    public void extractMinTest() {
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(20);
        minHeap.insert(18);
        minHeap.insert(42);
        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.extractMin();
        assertArrayEquals(new int[] { 3, 5, 4, 18, 42, 20 }, minHeap.toArray());
    }

    @Test
    public void extractMinTest2() {
        minHeap.insert(8);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(30);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.extractMin();
        assertArrayEquals(new int[] { 2, 3, 4, 6, 8, 22, 30 }, minHeap.toArray());
    }

    @Test
    public void extractMinTest3() {
        minHeap.insert(8);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(30);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.extractMin();
        minHeap.extractMin();
        assertArrayEquals(new int[] { 3, 6, 4, 30, 8, 22 }, minHeap.toArray());
    }

    @Test
    public void extractMinTest4() {
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(8);
        minHeap.insert(22);
        minHeap.insert(23);
        minHeap.extractMin();
        assertArrayEquals(new int[] { 5, 6, 22, 30, 8, 23 }, minHeap.toArray());
    }

}