package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<String> queue;

    @Before
    public void setup() {
        queue = new Queue<>();
    }

    @Test
    public void addTest() {
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");

        assertArrayEquals(new String[]{"Test1", "Test2", "Test3"}, queue.toArray());
    }

    @Test
    public void removeTest() {
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");

        queue.remove();

        assertArrayEquals(new String[]{"Test2", "Test3"}, queue.toArray());
    }

    @Test
    public void remove_whenEmptyTest() {
        queue.remove();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void peekTest() {
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");

        assertEquals("Test1", queue.peek());
    }

    @Test
    public void peek_whenEmptyTest() {
        assertNull(queue.peek());
    }

    @Test
    public void isEmptyTrueTest() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        queue.add("Test1");

        assertFalse(queue.isEmpty());
    }

    @Test
    public void isEmpty_whenRemoveTest() {
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");

        queue.remove();
        queue.remove();
        queue.remove();

        assertTrue(queue.isEmpty());
    }

}