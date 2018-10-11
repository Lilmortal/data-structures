package com.data.structures.tree;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class TreeAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Tree tree;

    public TreeAlgorithm(Tree tree) {
        this.tree = tree;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add that to the tree. e.g. (a20)");
        System.out.println("Press 'r' followed by a number to remove that item from the tree. e.g. (r20)");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (input.length() <= 1) {
            throw new InvalidInputException("Press enter a number to add into the tree");
        }

        Double userInput;
        try {
            userInput = Double.parseDouble(input.substring(1));
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter numbers only");
        }

        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            this.tree.insert(userInput);

        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            this.tree.remove(userInput);
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }
        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(this.tree.getName() + ":");
        sb.append("\n");
        sb.append(this.tree.toString());
        sb.append("\n");
        return sb.toString();
    }
}
