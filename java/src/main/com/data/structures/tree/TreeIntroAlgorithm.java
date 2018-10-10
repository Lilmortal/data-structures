package com.data.structures.tree;

import com.data.structures.ExitException;
import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class TreeIntroAlgorithm extends Algorithm {
    private TreeResource treeResource;

    public TreeIntroAlgorithm(TreeResource treeResource) {
        this.treeResource = treeResource;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Which tree algorithm you want to test, type the number:");
        System.out.println("1. Min heap");
        System.out.println("2. Max heap");
        System.out.println("3. Binary search trees (IN PROGRESS)");
        System.out.println("4. Red black trees (IN PROGRESS)");
        System.out.println("5. AVL (IN PROGRESS)");
    }

    @Override
    protected String execute(String input, BufferedReader br) throws InvalidInputException {
        Tree tree = treeResource.getTree(input);

        // TODO: Notify user if it is heap, can only remove()
        try {
            TreeAlgorithm treeAlgorithm = new TreeAlgorithm(tree);
            treeAlgorithm.run(br);
        } catch (ExitException e) {
            // Do nothing, it is exited here
        }

        return null;
    }
}
