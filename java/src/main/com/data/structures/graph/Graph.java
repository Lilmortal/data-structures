package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.queue.Queue;

import java.util.Collection;
import java.util.List;

public interface Graph<Integer> {
    boolean contains(Integer item);

    void addVertex(Integer vertex);

    boolean areAdjacent(Integer a, Integer b);

    void removeVertex(Integer vertex);

    void addEdge(Integer from, Integer to, Integer weight);

    void removeEdge(Integer from, Integer to);

    Collection<Integer> getNeighboursForT(Integer vertex);

    Queue<Integer> depthFirstSearch(Integer start);

    Queue<Integer> breadthFirstSearch(Integer start) throws InvalidInputException;
    
    String getName();
}
