package com.interview.questions.stack;

public interface Stack<T> {
    T pop();

    void push(T obj);

    T peek(int pos);

    boolean isEmpty();
}

