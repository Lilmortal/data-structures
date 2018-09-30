package com.interview.questions.tree;

public interface Heap<T> {
    Heap<T> getLeftChild()
    void insert(T value);

    void remove(T value);

    int getSize();
}
