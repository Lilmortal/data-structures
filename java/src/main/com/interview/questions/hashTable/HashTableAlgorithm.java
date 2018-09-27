package com.interview.questions.hashTable;


import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class HashTableAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the hash table.");
        System.out.println("Press 'r' to remove an item from the hash table.");
    }

    @Override
    public void execute(String input, BufferedReader br) throws IOException {
        HashTable<String, String> hashTable = new HashTableImpl<>();

        while (true) {
            input = br.readLine();

            if (!input.isEmpty()) {
                if (String.valueOf(input.charAt(0)).equals(ADD)) {
                    if (input.length() <= 1) {
                        System.out.println("Press enter a string to add into the hash table.");
                        continue;
                    }

                    hashTable.add(input.substring(1), "");

                    System.out.println("Hash Table:");
                    System.out.println(hashTable);

                }

                if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
                    hashTable.remove("");

                    System.out.println("Hash Table:");
                    System.out.println(hashTable);
                }
            }
        }
    }
}