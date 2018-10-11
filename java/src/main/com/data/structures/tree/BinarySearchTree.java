package com.data.structures.tree;

import com.data.structures.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree extends BaseTree {
    @Override
    protected void insertValue(Double value) {
        insert(value, 0);
    }

    @Override
    public void remove(Double value) throws InvalidInputException {
        int pos = getValuePosition(value, 0);
        // Test 10,5,30,50,35,40,39 and remove 30
        remove(value, pos);
    }

    @Override
    public Double get(int pos) {
        return this.trees[pos];
    }

    @Override
    public String getName() {
        return "Binary Search Tree";
    }

    private void insert(Double value, int pos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        Double posValue = this.trees[pos];
        if (Objects.isNull(posValue)) {
            this.trees[pos] = value;
        } else if (value <= posValue) {
            insert(value, leftChildPos);
        } else if (value > posValue) {
            insert(value, rightChildPos);
        }
    }

    private void remove(Double value, int pos) {
        this.trees[pos] = null;

        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (this.trees[rightChildPos] != null) {
            int mostLeftChildPos = getMostLeftestChild(rightChildPos);
            swap(mostLeftChildPos, pos);

            Double[] test = new Double[100];
            Double[] subTreeToBeMoved = getPreTraversal(test, mostLeftChildPos);

        } else if (this.trees[leftChildPos] != null) {
            swap(leftChildPos, pos);
        }
    }

    private int getValuePosition(Double value, int pos) throws InvalidInputException {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (this.trees[pos] != null && this.trees[pos].equals(value)) {
            return pos;
        } else if (this.trees[leftChildPos] != null && value <= this.trees[leftChildPos]) {
            return getValuePosition(value, leftChildPos);
        } else if (this.trees[rightChildPos] != null && value >= this.trees[rightChildPos]) {
            return getValuePosition(value, rightChildPos);
        } else {
            throw new InvalidInputException("Something is not right...");
        }
    }

    private int getMostLeftestChild(int pos) {
        int leftChildPos = getLeftChildPos(pos);

        if (this.trees[leftChildPos] != null) {
            return getMostLeftestChild(leftChildPos);
        } else {
            return pos;
        }
    }

    private Double[] getPreTraversal(Double[] array, int pos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (this.trees[pos] != null) {
            array[pos] = this.trees[pos];
            this.trees[pos] = null;
        }

        if (this.trees[leftChildPos] != null) {
            array = getPreTraversal(array, leftChildPos);
        }

        if (this.trees[rightChildPos] != null) {
            array = getPreTraversal(array, rightChildPos);
        }

        return array;
    }
}
