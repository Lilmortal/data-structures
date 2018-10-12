package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;
import com.data.structures.heap.Heap;

import java.io.BufferedReader;

public class GraphAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private Graph graph;

    public GraphAlgorithm(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add that to the graph. e.g. (a20)");
        System.out.println("Press 'r' to remove an item from the graph.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 1) {
                throw new InvalidInputException("Press enter a number to add into the graph");
            }

            Double userInput;
            try {
                userInput = Double.parseDouble(input.substring(1));
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers only");
            }

//            this.graph.insert(userInput);

        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
//            this.graph.remove();
        } else {
            throw new InvalidInputException("Please enter a valid input");
        }
        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(this.graph.getName() + ":");
        sb.append("\n");
        sb.append(this.graph.toString());
        sb.append("\n");
        return sb.toString();
    }
}
