package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void inOrderTest() {
        insertData();
        List<Integer> inOrder = binarySearchTree.inOrder();
        Integer[] expected = { 1, 3, 4, 6, 7, 8, 10, 13, 14 };
        assertArrayEquals(expected, inOrder.toArray());
    }

    @Test
    public void preOrderTest() {
        insertData();
        List<Integer> preOrder = binarySearchTree.preOrder();
        Integer[] expected = { 8, 3, 1, 6, 4, 7, 10, 14, 13 };
        assertArrayEquals(expected, preOrder.toArray());
    }

    @Test
    public void posOrderTest() {
        insertData();
        List<Integer> posOrder = binarySearchTree.posOrder();
        Integer[] expected = { 1, 4, 7, 6, 3, 13, 14, 10, 8 };
        assertArrayEquals(expected, posOrder.toArray());
    }

    @Test
    public void containsTrueTest() {
        insertData();
        assertTrue(binarySearchTree.contains(6));
    }

    @Test
    public void containsFalseRightTest() {
        insertData();
        assertFalse(binarySearchTree.contains(18));
    }

    @Test
    public void containsFalseLeftTest() {
        insertData();
        assertFalse(binarySearchTree.contains(0));
    }

    private void insertData() {
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(14);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(13);
    }

}