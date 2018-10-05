package com.interview.questions.hashTable;


import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class HashTableAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private static final char SPACE = ' ';

    private static final char COMMA = ',';

    private HashTable<String, String> hashTable = new HashTableImpl<>();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a space and tuple with a comma in between to add that to the hash table. (e.g. a key,value)");
        System.out.println("Press 'r' followed by a space and a key to remove that key from the hash table. (e.g. r key)");
        System.out.println("Press 'r' followed by a space and a tuple to remove that tuple from the hash table. (e.g. r key,value)");
    }

    @Override
    public String execute(String input, BufferedReader br) {
        StringBuilder sb = new StringBuilder();

        if (!input.isEmpty()) {
            if (input.indexOf(SPACE) == -1) {
                throw new InvalidInputException("-- Please enter a space. --");
            }

            String tuple = input.substring(input.indexOf(SPACE) + 1, input.length());
            String key;
            String value;
            if (tuple.indexOf(COMMA) != -1) {
                key = tuple.substring(0, tuple.indexOf(COMMA));
                value = tuple.substring(tuple.indexOf(COMMA) + 1, tuple.length());
            } else if (!String.valueOf(input.charAt(0)).equals(REMOVE)) {
                throw new InvalidInputException("-- Please enter a comma. --");
            } else {
                key = tuple;
                value = tuple;
            }

            if (key.isEmpty()) {
                throw new InvalidInputException("-- Please enter a key. --");
            }

            if (value.isEmpty()) {
                throw new InvalidInputException("-- Please enter a value. --");
            }

            if (String.valueOf(input.charAt(0)).equals(ADD)) {
                hashTable.put(key, value);

                sb.append("Hash Table:");
                sb.append(hashTable.getUi());

            }

            if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
                if (tuple.indexOf(COMMA) != -1) {
                    hashTable.remove(key, value);
                } else {
                    hashTable.remove(key);
                }

                sb.append("Hash Table:");
                sb.append(hashTable.getUi());
            }
        }
        return sb.toString();
    }
}