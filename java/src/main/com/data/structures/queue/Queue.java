package com.data.structures.queue;

import com.data.structures.InvalidInputException;

public interface Queue<T> {
    T remove() throws InvalidInputException;

    void add(T obj) throws InvalidInputException;

    boolean isEmpty();

    String getQueueUi();

    T peek(int pos);
}
