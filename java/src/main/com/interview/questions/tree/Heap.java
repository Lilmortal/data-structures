package com.interview.questions.tree;

import java.util.Collection;

public interface Heap<T> {
    void insert(T value);

    T pop();

    T first();

    T last();

    int size();

    boolean isEmpty();
}
