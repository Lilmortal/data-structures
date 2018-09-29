package com.interview.questions.hashTable;


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
        System.out.println("Press 'r' followed by a space and a key to remove that item from the hash table. (e.g. r key)");
    }

    @Override
    public void execute(String input, BufferedReader br) throws IOException {
        if (!input.isEmpty()) {
            if (input.indexOf(SPACE) == -1) {
                System.out.println();
                System.out.println("-- Please enter a space. --");
                System.out.println();
                return;
            }

            String tuple = input.substring(input.indexOf(SPACE) + 1, input.length());
            String key = tuple.substring(0, tuple.indexOf(COMMA));
            String value = tuple.substring(tuple.indexOf(COMMA) + 1, tuple.length());

            if (key.isEmpty()) {
                System.out.println();
                System.out.println("-- Please enter a key. --");
                System.out.println();
                return;
            }

            if (value.isEmpty()) {
                System.out.println();
                System.out.println("-- Please enter a value. --");
                System.out.println();
                return;
            }

            if (String.valueOf(input.charAt(0)).equals(ADD)) {
                hashTable.put(key, value);

                System.out.println("Hash Table:");
                System.out.println(hashTable.getAllValues());

            }

            if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
                hashTable.remove(key);

                System.out.println("Hash Table:");
                System.out.println(hashTable.getAllValues());
            }

        }
    }
}