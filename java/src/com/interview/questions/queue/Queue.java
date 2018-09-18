package com.interview.questions.queue;

public interface Queue<T> {
    T remove();

    void add(T obj);

    boolean isEmpty();

    T peek(int pos);
}
