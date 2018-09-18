package com.interview.questions.linkedList;

public interface LinkedList<T> {
    void add(T value);

    void remove(T value);

    boolean contains(T value);

    Node getFirstNode();

    Node getLastNode();

    int getSize();
}
