package com.interview.questions.linkedList;

public interface LinkedList<T> {
    void add(T value);

    void add(T value, int pos);

    void remove(T value);

    void remove(int pos);

    void clear();

    T get(int pos);

    boolean contains(T value);

    Node getFirstNode();

    Node getLastNode();

    int getSize();

    String getLinkedListUi();
}
