package com.data.structures.graph;

import java.util.Collection;

public interface Graph<Integer> {
    boolean contains(Integer item);

    void addVertex(Integer vertex);

    boolean areAdjacent(Integer a, Integer b);

    void removeVertex(Integer vertex);

    void addEdge(Integer from, Integer to, Integer weight);

    void removeEdge(Integer from, Integer to);

    Collection<Integer> getNeighboursForT(Integer vertex);

    void depthSearch(Integer start);

    void breathSearch(Integer start);
    
    String getName();
}
