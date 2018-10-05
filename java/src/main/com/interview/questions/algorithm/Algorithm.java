package com.interview.questions.algorithm;

import com.interview.questions.InterviewQuestions;
import com.interview.questions.ExitException;
import com.interview.questions.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Algorithm {
    protected abstract void printInstructions();

    protected abstract String execute(String input, BufferedReader br) throws ExitException;

    protected void printExitInstructions() {
        System.out.println("Type \"exit\" to go back.");
    }

    public final String getResult(BufferedReader br) throws ExitException {
        try {
            String input;

            while (true) {
                this.printInstructions();
                this.printExitInstructions();

                input = br.readLine();

                if (!input.isEmpty()) {
                    if (input.equals(InterviewQuestions.EXIT)) {
                        throw new ExitException();
                    }
                    String result;
                    try {
                        result = execute(input, br);
                    } catch (InvalidInputException e) {
                        System.out.println();
                        // TODO: fix
                        System.out.println(e.getLocalizedMessage());
                        System.out.println();
                        continue;
                    }

                    return result;
                } else {
                    System.out.println();
                    System.out.println("-- Please enter an input. --");
                    System.out.println();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
