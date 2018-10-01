package com.interview.questions.linkedList;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface LinkedList<T> extends Collection<T> {
    List<T> getAllValues();

//    void add(T value);

    void add(T value, int pos);

//    void remove(T value);

    void remove(int pos);

    void clear();

    T get(int pos);

//    boolean contains(T value);

    LinkedListNode getFirstNode();

    LinkedListNode getLastNode();

    int getSize();

    String getLinkedListUi();
}
