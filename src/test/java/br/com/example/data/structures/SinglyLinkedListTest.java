package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList linkedList;

    @Before
    public void setup() {
        linkedList = new SinglyLinkedList();
    }

    @Test
    public void addTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");

        assertArrayEquals(new String[]{"Test1", "Test2", "Test3", "Test4"}, linkedList.getAll().toArray());
    }

    @Test
    public void addToHeadTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");

        linkedList.addToHead("Test0");

        assertArrayEquals(new String[]{"Test0", "Test1", "Test2", "Test3"}, linkedList.getAll().toArray());
    }

    @Test
    public void addToHead_whenHeadIsNullTest() {
        linkedList.addToHead("Test0");

        assertArrayEquals(new String[]{"Test0"}, linkedList.getAll().toArray());
    }

    @Test
    public void getTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.add("Test5");

        assertEquals("Test4", linkedList.get("Test4"));
    }

    @Test
    public void get_whenNotFoundTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.add("Test5");

        assertNull(linkedList.get("Test6"));
    }

    @Test
    public void removeFirstTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.add("Test5");

        linkedList.remove("Test1");

        assertArrayEquals(new String[]{"Test2", "Test3", "Test4", "Test5"}, linkedList.getAll().toArray());
    }

    @Test
    public void removeLastTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.add("Test5");

        linkedList.remove("Test5");

        assertArrayEquals(new String[]{"Test1", "Test2", "Test3", "Test4"}, linkedList.getAll().toArray());
    }

    @Test
    public void removeTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");
        linkedList.add("Test5");

        linkedList.remove("Test3");

        assertArrayEquals(new String[]{"Test1", "Test2", "Test4", "Test5"}, linkedList.getAll().toArray());
    }

    @Test
    public void remove_whenNotFoundTest() {
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4");

        linkedList.remove("Test6");

        assertArrayEquals(new String[]{"Test1", "Test2", "Test3", "Test4"}, linkedList.getAll().toArray());
    }
}