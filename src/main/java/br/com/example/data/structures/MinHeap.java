package br.com.example.data.structures;

public class MinHeap {

    private final Heap[] heaps;
    private int current = 0;
    private int maxSize = 10;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heaps = new Heap[this.maxSize];
    }

    public MinHeap() {
        this.heaps = new Heap[this.maxSize];
    }

    static class Heap {

        private final int data;

        public Heap(int data) {
            this.data = data;
        }
    }

    public int getMin() {
        return this.heaps[0].data;
    }

    public void extractMin() {
        int lastPosition = --this.current;
        this.heaps[0] = this.heaps[lastPosition];
        this.heaps[lastPosition] = null;
        heapify(0);
    }

    public void insert(int data) {
        int position = this.current;
        if (position >= this.maxSize) {
            return;
        }

        Heap heap = new Heap(data);

        this.heaps[position] = heap;

        int parentPosition = this.getParent(position);
        Heap parent = this.heaps[parentPosition];

        while (parent.data > heap.data) {
            this.swap(position, parentPosition);
            position = parentPosition;
            parentPosition = this.getParent(position);
            parent = this.heaps[parentPosition];
        }

        this.current++;
    }

    public int[] toArray()  {
        int[] data = new int[this.current];
        for (int i = 0; i < this.current; i++) {
            data[i] = this.heaps[i].data;
        }
        return data;
    }

    private void heapify(int position) {
        if (position >= this.current) {
            return;
        }

        int leftChildPosition = this.getLeftChild(position);
        int rightChildPosition = this.getRightChild(position);

        if (this.isLeaf(leftChildPosition, rightChildPosition)) {
            return;
        }

        Heap current = this.heaps[position];
        Heap leftChild = this.heaps[leftChildPosition];
        Heap rightChild = this.heaps[rightChildPosition];

        if (rightChild != null && leftChild.data < rightChild.data) {
            this.swap(position, leftChildPosition);
            this.heapify(leftChildPosition);
        } else if (rightChild != null && rightChild.data < leftChild.data) {
            this.swap(position, rightChildPosition);
            this.heapify(rightChildPosition);
        } else if (leftChild.data < current.data) {
            this.swap(position, leftChildPosition);
            this.heapify(leftChildPosition);
        }
    }

    private boolean isLeaf(int leftChildPosition, int rightChildPosition) {
        return leftChildPosition >= this.current && rightChildPosition >= this.current;
    }

    private void swap(int currentPosition, int nextPosition) {
        Heap temp = this.heaps[currentPosition];
        this.heaps[currentPosition] = this.heaps[nextPosition];
        this.heaps[nextPosition] = temp;
    }

    private int getParent(int position) {
        return (position - 1) / 2;
    }

    private int getLeftChild(int position) {
        return (2 * position) + 1;
    }

    private int getRightChild(int position) {
        return (2 * position) + 2;
    }


}
