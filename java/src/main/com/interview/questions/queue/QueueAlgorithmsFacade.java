package com.interview.questions.queue;

import com.interview.questions.Algorithms;
import com.interview.questions.ExitException;
import com.interview.questions.algorithms.AlgorithmsFacade;

import java.io.BufferedReader;
import java.io.IOException;

public class QueueAlgorithmsFacade extends AlgorithmsFacade {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    @Override
    public void run(BufferedReader br) throws ExitException {
        Queue<String> queue = new QueueImpl<>();
        Queue<String> linkedListQueue = new LinkedListQueue<>();

        String input;

        try {
            System.out.println("Press 'a' followed by a string to add that to the stack.");
            System.out.println("Press 'r' to remove an item from the stack.");
            this.printExitInstructions();

            while (true) {
                input = br.readLine();

                if (!input.isEmpty()) {
                    if (input.equals(Algorithms.EXIT)) {
                        throw new ExitException();
                    }

                    if (String.valueOf(input.charAt(0)).equals(ADD)) {
                        if (input.length() <= 1) {
                            System.out.println("Press enter a string to add into the stack.");
                            continue;
                        }

                        queue.add(input.substring(1));
                        linkedListQueue.add(input.substring(1));

                        System.out.println("Queue:");
                        System.out.println(queue.getQueueUi());

                        System.out.println("Linked List Queue:");
                        System.out.println(linkedListQueue.getQueueUi());
                    }

                    if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
                        queue.remove();
                        linkedListQueue.remove();

                        System.out.println("Queue:");
                        System.out.println(queue.getQueueUi());

                        System.out.println("Linked List Queue:");
                        System.out.println(linkedListQueue.getQueueUi());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
