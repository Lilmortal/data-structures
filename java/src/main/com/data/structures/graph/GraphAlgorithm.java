package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;
import com.data.structures.heap.Heap;

import java.io.BufferedReader;

public class GraphAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private static final String JOIN = "j";

    private static final Character SPACE = ' ';

    private Graph graph;

    public GraphAlgorithm(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add a vertex to the graph. e.g. (a20)");
        System.out.println("Press 'j' followed by a number and a space another number to add an edge. e.g. (j10 20)");
        System.out.println("Press 'r' followed by a number to remove the vertex from the graph. e.g. (r20)");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        if (input.length() <= 1) {
            throw new InvalidInputException("Press enter a number to add into the graph");
        }

        String userInput = input.substring(1);

        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            try {
                Integer vertex = Integer.parseInt(userInput);
                this.graph.addVertex(vertex);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers");
            }
        } else if (String.valueOf(input.charAt(0)).equals(JOIN)) {
            if (input.indexOf(SPACE) == -1) {
                throw new InvalidInputException("Please enter a space");
            }
            try {
                Integer firstVertex = Integer.parseInt(userInput.substring(0, userInput.indexOf(SPACE)));
                Integer secondVertex = Integer.parseInt(userInput.substring(userInput.indexOf(SPACE) + 1));
                this.graph.addEdge(firstVertex, secondVertex, 5);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers only");
            }
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            try {
                Integer vertex = Integer.parseInt(userInput);
                this.graph.removeVertex(vertex);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter numbers");
            }
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
