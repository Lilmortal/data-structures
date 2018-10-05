package com.interview.questions.tree;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class TreeAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Heap minHeap = new MinHeap();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add that to the stack. e.g. (a20)");
        System.out.println("Press 'r' to remove an item from the stack.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws ExitException, InvalidInputException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a number to add into the stack");
            }

            Double userInput;
            try {
                userInput = Double.parseDouble(input.substring(1));
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers only");
            }

            minHeap.insert(userInput);

        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            minHeap.pop();
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }
        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Min heap:");
        sb.append("\n");
        sb.append(minHeap.toString());
        sb.append("\n");
        return sb.toString();
    }
}
