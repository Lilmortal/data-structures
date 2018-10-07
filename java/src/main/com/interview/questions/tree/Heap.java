package com.interview.questions.tree;

import com.interview.questions.InvalidInputException;

import java.util.Objects;

public abstract class Heap extends BaseTree {
    public void insert(Double value) {
        int parentPos = getParentPos(this.leafPos);
        int rightLeafChildPos = getRightChildPos(this.leafPos);

        if (rightLeafChildPos > capacity) {
            resizeHeap();
        }

        if (this.leafPos == 0) {
            this.trees[0] = value;
        } else if (isInBounds(parentPos)) {
            this.trees[this.leafPos] = value;
            heapifyUp(this.leafPos);

        }
        this.leafPos++;
    }

    public Double pop() throws InvalidInputException {
        Double valueToBePopped = this.trees[0];

        if (Objects.isNull(valueToBePopped)) {
            throw new InvalidInputException("There is nothing in the trees");
        }

        this.trees[0] = null;
        swap(0, this.leafPos - 1);

        heapifyDown(0);

        this.leafPos--;
        return valueToBePopped;
    }

    protected void resizeHeap() {
        this.capacity *= this.capacity;
        Double[] tempHeap = this.trees;
        this.trees = new Double[this.capacity];
        for (int i = 0; i < this.trees.length; i++) {
            this.trees[i] = tempHeap[i];
        }
    }

    protected abstract void heapifyUp(int leafPos);

    protected abstract void heapifyDown(int leafPos);
}
