package br.com.example.data.structures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private List<Integer> dataTraversed;

    private Node root;

    class Node {

        private final int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(Node node) {
            if (node.data <= this.data) {
                this.insertLeft(node);
            } else {
                this.insertRight(node);
            }
        }

        public boolean contains(int data) {
            if (data == this.data) {
                return true;
            }
            if (data < this.data) {
                if (this.left == null) {
                    return false;
                }
                return this.left.contains(data);
            } else {
                if (this.right == null) {
                    return false;
                }
                return this.right.contains(data);
            }
        }

        private void insertLeft(Node node) {
            if (this.left != null) {
                this.left.insert(node);
            } else {
                this.left = node;
            }
        }

        private void insertRight(Node node) {
            if (this.right != null) {
                this.right.insert(node);
            } else {
                this.right = node;
            }
        }

        private void visit(Node node) {
            System.out.println(node.data);
            BinarySearchTree.this.dataTraversed.add(node.data);
        }

        private void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }

        private void preOrder(Node node) {
            if (node == null) {
                return;
            }
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }

        private void posOrder(Node node) {
            if (node == null) {
                return;
            }
            posOrder(node.left);
            posOrder(node.right);
            visit(node);
        }
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (this.root != null) {
            this.root.insert(node);
            return;
        }
        this.root = node;
    }

    public List<Integer> inOrder() {
        this.dataTraversed = new ArrayList<>();
        this.root.inOrder(this.root);
        return this.dataTraversed;
    }

    public List<Integer> preOrder() {
        this.dataTraversed = new ArrayList<>();
        this.root.preOrder(this.root);
        return this.dataTraversed;
    }

    public List<Integer> posOrder() {
        this.dataTraversed = new ArrayList<>();
        this.root.posOrder(this.root);
        return this.dataTraversed;
    }

    public boolean contains(int data) {
        return this.root.contains(data);
    }

}
