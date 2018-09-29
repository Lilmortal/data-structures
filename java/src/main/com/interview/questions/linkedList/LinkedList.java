package com.interview.questions.linkedList;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface LinkedList<T> {
    void forEach(Predicate<T> consumer);

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
