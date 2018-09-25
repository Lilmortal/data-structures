package com.interview.questions.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortingMain {
    private final static String VALID_INPUT_REGEX = "^(\\d+\\s?)+$";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        try {
            while (true) {
                System.out.println("Enter a list of numbers with spaces in between, e.g. 10 20 30.");
                input = br.readLine();

                if (!input.isEmpty() && input.matches(VALID_INPUT_REGEX)) {
                    String sortInput = null;
                    while (sortInput == null) {
                        System.out.println("Which sorting algorithm you want to test, type the number:");
                        System.out.println("1. Merge Sort");
                        System.out.println("2. Quick Sort");

                        sortInput = br.readLine();

                        switch (sortInput) {
                            case "1": {
                                MergeSort mergeSort = new MergeSort(input);
                                System.out.println("Merge sort result:");
                                break;
                            }
                            case "2": {
                                MergeSort mergeSort = new MergeSort(input);
                                System.out.println("Quick sort result:");
                                break;
                            }
                            default: {
                                System.out.println("That is the wrong input.");
                                sortInput = null;
                            }
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
