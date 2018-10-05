package com.interview.questions.tree;

import java.util.Arrays;
import java.util.Objects;

public class MinHeap implements Heap {
    private int capacity;

    private Double[] heap;

    private int leafPos;

    public MinHeap() {
        this.capacity = 10;
        this.heap = new Double[this.capacity];
        this.leafPos = 0;
    }

    @Override
    public Double first() {
        return this.heap[0];
    }

    @Override
    public Double last() {
        return this.heap[this.leafPos];
    }

    @Override
    public void insert(Double value) {
        int leftLeafChildPos = getLeftChildPos(this.leafPos);
        int rightLeafChildPos = getRightChildPos(this.leafPos);

        if (rightLeafChildPos > capacity) {
            resizeHeap();
        }

        if (this.leafPos == 0) {
            this.heap[0] = value;
        } else if (this.heap[leftLeafChildPos] != null) {
            this.heap[rightLeafChildPos] = value;
        } else {
            this.heap[leftLeafChildPos] = value;
        }

        heapifyUp(this.leafPos);

        this.leafPos++;
    }

    @Override
    public Double pop() {
        Double valueToBePopped = this.heap[0];

        this.heap[0] = null;
        swap(0, this.leafPos);

        heapifyDown(0);

        this.leafPos--;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.heap).filter(Objects::nonNull).forEach(heap -> sb.append("[ " + heap.toString() + " ] "));
        return sb.toString();
    }

    private void resizeHeap() {
        // TODO: THINK
        this.capacity *= this.capacity;
        Double[] tempHeap = this.heap;
        this.heap = new Double[this.capacity];
        for (int i = 0; i < this.heap.length; i++) {
            this.heap[i] = tempHeap[i];
        }
    }

    private void heapifyUp(int pos) {
        int parentPos = getParentPos(pos);
        if (isInBounds(parentPos) && !Objects.isNull(this.heap[parentPos]) && Objects.isNull(this.heap[pos]) && this.heap[parentPos] > this.heap[pos]) {
            swap(parentPos, pos);
            heapifyUp(parentPos);
        }
    }

    private void heapifyDown(int pos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (isInBounds(leftChildPos) && !Objects.isNull(this.heap[leftChildPos]) && !Objects.isNull(this.heap[pos]) && this.heap[leftChildPos] < this.heap[pos]) {
            swap(leftChildPos, pos);
            heapifyDown(leftChildPos);
        } else if (isInBounds(rightChildPos) && !Objects.isNull(this.heap[rightChildPos]) && !Objects.isNull(this.heap[pos]) && this.heap[rightChildPos] < this.heap[pos]) {
            swap(rightChildPos, pos);
            heapifyDown(rightChildPos);
        }
    }

    private void swap(int pos1, int pos2) {
        Double tempValue = this.heap[pos1];
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

    private boolean isInBounds(int index) {
        return index >= 0 && index < this.capacity;
    }
}
