package com.interview.questions.linkedList;

import com.interview.questions.ExitException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class LinkedListAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private LinkedList linkedList = new LinkedListImpl();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the linked list.");
        System.out.println("Press 'r' to remove an item from the linked list.");
    }

    @Override
    public void execute(String input, BufferedReader br) throws ExitException, IOException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                System.out.println("Press enter a string to add into the linked list.");
                return;
            }

            linkedList.add(input.substring(1));

            System.out.println("Linked List:");
            System.out.println(linkedList.getLastNode());
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            linkedList.remove(linkedList.getSize() - 1);

            System.out.println("Linked List:");
            System.out.println(linkedList.getLastNode());
        } else {
            System.out.println();
            System.out.println("Please enter a valid input.");
        }
    }
}
