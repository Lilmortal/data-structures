package com.data.structures.hashTable;

import com.data.structures.InvalidInputException;

import java.util.List;

public interface HashTable<K, V> {
    List<V> get(K key);

    void put(K key, V value);

    void remove(K key) throws InvalidInputException;

    void remove(K key, V value) throws InvalidInputException;

    boolean containsKey(K key);

    boolean containsValue(V value);

    List<String> getUi();

    List<V> getAllValues();

    int getSize();

    boolean isEmpty();
}
