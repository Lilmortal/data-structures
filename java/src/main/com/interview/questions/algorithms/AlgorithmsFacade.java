package com.interview.questions.algorithms;

import com.interview.questions.Algorithms;
import com.interview.questions.ExitException;
import com.sun.tools.javah.Util;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AlgorithmsFacade {
    protected abstract void printInstructions();

    protected void printExitInstructions() {
        System.out.println("Type \"exit\" to go back.");
    }

    public abstract void execute(String input, BufferedReader br) throws ExitException, IOException;

    public final void run(BufferedReader br) throws ExitException {
        try {
            String input;

            while (true) {
                this.printInstructions();
                this.printExitInstructions();

                input = br.readLine();

                if (!input.isEmpty()) {
                    if (input.equals(Algorithms.EXIT)) {
                        throw new ExitException();
                    }
                    execute(input, br);
                } else {
                    System.out.println("Please enter a valid input.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
