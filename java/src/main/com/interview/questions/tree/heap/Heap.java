package com.interview.questions.tree.heap;

import com.interview.questions.InvalidInputException;
import com.interview.questions.tree.BaseTree;

import java.util.Objects;

public abstract class Heap extends BaseTree {
    protected int leafPos;

    public Heap() {
        this.leafPos = 0;
    }

    @Override
    protected void insertValue(Double value) {
        int parentPos = getParentPos(this.leafPos);

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

    @Override
    public Double last() {
        return this.trees[this.leafPos == 0 ? 0 : this.leafPos - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.leafPos <= 0;
    }

    protected abstract void heapifyUp(int leafPos);

    protected abstract void heapifyDown(int leafPos);
}
