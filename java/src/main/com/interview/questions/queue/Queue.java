package com.interview.questions.queue;

import com.interview.questions.InvalidInputException;

public interface Queue<T> {
    T remove() throws InvalidInputException;

    void add(T obj) throws InvalidInputException;

    boolean isEmpty();

    String getQueueUi();

    T peek(int pos);
}
