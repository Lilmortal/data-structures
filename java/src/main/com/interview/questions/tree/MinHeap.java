package com.interview.questions.tree;

import java.util.Collection;
import java.util.Iterator;

public class MinHeap<T> implements Heap<T> {
    private int size;

    private MinHeap<T> left;
    private MinHeap<T> right;

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public void insert(T value) {
        // insert into last leaf
        // switch with parent if value < parent recursively
    }

    @Override
    public T pop() {
        // remove root
        // switch last leaf to root
        // compare with left node, if root > left node, swap recursively
        // compare with right node, if root > right node, swap recursively
        // how to keep it balanced
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }
}
