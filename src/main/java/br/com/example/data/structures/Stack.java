package br.com.example.data.structures;

public class Stack<T> {

    private StackNode<T> top;
    private int size = 0;

    static class StackNode<T> {

        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    /**
     * Remove the top item from stack
     */
    public void pop() {
        if (this.isEmpty()) {
            return;
        }
        this.top = this.top.next;
        this.size--;
    }

    /**
     * Add an item to the top of stack
     * @param item
     */
    public void push(T item) {
        StackNode<T> newStackNode = new StackNode<>(item);
        newStackNode.next = this.top;
        this.top = newStackNode;
        this.size++;
    }

    /**
     * Return the top of the stack
     */
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.top.data;
    }


    /**
     * Return if the stack is empty
     * @return
     */
    public boolean isEmpty() {
        return this.top == null;
    }

    public Object[] toArray() {
        Object[] dataArray = new Object[this.size];
        StackNode<T> current = this.top;
        for (int i = 0; i < size; i++) {
            dataArray[i] = current.data;
            current = current.next;
        }
        return dataArray;
    }

}
