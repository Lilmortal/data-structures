package com.interview.questions.tree;

import java.util.Arrays;
import java.util.Objects;

public abstract class BaseTree {
    protected int capacity;

    protected Double[] trees;

    protected int leafPos;

    public BaseTree() {
        this.capacity = 10;
        this.trees = new Double[this.capacity];
        this.leafPos = 0;
    }

    public Double first() {
        return this.trees[0];
    }

    public Double last() {
        return this.trees[this.leafPos == 0 ? 0 : this.leafPos - 1];
    }

    public int size() {
        return Math.toIntExact(Arrays.stream(this.trees).filter(Objects::nonNull).count());
    }

    public boolean isEmpty() {
        return this.leafPos <= 0;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
         if (Objects.nonNull(this.trees[i])) {
             sb.append("[ " + i + ": " + this.trees[i] + " ] ");
         }
        }
//        Arrays.stream(this.trees).forEach(heap -> sb.append("[ " + heap.toString() + " ] "));
        return sb.toString();
    }

    protected void resizeCapacityIfFull(int capacityResizeNum) {
        System.out.println(this.size());
        if (this.size() > this.capacity) {
            this.capacity *= capacityResizeNum;
            Double[] tempTree = this.trees;
            this.trees = new Double[capacity];
            for (int i = 0; i < tempTree.length; i++) {
                this.trees[i] = tempTree[i];
            }
        }
    }
}
