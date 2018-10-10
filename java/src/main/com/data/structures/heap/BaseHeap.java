package com.data.structures.heap;

import com.data.structures.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

public abstract class BaseHeap implements Heap {
    protected int capacity;

    protected Double[] heaps;

    protected int leafPos;

    public BaseHeap() {
        this.capacity = 2;
        this.heaps = new Double[capacity];
        this.leafPos = 0;
    }

    @Override
    public void insert(Double value) {
        if (this.leafPos >= capacity) {
            resizeCapacity(this.capacity * 2);
        }

        int parentPos = getParentPos(this.leafPos);

        if (this.leafPos == 0) {
            this.heaps[0] = value;
        } else if (isInBounds(parentPos)) {
            this.heaps[this.leafPos] = value;
            heapifyUp(this.leafPos);

        }
        this.leafPos++;
    }

    @Override
    public Double remove() throws InvalidInputException {
        Double valueToBePopped = this.heaps[0];

        if (Objects.isNull(valueToBePopped)) {
            throw new InvalidInputException("There is nothing in the heaps");
        }

        this.heaps[0] = null;
        swap(0, this.leafPos - 1);

        heapifyDown(0);

        this.leafPos--;
        return valueToBePopped;
    }

    @Override
    public Double first() {
        return this.heaps[0];
    }

    @Override
    public Double last() {
        return this.heaps[this.leafPos == 0 ? 0 : this.leafPos - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.leafPos <= 0;
    }

    public int size() {
        return Math.toIntExact(Arrays.stream(this.heaps).filter(Objects::nonNull).count());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Can't use lambda as we need the index to know where each node is
        for (int i = 0; i < this.heaps.length; i++) {
            if (Objects.nonNull(this.heaps[i])) {
                sb.append("[ " + i + ": " + this.heaps[i] + " ] ");
            }
        }
        return sb.toString();
    }

    protected void swap(int pos1, int pos2) {
        Double tempValue = this.heaps[pos1];
        this.heaps[pos1] = this.heaps[pos2];
        this.heaps[pos2] = tempValue;
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

    private void resizeCapacity(int newCapacity) {
        this.capacity = newCapacity;
        Double[] tempTree = this.heaps;
        this.heaps = new Double[this.capacity];
        for (int i = 0; i < tempTree.length; i++) {
            this.heaps[i] = tempTree[i];
        }
    }

    protected abstract void heapifyUp(int leafPos);

    protected abstract void heapifyDown(int leafPos);
}
