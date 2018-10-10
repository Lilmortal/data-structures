package com.data.structures.sort;

import com.data.structures.ExitException;
import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;

import java.io.BufferedReader;

public class SortIntroAlgorithm extends Algorithm {
    private SortResource sortResource;

    public SortIntroAlgorithm(SortResource sortResource) {
        this.sortResource = sortResource;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Which sorting algorithm you want to test, type the number:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
    }

    @Override
    public String execute(String input, BufferedReader br) throws ExitException, InvalidInputException {
        Sort sort = sortResource.getSort(input);

        try {
            SortAlgorithm sortAlgorithm = new SortAlgorithm(sort);
            sortAlgorithm.run(br);
        } catch (ExitException e) {
            // Do nothing, it is exited here
        }

        return null;
    }
}


