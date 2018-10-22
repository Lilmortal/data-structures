package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;
import com.data.structures.heap.Heap;
import com.data.structures.queue.Queue;

import java.io.BufferedReader;

public class GraphAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private static final String JOIN = "j";

    private static final Character SPACE = ' ';

    private static final String BFS = "b";

    private Graph<Integer> graph;

    public GraphAlgorithm(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a number to add a vertex to the graph. e.g. (a20)");
        System.out.println("Press 'j' followed by 3 numbers with a space in between to add an edge between the first two vertices and a weight. e.g. (j10 20 5)");
        System.out.println("Press 'r' followed by a number to remove the vertex from the graph. e.g. (r20)");
        System.out.println("Press 'b' followed by a number to see a list of vertices retrieved from breadth first search for that vertex.");
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
                throw new InvalidInputException("Please enter the second vertex");
            }
            try {
                int firstSpacePos = userInput.indexOf(SPACE);
                String firstVertex = userInput.substring(0, firstSpacePos);
                if (firstVertex.isEmpty()) {
                    throw new InvalidInputException("Please enter the first vertex");
                }

                int secondSpacePos = userInput.indexOf(SPACE, firstSpacePos + 1);
                String secondVertex = userInput.substring(firstSpacePos + 1, secondSpacePos == -1 ? userInput.length() : secondSpacePos);
                if (secondVertex.isEmpty()) {
                    throw new InvalidInputException("Please enter the second vertex");
                }

                if (secondSpacePos == -1) {
                    throw new InvalidInputException("Please enter the second space");
                }

                String weight = userInput.substring(secondSpacePos + 1);
                if (weight.isEmpty()) {
                    throw new InvalidInputException("Please enter a weight");
                }

                this.graph.addEdge(Integer.parseInt(firstVertex), Integer.parseInt(secondVertex), Integer.parseInt(weight));
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
        } else if (String.valueOf(input.charAt(0)).equals(BFS)) {
            try {
                Integer vertex = Integer.parseInt(userInput);
                Queue<Integer> queue = this.graph.breadthFirstSearch(vertex);
                while(!queue.isEmpty()) {
                    System.out.println(queue.remove());
                }
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
