package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    Stack<String> stack;

    @Before
    public void setup() {
        stack = new Stack<>();
    }

    @Test
    public void popTest() {
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");

        stack.pop();

        assertArrayEquals(new String[]{"Test2", "Test1"}, stack.toArray());
    }

    @Test
    public void pop_whenEmptyTest() {
        stack.pop();

        assertNull(stack.peek());
    }

    @Test
    public void pushTest() {
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");

        assertArrayEquals(new String[]{"Test3", "Test2", "Test1"}, stack.toArray());
    }

    @Test
    public void peekTest() {
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");

        assertEquals("Test3", stack.peek());
    }

    @Test
    public void isEmptyTrueTest() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        stack.push("Test1");
        assertFalse(stack.isEmpty());
    }
}