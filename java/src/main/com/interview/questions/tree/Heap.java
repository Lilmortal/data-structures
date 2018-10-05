package com.interview.questions.tree;

import com.interview.questions.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

public abstract class Heap {
    protected int capacity;

    protected Double[] heap;

    protected int leafPos;

    public Heap() {
        this.capacity = 10;
        this.heap = new Double[this.capacity];
        this.leafPos = 0;
    }

    public void insert(Double value) {
        int parentPos = getParentPos(this.leafPos);
        int rightLeafChildPos = getRightChildPos(this.leafPos);

        if (rightLeafChildPos > capacity) {
            resizeHeap();
        }

        if (this.leafPos == 0) {
            this.heap[0] = value;
        } else if (isInBounds(parentPos)) {
            this.heap[this.leafPos] = value;
            heapifyUp(this.leafPos);

        }
        this.leafPos++;
    }

    public Double pop() throws InvalidInputException {
        Double valueToBePopped = this.heap[0];

        if (Objects.isNull(valueToBePopped)) {
            throw new InvalidInputException("There is nothing in the heap");
        }

        this.heap[0] = null;
        swap(0, this.leafPos - 1);

        heapifyDown(0);

        this.leafPos--;
        return valueToBePopped;
    }

    public Double first() {
        return this.heap[0];
    }

    public Double last() {
        return this.heap[this.leafPos == 0 ? 0 : this.leafPos - 1];
    }

    public int size() {
        return this.heap.length;
    }

    public boolean isEmpty() {
        return this.leafPos <= 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.heap).filter(Objects::nonNull).forEach(heap -> sb.append("[ " + heap.toString() + " ] "));
        return sb.toString();
    }

    protected void resizeHeap() {
        this.capacity *= this.capacity;
        Double[] tempHeap = this.heap;
        this.heap = new Double[this.capacity];
        for (int i = 0; i < this.heap.length; i++) {
            this.heap[i] = tempHeap[i];
        }
    }

    protected void swap(int pos1, int pos2) {
        Double tempValue = this.heap[pos1];
        this.heap[pos1] = this.heap[pos2];
        this.heap[pos2] = tempValue;
    }

    protected int getParentPos(int pos) {
        return pos % 2 == 0 ? pos / 2 - 1 : pos / 2;
    }

    protected int getLeftChildPos(int pos) {
        return 2 * pos + 1;
    }

    protected int getRightChildPos(int pos) {
        return 2 * pos + 2;
    }

    protected boolean isInBounds(int index) {
        return index >= 0 && index < this.capacity;
    }

    protected abstract void heapifyUp(int leafPos);

    protected abstract void heapifyDown(int leafPos);
}
