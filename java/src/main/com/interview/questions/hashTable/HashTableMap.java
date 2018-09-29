package com.interview.questions.hashTable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class HashTableMap<K, V> {
    private K key;

    private V value;

    public HashTableMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
