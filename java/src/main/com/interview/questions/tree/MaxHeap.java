package com.interview.questions.tree;

import java.util.Objects;

public class MaxHeap extends Heap implements Tree {
    @Override
    public String getName() {
        return "Max Heap";
    }

    @Override
    protected void heapifyUp(int pos) {
        int parentPos = getParentPos(pos);
        if (isInBounds(parentPos) && Objects.nonNull(this.trees[parentPos]) && Objects.nonNull(this.trees[pos]) && this.trees[parentPos] < this.trees[pos]) {
            swap(parentPos, pos);
            heapifyUp(parentPos);
        }
    }

    @Override
    protected void heapifyDown(int pos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        int currentPos = -1;
        if (isInBounds(leftChildPos) && isInBounds(rightChildPos)) {
            if (Objects.nonNull(this.trees[leftChildPos]) && Objects.nonNull(this.trees[rightChildPos])) {
                if (this.trees[leftChildPos] >= this.trees[rightChildPos]) {
                    currentPos = leftChildPos;
                } else if (this.trees[leftChildPos] < this.trees[rightChildPos]) {
                    currentPos = rightChildPos;
                }
            } else if (Objects.nonNull(this.trees[leftChildPos])) {
                currentPos = leftChildPos;
            } else if (Objects.nonNull(this.trees[rightChildPos])) {
                currentPos = rightChildPos;
            }
        }

        if (isInBounds(currentPos) && Objects.nonNull(this.trees[currentPos]) && Objects.nonNull(this.trees[pos]) && this.trees[currentPos] > this.trees[pos]) {
            swap(currentPos, pos);
            heapifyDown(currentPos);
        }
    }
}
