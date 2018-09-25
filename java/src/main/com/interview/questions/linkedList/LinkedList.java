package com.interview.questions.linkedList;

public interface LinkedList<T> {
    void add(T value);

    void add(T value, int pos);

    void remove(T value);

    boolean contains(T value);

    Node getFirstNode();

    Node getLastNode();

    int getSize();
}
