package com.interview.questions.tree;

public interface Heap {
    void insert(Double value);

    Double pop();

    Double first();

    Double last();

    int size();

    boolean isEmpty();
}
