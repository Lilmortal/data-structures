package com.interview.questions.queue;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class QueueAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Queue<String> queue = new QueueImpl<>();

    private Queue<String> linkedListQueue = new QueueLinkedListImpl<>();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the stack.");
        System.out.println("Press 'r' to remove an item from the stack.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        StringBuilder sb = new StringBuilder();

        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a string to add into the stack");
            }

            queue.add(input.substring(1));
            linkedListQueue.add(input.substring(1));

            sb.append("Queue:");
            sb.append(queue.getQueueUi());

            sb.append("Linked List Queue:");
            sb.append(linkedListQueue.getQueueUi());
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            queue.remove();
            linkedListQueue.remove();

            sb.append("Queue:");
            sb.append(queue.getQueueUi());

            sb.append("Linked List Queue:");
            sb.append(linkedListQueue.getQueueUi());
        } else {
            System.out.println();
            System.out.println("Please enter a valid input.");
        }
        return sb.toString();
    }
}
