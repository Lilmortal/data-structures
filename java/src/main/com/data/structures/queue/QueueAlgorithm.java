package com.data.structures.queue;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class QueueAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Queue<String> queue = new QueueImpl<>();

    private Queue<String> linkedListQueue = new QueueLinkedListImpl<>();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the stack. e.g. (astring)");
        System.out.println("Press 'r' to remove an item from the stack.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a string to add into the stack");
            }

            queue.add(input.substring(1));
            linkedListQueue.add(input.substring(1));

        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            queue.remove();
            linkedListQueue.remove();
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }

        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Queue:");
        sb.append("\n");
        sb.append(queue.getQueueUi());
        sb.append("\n");

        sb.append("Linked List Queue:");
        sb.append("\n");
        sb.append(linkedListQueue.getQueueUi());
        sb.append("\n");
        return sb.toString();
    }
}
