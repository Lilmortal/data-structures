package com.interview.questions.tree;

public class MinHeap<T> implements Heap<T> {
    private static final int CAPACITY_RESIZE = 2;

    private int capacity;

    private T[] heap;

    private int leafPos;

    public MinHeap() {
        this.capacity = 10;
        this.heap = (T[]) new Object[this.capacity];
        this.leafPos = 0;
    }

    @Override
    public T first() {
        return this.heap[0];
    }

    @Override
    public T last() {
        return this.heap[this.leafPos];
    }

    @Override
    public void insert(T value) {
        int leftLeafChildPos = getLeftChildPos(this.leafPos);
        int rightLeafChildPos = getRightChildPos(this.leafPos);

        if (rightLeafChildPos > capacity) {
            resizeHeap();
        }

        if (this.heap[leftLeafChildPos] != null) {
            this.heap[rightLeafChildPos] = value;
        } else {
            this.heap[leftLeafChildPos] = value;
        }

        heapifyUp(this.leafPos);
    }

    @Override
    public T pop() {
        T valueToBePopped = this.heap[0];

        this.heap[0] = null;
        swap(0, this.leafPos);

        heapifyDown(0);
        return valueToBePopped;
    }

    @Override
    public int size() {
        return this.heap.length;
    }

    @Override
    public boolean isEmpty() {
        return this.leafPos <= 0;
    }

    private void resizeHeap() {
        // TODO: THINK
        this.capacity *= this.capacity;
        T[] tempHeap = this.heap;
        this.heap = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.heap.length; i++) {
            this.heap[i] = tempHeap[i];
        }
    }

    private void heapifyUp(int pos) {
        int parentPos = getParentPos(pos);
        if (parentPos > pos) {
            swap(parentPos, pos);
            heapifyUp(parentPos);
        }
    }

    private void heapifyDown(int pos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (leftChildPos < pos) {
            swap(leftChildPos, pos);
            heapifyDown(leftChildPos);
        } else if (rightChildPos < pos) {
            swap(rightChildPos, pos);
            heapifyDown(rightChildPos);
        }
    }

    private void swap(int pos1, int pos2) {
        T tempValue = this.heap[pos1];
        this.heap[pos1] = this.heap[pos2];
        this.heap[pos2] = tempValue;
    }

    private int getParentPos(int pos) {
        return pos % 2 == 0 ? pos / 2 - 1 : pos / 2;
    }

    private int getLeftChildPos(int pos) {
        return 2 * pos + 1;
    }

    private int getRightChildPos(int pos) {
        return 2 * pos + 2;
    }
}
