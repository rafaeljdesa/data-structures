package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList arrayList;

    @Before
    public void setup() {
        arrayList = new ArrayList();
    }

    @Test
    public void addTest() {
        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");

        assertEquals(6, arrayList.getAll().length);
    }

    @Test
    public void removeTest() {
        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");

        arrayList.remove("Test4");

        assertEquals(5, arrayList.getAll().length);
    }

    @Test
    public void remove_whenInvalidItemTest() {
        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");

        arrayList.remove("Test6");

        assertEquals(6, arrayList.getAll().length);
    }

    @Test
    public void getTest() {
        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");

        assertEquals("Test5", arrayList.get("Test5"));
    }

    @Test
    public void get_whenInvalidItemTest() {
        arrayList.add("Test");
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test4");
        arrayList.add("Test5");

        assertNull(arrayList.get("Test6"));
    }
}