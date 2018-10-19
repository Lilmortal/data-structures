package com.data.structures.graph;

import java.util.Collection;

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
    public void depthSearch(Integer start) {

    }

    @Override
    public void breathSearch(Integer start) {

    }

    @Override
    public String getName() {
        return null;
    }
}
