package com.interview.questions.tree;

public interface Heap<T> {
    void insert(T value);

    void remove(T value);

    int getSize();
}
