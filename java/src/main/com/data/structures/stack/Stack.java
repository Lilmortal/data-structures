package com.data.structures.stack;

import com.data.structures.InvalidInputException;

public interface Stack<T> {
    T pop() throws InvalidInputException;

    void push(T obj);

    T peek(int pos);

    String getStackUi();

    boolean isEmpty();
}

