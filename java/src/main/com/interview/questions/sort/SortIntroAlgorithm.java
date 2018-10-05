package com.interview.questions.sort;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;

public class SortIntroAlgorithm extends Algorithm {
    private SortResource sortResource;

    public SortIntroAlgorithm(SortResource sortResource) {
        this.sortResource = sortResource;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Enter a list of numbers with spaces in between, e.g. 10 20 30.");
    }

    @Override
    public String execute(String input, BufferedReader br) throws ExitException, InvalidInputException {
        if (SortInput.isValid(input)) {
            SortAlgorithm sortAlgorithm = new SortAlgorithm(this.sortResource, input);
            sortAlgorithm.run(br);
            return null;
        } else {
            throw new InvalidInputException("Please enter the numbers in this format e.g. 10 20 30");
        }
    }
}


