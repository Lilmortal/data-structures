package com.data.structures.heap;

import java.util.Objects;

public class MinHeap extends BaseHeap {
    @Override
    public String getName() {
        return "Min heap";
    }

    @Override
    protected void heapifyUp(int pos) {
        int parentPos = getParentPos(pos);
        if (isInBounds(parentPos) && Objects.nonNull(this.heaps[parentPos]) && Objects.nonNull(this.heaps[pos]) && this.heaps[parentPos] > this.heaps[pos]) {
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
            if (Objects.nonNull(this.heaps[leftChildPos]) && Objects.nonNull(this.heaps[rightChildPos])) {
                if (this.heaps[leftChildPos] <= this.heaps[rightChildPos]) {
                    currentPos = leftChildPos;
                } else if (this.heaps[leftChildPos] > this.heaps[rightChildPos]) {
                    currentPos = rightChildPos;
                }
            } else if (Objects.nonNull(this.heaps[leftChildPos])) {
                currentPos = leftChildPos;
            } else if (Objects.nonNull(this.heaps[rightChildPos])) {
                currentPos = rightChildPos;
            }
        }

        if (isInBounds(currentPos) && Objects.nonNull(this.heaps[currentPos]) && Objects.nonNull(this.heaps[pos]) && this.heaps[currentPos] < this.heaps[pos]) {
            swap(currentPos, pos);
            heapifyDown(currentPos);
        }
    }
}
