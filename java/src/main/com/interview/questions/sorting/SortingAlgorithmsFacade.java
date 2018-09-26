package com.interview.questions.sorting;

import com.interview.questions.Algorithms;
import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;
import com.interview.questions.algorithms.AlgorithmsFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SortingAlgorithmsFacade implements AlgorithmsFacade {
    @Override
    public void run(BufferedReader br) throws ExitException {
        SortResource sortResource = new SortResource();
        String input;

        try {
            while (true) {
                System.out.println("Enter a list of numbers with spaces in between, e.g. 10 20 30.");
                input = br.readLine();

                if (input.equals(Algorithms.EXIT)) {
                    throw new ExitException();
                }

                if (Input.isValid(input)) {
                    String sortInput = null;
                    while (sortInput == null) {
                        System.out.println();
                        System.out.println("Which sorting algorithm you want to test, type the number:");
                        System.out.println("1. Insertion Sort");
                        System.out.println("2. Merge Sort");
                        System.out.println("3. Quick Sort");

                        sortInput = br.readLine();
                        try {
                            sortResource.setSortingAlgorithm(sortInput);

                            System.out.println();
                            System.out.println(sortResource.getSortingAlgorithmName() + " result:");
                            System.out.println(Arrays.toString(sortResource.getSortedUserInput(input)));
                            System.out.println();
                        } catch (InvalidInputException e) {
                            System.out.println("That is the wrong input.");
                            sortInput = null;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.exit(1);
                        }

                    }
                } else {
                    System.out.println("Please enter valid input.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


