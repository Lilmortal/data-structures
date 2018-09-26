package com.interview.questions.hashTable;


import com.interview.questions.algorithms.AlgorithmsFacade;

import java.io.BufferedReader;
import java.io.IOException;

public class HashTableAlgorithmsFacade extends AlgorithmsFacade {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    @Override
    public void run(BufferedReader br) {
        HashTable<String, String> hashTable = new HashTableImpl<>();

        String input;

        try {
            System.out.println("Press 'a' followed by a string to add that to the hash table.");
            System.out.println("Press 'r' to remove an item from the hash table.");
            this.printExitInstructions();

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}