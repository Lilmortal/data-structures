package com.interview.questions.hashTable;

import com.interview.questions.linkedList.LinkedList;

import java.util.List;

public interface HashTable<K, V> {
    LinkedList<V> get(K key);

    void put(K key, V value);

    void remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    List<V> getAllValues();

    int getSize();

    boolean isEmpty();
}
