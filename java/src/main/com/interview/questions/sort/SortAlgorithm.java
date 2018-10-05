package com.interview.questions.sort;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SortAlgorithm extends Algorithm {
    private SortResource sortResource;

    private String input;

    public SortAlgorithm(SortResource sortResource, String input) {
        this.sortResource = sortResource;
        this.input = input;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Which sorting algorithm you want to test, type the number:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
    }

    @Override
    public String execute(String input, BufferedReader br) throws InvalidInputException {
        sortResource.setSort(input);

        return printResult();
    }

    private String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(sortResource.getSortName() + " result:\n");
        sb.append(Arrays.toString(sortResource.getSortedUserInput(this.input)) + "\n");
        return sb.toString();
    }
}