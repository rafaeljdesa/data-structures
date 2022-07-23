package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void insertTest() {
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(4);
        binaryTree.preOrder();
    }

    @Test
    public void containsTrueTest() {
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(4);

        assertTrue(binaryTree.contains(6));
    }

    @Test
    public void containsFalseTest() {
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(4);

        assertFalse(binaryTree.contains(18));
    }



}