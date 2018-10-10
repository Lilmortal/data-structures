package com.data.structures.tree;

import com.data.structures.InvalidInputException;

public class TreeResource {
    private TreeFactory treeFactory;

    public TreeResource(TreeFactory treeFactory) {
        this.treeFactory = treeFactory;
    }

    public Tree getTree(String tree) throws InvalidInputException {
        switch (tree) {
            case "1": {
                return treeFactory.getTree("binarySearch");
            }
            case "2": {
                return treeFactory.getTree("redBlack");
            }
            case "3": {
                return treeFactory.getTree("avl");
            }
            default: {
                throw new InvalidInputException("Invalid input");
            }
        }
    }
}
