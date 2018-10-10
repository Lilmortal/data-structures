package com.data.structures.heap;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class HeapAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Heap heap;

    public HeapAlgorithm(Heap heap) {
        this.heap = heap;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add that to the heap. e.g. (a20)");
        System.out.println("Press 'r' to remove an item from the heap.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a number to add into the heap");
            }

            Double userInput;
            try {
                userInput = Double.parseDouble(input.substring(1));
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers only");
            }

            this.heap.insert(userInput);

        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            this.heap.remove();
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }
        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(this.heap.getName() + ":");
        sb.append("\n");
        sb.append(this.heap.toString());
        sb.append("\n");
        return sb.toString();
    }
}
