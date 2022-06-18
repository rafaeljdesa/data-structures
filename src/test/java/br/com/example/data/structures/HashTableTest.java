package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable myHashTable;

    @Before
    public void init() {
        myHashTable = new HashTable();
    }

    @Test
    public void shouldInsertItem() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertEquals(2, items.size());
    }

    @Test
    public void shouldNotInsertDuplicatedItem() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);
        myHashTable.insertItem(item2);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertEquals(2, items.size());
    }

    @Test
    public void shouldGetItem() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);

        assertEquals(item1, myHashTable.getItem(item1));
        assertEquals(item2, myHashTable.getItem(item2));
    }

    @Test
    public void shouldGetNull_whenItemNotFound() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);

        assertNull(myHashTable.getItem("Sid"));
    }

    @Test
    public void shouldRemoveItem() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);

        myHashTable.removeItem(item2);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertFalse(items.contains(item2));
        assertEquals(1, items.size());
    }

    @Test
    public void shouldDoNothing_whenNotFoundItemToRemove() {
        String item1 = "Rafael";
        String item2 = "Jessica";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);

        myHashTable.removeItem("Sid");

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertEquals(2, items.size());
    }

    @Test
    public void shouldInsertItem_whenResizedArray() {
        String item1 = "Rafael";
        String item2 = "Jessica";
        String item3 = "Eric";
        String item4 = "Sid";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);
        myHashTable.insertItem(item3);
        myHashTable.insertItem(item4);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertTrue(items.contains(item3));
        assertTrue(items.contains(item4));
        assertEquals(4, items.size());
    }

    @Test
    public void shouldGetItem_whenResizedArray() {
        String item1 = "Rafael";
        String item2 = "Jessica";
        String item3 = "Eric";
        String item4 = "Sid";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);
        myHashTable.insertItem(item3);
        myHashTable.insertItem(item4);

        assertEquals(item1, myHashTable.getItem(item1));
        assertEquals(item2, myHashTable.getItem(item2));
        assertEquals(item3, myHashTable.getItem(item3));
        assertEquals(item4, myHashTable.getItem(item4));
    }

    @Test
    public void shouldRemoveItem_whenResizedArray() {
        String item1 = "Rafael";
        String item2 = "Jessica";
        String item3 = "Eric";
        String item4 = "Sid";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);
        myHashTable.insertItem(item3);
        myHashTable.insertItem(item4);

        myHashTable.removeItem(item3);
        myHashTable.removeItem(item4);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertFalse(items.contains(item3));
        assertFalse(items.contains(item4));
        assertEquals(2, items.size());
    }

    @Test
    public void shouldNotInsertDuplicatedItem_whenConflictPosition() {
        String item1 = "Rafael";
        String item2 = "Jessica";
        String item3 = "Eric";
        String item4 = "Sid";

        myHashTable.insertItem(item1);
        myHashTable.insertItem(item2);
        myHashTable.insertItem(item3);
        myHashTable.insertItem(item4);

        myHashTable.insertItem(item4);

        List<String> items = Arrays.asList(myHashTable.getItems());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
        assertTrue(items.contains(item3));
        assertTrue(items.contains(item4));
        assertEquals(4, items.size());
    }

}