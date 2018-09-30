package com.interview.questions.sort;

import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SortAlgorithm extends Algorithm {
    private SortResource sortResource = new SortResource();

    @Override
    protected void printInstructions() {
        System.out.println("Enter a list of numbers with spaces in between, e.g. 10 20 30.");
    }

    @Override
    public void execute(String input, BufferedReader br) throws ExitException, IOException {
        if (Input.isValid(input)) {
            String sortInput = null;
            while (Objects.isNull(sortInput)) {
                System.out.println();
                System.out.println("Which sorting algorithm you want to test, type the number:");
                System.out.println("1. Insertion Sort");
                System.out.println("2. Merge Sort");
                System.out.println("3. Quick Sort");

                sortInput = br.readLine();
                try {
                    sortResource.setSort(sortInput);

                    System.out.println();
                    System.out.println(sortResource.getSortName() + " result:");
                    System.out.println(Arrays.toString(sortResource.getSortedUserInput(input)));
                    System.out.println();
                } catch (InvalidInputException e) {
                    System.out.println("That is the wrong input.");
                    sortInput = null;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            System.out.println("Please enter valid input.");
        }
    }
}


