package br.com.example.data.structures;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private QueueNode<T> first;
    private QueueNode<T> last;

    static class QueueNode<T> {
        private QueueNode<T> next;
        private final T data;

        public QueueNode(T data) {
            this.data = data;
        }
    }


    /**
     * Add an item to the end of the queue
     * @param item
     */
    public void add(T item) {
        QueueNode<T> queueNode = new QueueNode<>(item);
        if (this.isEmpty()) {
            this.first = queueNode;
            this.last = queueNode;
            return;
        }
        this.last.next = queueNode;
        this.last = this.last.next;
    }

    /**
     * Remove the first item in the queue
     */
    public void remove() {
        if (this.isEmpty()) {
            return;
        }
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }
    }

    /**
     * Return the top of the queue
     */
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.first.data;
    }

    /**
     * Return true if the queue is empty
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    public Object[] toArray() {
        QueueNode<T> current = this.first;
        List<T> list = new ArrayList<>();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list.toArray();
    }


}
