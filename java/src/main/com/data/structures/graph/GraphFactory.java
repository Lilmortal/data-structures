package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.heap.Heap;
import com.data.structures.heap.MaxHeap;
import com.data.structures.heap.MinHeap;

public class GraphFactory {
    public Graph getGraph(String graph) throws InvalidInputException {
        switch (graph) {
            case "adjacencyList": {
                return new AdjacencyListsGraph();
            }
            case "adjacencyMatrix": {
                return new AdjacencyMatrixGraph();
            }
            default:
                throw new InvalidInputException("Invalid input");
        }
    }
}
