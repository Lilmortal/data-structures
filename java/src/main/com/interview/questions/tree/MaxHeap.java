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
        if (isInBounds(parentPos) && Objects.nonNull(this.heap[parentPos]) && Objects.nonNull(this.heap[pos]) && this.heap[parentPos] < this.heap[pos]) {
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
            if (Objects.nonNull(this.heap[leftChildPos]) && Objects.nonNull(this.heap[rightChildPos])) {
                if (this.heap[leftChildPos] >= this.heap[rightChildPos]) {
                    currentPos = leftChildPos;
                } else if (this.heap[leftChildPos] < this.heap[rightChildPos]) {
                    currentPos = rightChildPos;
                }
            } else if (Objects.nonNull(this.heap[leftChildPos])) {
                currentPos = leftChildPos;
            } else if (Objects.nonNull(this.heap[rightChildPos])) {
                currentPos = rightChildPos;
            }
        }

        if (isInBounds(currentPos) && Objects.nonNull(this.heap[currentPos]) && Objects.nonNull(this.heap[pos]) && this.heap[currentPos] > this.heap[pos]) {
            swap(currentPos, pos);
            heapifyDown(currentPos);
        }
    }
}
