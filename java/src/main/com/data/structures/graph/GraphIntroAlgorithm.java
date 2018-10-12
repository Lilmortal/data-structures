package com.data.structures.graph;

import com.data.structures.ExitException;
import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class GraphIntroAlgorithm extends Algorithm {
    private GraphResource graphResource;

    public GraphIntroAlgorithm(GraphResource graphResource) {
        this.graphResource = graphResource;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Which graph algorithm you want to test, type the number:");
        System.out.println("1. Undirected graph");
        System.out.println("2. Directed graph");
        System.out.println("3. Acyclic graph");
        System.out.println("4. Topological sorting");
        System.out.println("5. DAG");
        System.out.println("6. Minimum spanning tree");
        System.out.println("7. Backtracking");
        System.out.println("8. Shortest path");
        System.out.println("9. Maximum flow");
    }

    @Override
    protected String execute(String input, BufferedReader br) throws InvalidInputException {
        Graph graph = graphResource.getGraph(input);

        try {
            GraphAlgorithm graphAlgorithm = new GraphAlgorithm(graph);
            graphAlgorithm.run(br);
        } catch (ExitException e) {
            // Do nothing, it is exited here
        }

        return null;
    }
}
