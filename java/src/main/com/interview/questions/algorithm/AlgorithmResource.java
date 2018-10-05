package com.interview.questions.algorithm;

import com.interview.questions.InvalidInputException;

public class AlgorithmResource {
    public Algorithm getAlgorithm(String input) throws InvalidInputException {
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();

        switch (input) {
            case "1": {
                return algorithmFactory.getAlgorithm("linked list");
            }

            case "2": {
                return algorithmFactory.getAlgorithm("queue");
            }

            case "3": {
                return algorithmFactory.getAlgorithm("stack");
            }

            case "4": {
                return algorithmFactory.getAlgorithm("hash table");
            }

            case "5": {
                return algorithmFactory.getAlgorithm("sorting");
            }

            case "6": {
                return algorithmFactory.getAlgorithm("tree");
            }

            default: {
                throw new InvalidInputException("Invalid input");
            }
        }
    }
}
