package com.interview.questions.stack;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class StackAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Stack<String> stack = new StackImpl<>();

    private Stack<String> linkedListStack = new StackLinkedListImpl<>();
    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a string to add that to the queue.");
        System.out.println("Press 'r' to remove one item from the queue.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a string to add into the stack");
            }
            stack.push(input.substring(1));
            linkedListStack.push(input.substring(1));
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            stack.pop();
            linkedListStack.pop();
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }

        return printResult();

    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Stack:");
        sb.append("\n");
        sb.append(stack.getStackUi());
        sb.append("\n");

        sb.append("Linked List Stack:");
        sb.append("\n");
        sb.append(linkedListStack.getStackUi());
        sb.append("\n");
        return sb.toString();
    }
}
