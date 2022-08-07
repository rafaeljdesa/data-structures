package br.com.example.data.structures;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    public void insertTest() {
        Trie trie = new Trie();
        trie.insert("test");
        trie.insert("foo");
        trie.insert("bar");
    }

    @Test
    public void searchTest() {
        Trie trie = new Trie();
        trie.insert("testing");

        assertTrue(trie.search("testing"));
        assertFalse(trie.search("test"));
        assertFalse(trie.search("foo"));
    }

    @Test
    public void startsWithTest() {
        Trie trie = new Trie();
        trie.insert("testing");

        assertTrue(trie.startsWith("testing"));
        assertTrue(trie.startsWith("test"));
        assertFalse(trie.startsWith("foo"));
    }
}