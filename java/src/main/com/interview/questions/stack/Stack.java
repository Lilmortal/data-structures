package com.interview.questions.stack;

import com.interview.questions.InvalidInputException;

public interface Stack<T> {
    T pop() throws InvalidInputException;

    void push(T obj);

    T peek(int pos);

    String getStackUi();

    boolean isEmpty();
}

