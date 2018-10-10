package com.data.structures.tree;

import com.data.structures.InvalidInputException;

import java.util.Arrays;
import java.util.Objects;

public abstract class BaseTree implements Tree {
    protected int capacity;

    protected Double[] trees;

    protected int height;

    public BaseTree() {
        this.capacity = 10;
        this.trees = new Double[this.capacity];
        this.height = 0;
    }

    public void insert(Double value) throws InvalidInputException {
        setHeight(getMaxHeight(0, 1));
        int height = getHeight();
        if (getNumOfNodes(0, height + 1) > capacity) {
            resizeCapacity(this.capacity + getNumOfNodesInHeight(height + 1));
        }

        insertValue(value);
    }

    public Double first() {
        return this.trees[0];
    }

    public Double last() {
        return null;
    }

    public int size() {
        return Math.toIntExact(Arrays.stream(this.trees).filter(Objects::nonNull).count());
    }

    public boolean isEmpty() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Can't use lambda as we need the index to know where each node is
        for (int i = 0; i < this.trees.length; i++) {
            if (Objects.nonNull(this.trees[i])) {
                sb.append("[ " + i + ": " + this.trees[i] + " ] ");
            }
        }
        return sb.toString();
    }

    protected void swap(int pos1, int pos2) {
        Double tempValue = this.trees[pos1];
        this.trees[pos1] = this.trees[pos2];
        this.trees[pos2] = tempValue;
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

    protected int getHeight() {
        return this.height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    private void resizeCapacity(int newCapacity) {
        this.capacity = newCapacity;
        Double[] tempTree = this.trees;
        this.trees = new Double[this.capacity];
        for (int i = 0; i < tempTree.length; i++) {
            this.trees[i] = tempTree[i];
        }
    }

    private int getMaxHeight(int pos, int height) {
        if (this.trees[pos] == null) {
            return height;
        }

        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);
        int leftChildHeight = 0;
        int rightChildHeight = 0;

        if (this.trees[leftChildPos] != null) {
            leftChildHeight = getMaxHeight(leftChildPos, height + 1);
        }

        if (this.trees[rightChildPos] != null) {
            rightChildHeight = getMaxHeight(rightChildPos, height + 1);
        }

        return Integer.max(height, Integer.max(leftChildHeight, rightChildHeight));
    }

    private int getNumOfNodes(int numOfNodes, int height) {
        if (height < 0) {
            return numOfNodes;
        }

        return getNumOfNodes(numOfNodes + getNumOfNodesInHeight(height), height - 1);
    }

    // TODO: Think of a good name
    private int getNumOfNodesInHeight(int height) {
        return (int) Math.pow(2, height);
    }

    protected abstract void insertValue(Double value) throws InvalidInputException;
}
