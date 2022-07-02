package br.com.example.data.structures;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {

    private Node head;

    class Node {

        private Node next;
        private Node previous;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public void append(Object data) {
            Node lastNode = new Node(data);
            Node node = this;
            while(node.next != null) {
                node = node.next;
            }
            lastNode.previous = node;
            node.next = lastNode;
        }

        public Node prepend(Object data) {
            Node node = new Node(data);
            this.previous = node;
            node.next = this;
            return node;
        }

    }

    public void add(Object data) {
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        this.head.append(data);
    }

    public void addToHead(Object data) {
        Node currentNode = new Node(data);
        if (this.head == null) {
            this.head = currentNode;
            return;
        }
        this.head = this.head.prepend(data);
    }

    public Object get(Object data) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (data.equals(currentNode.data)) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void remove(Object data) {
        Node currentNode = this.head;
        Node previousNode = null;
        while (currentNode != null) {
            if (!data.equals(currentNode.data)) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                continue;
            }
            if (previousNode != null) {
                previousNode.next = currentNode.next;
                if (previousNode.next != null) {
                    previousNode.next.previous = previousNode;
                }
            } else {
                this.head = currentNode.next;
                this.head.previous = null;
            }
            return;
        }
    }

    public Node getNodes() {
        return this.head;
    }

    public List<Object> getAll() {
        List<Object> dataList = new ArrayList<>();
        Node currentNode = this.head;
        while (currentNode != null) {
            dataList.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return dataList;
    }


}