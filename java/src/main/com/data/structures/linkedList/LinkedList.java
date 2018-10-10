package com.data.structures.linkedList;

import com.data.structures.InvalidInputException;

import java.util.Collection;

public interface LinkedList<T> extends Collection<T> {
    void add(T value, int pos) throws InvalidInputException;

    void remove(int pos);

    void clear();

    T get(int pos);

    LinkedListNode getFirstNode();

    LinkedListNode getLastNode();

    String getLinkedListUi();
}
