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
    public List<V> get(K key) {
        List<V> values = new ArrayList<>();

        int hashCode = getHashCode(key);

        if (this.table[hashCode] != null) {
            for (int i = 0; i < this.table[hashCode].size(); i++) {
                if (this.table[hashCode].get(i).getKey().equals(key)) {
                    values.add(this.table[hashCode].get(i).getValue());
                }
            }
        }
        return values;
    }

    @Override
    public void put(K key, V value) {
        int hashCode = getHashCode(key);
        HashTableMap<K, V> tuple = new HashTableMap(key, value);

        if (this.table[hashCode] == null) {
            this.table[hashCode] = new LinkedListImpl<>();
        }

        this.table[hashCode].add(tuple);
        keys.add(key);
    }

    @Override
    public void remove(K key) {
        int hashCode = getHashCode(key);
        if (this.table[hashCode] == null || this.table[hashCode].size() == 0) {
            System.out.println(key + " is missing in hash table.");
            return;
        }

//        List<Integer> indexToBeRemoved = new ArrayList<>();
//
//        indexToBeRemoved = Arrays.stream(this.table)
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .filter(map -> map.getKey().equals(key))
//                .sorted(Collections.reverseOrder())
//                .collect(Collectors.toList());
        // TODO: infinite loop if dont remove
        for (int i = this.table[hashCode].size(); i >= 0; i--) {
            if (this.table[hashCode] != null && this.table[hashCode].get(i) != null && this.table[hashCode].get(i).getKey().equals(key)) {
                this.table[hashCode].remove(i);
            }
        }
    }

    @Override
    public void remove(K key, V value) {
        int hashCode = getHashCode(key);
        if (this.table[hashCode] == null || this.table[hashCode].size() == 0) {
            System.out.println(key + " is missing in hash table.");
            return;
        }

        List<Integer> indexToBeRemoved = new ArrayList<>();
        for (int i = 0; i < this.table[hashCode].size(); i++) {
            if (this.table[hashCode].get(i).getKey().equals(key) && this.table[hashCode].get(i).getValue().equals(value)) {
                indexToBeRemoved.add(i);
            }
        }

        indexToBeRemoved.stream().forEach(index -> this.table[hashCode].remove((int)index));
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        return Arrays.stream(this.table)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .anyMatch(map -> map.getValue().equals(value));
    }

    @Override
    public List<V> getAllValues() {
        return Arrays.stream(this.table)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(HashTableMap::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public int getSize() {
        int hashTableSize = 0;
        for (int i = 0; i < this.table.length; i++) {
            hashTableSize += this.table[i].size();
        }
        return hashTableSize;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i].size() > 0) {
                return false;
            }
        }
        return true;
    }

    private int getHashCode(K key) {
        int numOfChars = key.toString().replace(" ", "").length();
        return numOfChars % MAX_SIZE;
    }

    @Override
    public List<String> getUi() {
        return Arrays.stream(this.table)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(HashTableMap::toString)
                .collect(Collectors.toList());
    }
}
