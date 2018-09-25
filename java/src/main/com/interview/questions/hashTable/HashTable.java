package com.interview.questions.hashTable;

public interface HashTable<K, V> {
    void add(K key, V value);

    void remove(K key);

    void remove(K key, V value);

    void peek(K key);
}
