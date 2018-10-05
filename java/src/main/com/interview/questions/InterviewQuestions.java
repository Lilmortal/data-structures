package com.interview.questions;

import com.interview.questions.algorithm.Algorithm;
import com.interview.questions.algorithm.AlgorithmFactory;
import com.interview.questions.algorithm.AlgorithmResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class InterviewQuestions {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printIntro();

        String input;
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmResource resource = new AlgorithmResource(algorithmFactory);
        Algorithm algorithm;

        while (true) {
            try {
                input = br.readLine();

                if (!input.isEmpty()) {
                    try {
                        algorithm = resource.getAlgorithm(input);
                    } catch (InvalidInputException e) {
                        System.out.println();
                        System.out.println("-- SortInput is invalid. Please enter a valid algorithm number. --");
                        System.out.println();
                        printIntro();
                        continue;
                    }

                    if (Objects.nonNull(algorithm)) {
                        try {
                            algorithm.run(br);
                        } catch (ExitException e) {
                            // do nothing, it is exited.
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        printIntro();
                    }
                } else {
                    System.out.println("-- Please enter an algorithm number. --");
                    System.out.println();
                    printIntro();
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    private synchronized static void printIntro() {
        System.out.println("Which algorithm/data structures you want to test: ");
        System.out.println("1. Linked List");
        System.out.println("2. Queue");
        System.out.println("3. Stack");
        System.out.println("4. Hash Table");
        System.out.println("5. Sorting");
        System.out.println("6. Trees (IN PROGRESS)");
        System.out.println("7. Graphs (IN PROGRESS)");
    }
}
