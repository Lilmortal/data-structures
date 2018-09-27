package com.interview.questions;

import com.interview.questions.algorithm.Algorithm;
import com.interview.questions.algorithm.AlgorithmResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterviewQuestions {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        printIntro();

        String input = null;
        AlgorithmResource resource = new AlgorithmResource();
        Algorithm facade = null;

        while (true) {
            try {
                input = br.readLine();

                if (!input.isEmpty()) {
                    try {
                        facade = resource.getFacade(input);
                    } catch (InvalidInputException e) {
                        System.out.println("Input is invalid. Please enter a valid input.");
                        continue;
                    }

                    if (facade != null) {
                        try {
                            facade.run(br);
                        } catch (ExitException e) {
                            printIntro();
                        }
                    }
                } else {
                    System.out.println("Please enter an input.");
                }
            } catch (IOException e) {
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
    }
}
