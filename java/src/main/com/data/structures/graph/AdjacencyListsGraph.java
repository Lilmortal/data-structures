package com.data.structures.graph;

import com.data.structures.queue.Queue;

import java.util.Collection;
import java.util.List;

public class AdjacencyListsGraph implements Graph<Integer> {
    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public void addVertex(Integer vertex) {

    }

    @Override
    public boolean areAdjacent(Integer a, Integer b) {
        return false;
    }

    @Override
    public void removeVertex(Integer vertex) {

    }

    @Override
    public void addEdge(Integer from, Integer to, Integer weight) {

    }

    @Override
    public void removeEdge(Integer from, Integer to) {

    }

    @Override
    public Collection<Integer> getNeighboursForT(Integer vertex) {
        return null;
    }

    @Override
    public Queue<Integer> depthFirstSearch(Integer start) {
        return null;
    }

    @Override
    public Queue<Integer> breadthFirstSearch(Integer start) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
