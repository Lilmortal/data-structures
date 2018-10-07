package com.interview.questions.tree;

import com.interview.questions.InvalidInputException;

public interface Tree {
    void insert(Double value) throws InvalidInputException;

    Double pop() throws InvalidInputException;

    Double first();

    Double last();

    int size();

    boolean isEmpty();

    String getName();
}
