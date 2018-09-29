package com.interview.questions.hashTable;

import java.util.List;

public interface HashTable<K, V> {
    V get(K key);

    void put(K key, V value);

    void remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    List<HashTableMap<K, V>> getAllValues();

    int getSize();

    boolean isEmpty();
}
