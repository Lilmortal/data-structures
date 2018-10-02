package com.interview.questions.hashTable;

import java.util.List;

public interface HashTable<K, V> {
    List<V> get(K key);

    void put(K key, V value);

    void remove(K key);

    void remove(K key, V value);

    boolean containsKey(K key);

    boolean containsValue(V value);

    List<String> getUi();

    List<V> getAllValues();

    int getSize();

    boolean isEmpty();
}
