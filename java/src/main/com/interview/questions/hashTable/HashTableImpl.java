package com.interview.questions.hashTable;

import com.interview.questions.linkedList.LinkedList;
import com.interview.questions.linkedList.LinkedListImpl;

import java.util.*;
import java.util.stream.Collectors;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private static int MAX_SIZE = 20;

    private LinkedList<HashTableMap<K, V>>[] table;

    private List<K> keys = new ArrayList<>();

    public HashTableImpl() {
        this.table = new LinkedListImpl[MAX_SIZE];
    }

    @Override
    public V get(K key) {
        int hashCode = Objects.hashCode(key);
        for (int i = 0; i < this.table[hashCode].getSize(); i++) {
            if (this.table[hashCode].get(i).getKey().equals(key)) {
                return this.table[hashCode].get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int hashCode = Objects.hashCode(key);
        HashTableMap<K, V> tuple = new HashTableMap(key, value);
        this.table[hashCode].add(tuple);
        keys.add(key);
    }

    @Override
    public void remove(K key) {
        int hashCode = Objects.hashCode(key);
        if (this.table[hashCode].getSize() == 0) {
            // throw instead of sout, do the same for Queue and Stack
        }

        for (int i = 0; i < this.table[hashCode].getSize(); i++) {
            if (this.table[hashCode].get(i).getKey().equals(key)) {
                this.table[hashCode].remove(i);
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        return true;
//        return keys.stream().anyMatch(key -> this.table[Integer.parseInt(key.toString())].stream().(m -> m.getValue().equals(value)));
    }

    @Override
    public List<HashTableMap<K, V>> getAllValues() {
        List<HashTableMap<K, V>> tuple = new ArrayList<>();
//        keys.stream().sequential().map(key -> this.table[Integer.parseInt(key.toString())].get(0).getValue()).collect(Collectors.toCollection(() -> tuple));
        return tuple;
    }

    @Override
    public int getSize() {
        int hashTableSize = 0;
        for (int i = 0; i < this.table.length; i++) {
            hashTableSize += this.table[i].getSize();
        }
        return hashTableSize;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i].getSize() > 0) {
                return false;
            }
        }
        return true;
    }
}
