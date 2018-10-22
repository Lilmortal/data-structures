package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.queue.Queue;

import java.util.Collection;
import java.util.List;

public interface Graph<Integer> {
    boolean contains(Integer item);

    void addVertex(Integer vertex);

    void removeVertex(Integer vertex);

    void addEdge(Integer from, Integer to, Integer weight);

    void removeEdge(Integer from, Integer to);

    void depthFirstSearch(Integer start);

    void breadthFirstSearch(Integer start) throws InvalidInputException;
    
    String getName();
}
