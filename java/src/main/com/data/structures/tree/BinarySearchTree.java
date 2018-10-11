package com.data.structures.tree;

import com.data.structures.InvalidInputException;

import java.util.Objects;

public class BinarySearchTree extends BaseTree {
    @Override
    protected void insertValue(Double value) {
        insert(value, 0);
    }

    @Override
    public void remove(Double value) throws InvalidInputException {
        int pos = getValuePosition(value, 0);
        remove(pos);
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

    private void remove(int pos) {
        this.trees[pos] = null;

        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        if (this.trees[rightChildPos] != null) {
            int mostLeftChildPos = getMostLeftestChild(rightChildPos);
            swap(mostLeftChildPos, pos);

            int mostLeftChildRightChildPos = getRightChildPos(mostLeftChildPos);
            if (this.trees[mostLeftChildRightChildPos] != null) {
                Double[] subTree = getSubTreeViaPreOrderTraversal(new Double[this.trees.length], mostLeftChildRightChildPos, 0);
                moveSubTreeToLeftChild(subTree, mostLeftChildPos, 0);
            }

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

    private Double[] getSubTreeViaPreOrderTraversal(Double[] array, int pos, int newArrayPos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        int newLeftChildPos = getLeftChildPos(newArrayPos);
        int newRightChildPos = getRightChildPos(newArrayPos);

        if (this.trees[pos] != null) {
            array[newArrayPos] = this.trees[pos];
            this.trees[pos] = null;
        }

        if (this.trees[leftChildPos] != null) {
            array = getSubTreeViaPreOrderTraversal(array, leftChildPos, newLeftChildPos);
        }

        if (this.trees[rightChildPos] != null) {
            array = getSubTreeViaPreOrderTraversal(array, rightChildPos, newRightChildPos);
        }

        return array;
    }

    private void moveSubTreeToLeftChild(Double[] subTree, int pos, int newArrayPos) {
        int leftChildPos = getLeftChildPos(pos);
        int rightChildPos = getRightChildPos(pos);

        int newLeftChildPos = getLeftChildPos(newArrayPos);
        int newRightChildPos = getRightChildPos(newArrayPos);

        this.trees[pos] = subTree[newArrayPos];
        if (subTree[newLeftChildPos] != null) {
            moveSubTreeToLeftChild(subTree, leftChildPos, newLeftChildPos);
        }

        if (subTree[newRightChildPos] != null) {
            moveSubTreeToLeftChild(subTree, rightChildPos, newRightChildPos);
        }
    }
}
