package com.interview.questions.tree;

import com.interview.questions.InvalidInputException;

import java.util.Objects;

public class BinarySearchTree extends BaseTree implements Tree {
    @Override
    public void insert(Double value) throws InvalidInputException {
        this.resizeCapacityIfFull(2);
        insert(value, 0);
    }

    @Override
    public Double pop() throws InvalidInputException {
        return null;
    }

    @Override
    public String getName() {
        return "Binary Search Tree";
    }

    private void insert(Double value, int pos) throws InvalidInputException {
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
}
