package com.interview.questions.tree;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;

public class TreeIntroAlgorithm extends Algorithm {
    @Override
    protected void printInstructions() {
        System.out.println("Which tree algorithm you want to test, type the number:");
        System.out.println("1. Min heap");
        System.out.println("2. Max heap");
        System.out.println("3. Binary search trees");
        System.out.println("4. Red black trees");
        System.out.println("5. AVL");
    }

    @Override
    protected String execute(String input, BufferedReader br) throws ExitException, InvalidInputException {
        TreeFactory treeFactory = new TreeFactory();
        TreeResource treeResource = new TreeResource(treeFactory);

        Tree tree = treeResource.getTree(input);

        try {
            TreeAlgorithm treeAlgorithm = new TreeAlgorithm(tree);
            treeAlgorithm.run(br);
        } catch (ExitException e) {
            // Do nothing, it is exited here
        }

        return null;
    }
}
