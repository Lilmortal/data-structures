package com.interview.questions.tree;

import com.interview.questions.InvalidInputException;

public class TreeResource {
    private TreeFactory treeFactory;

    public TreeResource(TreeFactory treeFactory) {
        this.treeFactory = treeFactory;
    }

    public Tree getTree(String tree) throws InvalidInputException {
        switch (tree) {
            case "1": {
                return treeFactory.getTree("minHeap");
            }
            case "2": {
                return treeFactory.getTree("maxHeap");
            }
            case "3": {
                return treeFactory.getTree("binarySearch");
            }
            case "4": {
                return treeFactory.getTree("redBlack");
            }
            case "5": {
                return treeFactory.getTree("avl");
            }
            default: {
                throw new InvalidInputException("Invalid input");
            }
        }
    }
}
