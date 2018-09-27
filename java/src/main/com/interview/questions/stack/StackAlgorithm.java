package com.interview.questions.stack;

import com.interview.questions.ExitException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class StackAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Stack<String> stack = new StackImpl<>();

    private Stack<String> linkedListStack = new LinkedListStack<>();
    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the queue.");
        System.out.println("Press 'r' to remove one item from the queue.");
    }

    @Override
    public void execute(String input, BufferedReader br) throws ExitException, IOException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                System.out.println("Press enter a string to add into the stack.");
                return;
            }
            stack.push(input.substring(1));
            linkedListStack.push(input.substring(1));

            System.out.println("Stack:");
            System.out.println(stack.getStackUi());

            System.out.println("Linked List Stack:");
            System.out.println(linkedListStack.getStackUi());
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            stack.pop();
            linkedListStack.pop();

            System.out.println("Stack:");
            System.out.println(stack.getStackUi());

            System.out.println("Linked List Stack:");
            System.out.println(linkedListStack.getStackUi());
        } else {
            System.out.println();
            System.out.println("Please enter a valid input.");
        }
    }
}
