package com.interview.questions.hashTable;

import com.interview.questions.linkedList.LinkedList;
import com.interview.questions.linkedList.LinkedListImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private static int MAX_SIZE = 20;

    private LinkedList<V>[] table;

    public HashTableImpl() {
        this.table = new LinkedListImpl[MAX_SIZE];
    }

    @Override
    public LinkedList<V> get(K key) {
        int hashCode = Objects.hashCode(key);
        return this.table[hashCode];
    }

    @Override
    public void put(K key, V value) {
        int hashCode = Objects.hashCode(key);
        this.table[hashCode].add(value);
    }

    @Override
    public void remove(K key) {
        int hashCode = Objects.hashCode(key);
        if (this.table[hashCode].getSize() == 0) {
            // throw instead of sout, do the same for Queue and Stack
        }
        this.table[hashCode].clear();
    }

    @Override
    public boolean containsKey(K key) {
        return this.table[hashCode()].getSize() > 0;
    }

    @Override
    public boolean containsValue(V value) {
        return this.table[hashCode()].contains(value);
    }

    @Override
    public List<V> getAllValues() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            for(int j = 0; j < this.table[i].getSize(); j++) {
                values.add(this.table[i].get(j));
            }
        }
        return values;
    }

    @Override
    public int getSize() {
        int hashTableSize = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            hashTableSize += this.table[i].getSize();
        }
        return hashTableSize;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (this.table[i].getSize() > 0) {
                return false;
            }
        }
        return true;
    }
}
