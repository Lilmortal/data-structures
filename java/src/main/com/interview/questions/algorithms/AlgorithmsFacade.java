package com.interview.questions.algorithms;

import com.interview.questions.ExitException;

import java.io.BufferedReader;

public abstract class AlgorithmsFacade {
    protected void printExitInstructions() {
        System.out.println("Type \"exit\" to go back.");
    }

    public abstract void run(BufferedReader br) throws ExitException;
}
