package com.interview.questions.algorithm;

import com.interview.questions.InvalidInputException;

public class AlgorithmResource {
    public Algorithm getAlgorithm(String input) throws InvalidInputException {
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        Algorithm algorithm;

        switch (input) {
            case "1": {
                algorithm = algorithmFactory.getAlgorithm("linked list");
                break;
            }

            case "2": {
                algorithm = algorithmFactory.getAlgorithm("queue");
                break;
            }

            case "3": {
                algorithm = algorithmFactory.getAlgorithm("stack");
                break;
            }

            case "4": {
                algorithm = algorithmFactory.getAlgorithm("hash table");
                break;
            }

            case "5": {
                algorithm = algorithmFactory.getAlgorithm("sorting");
                break;
            }

            default: {
                throw new InvalidInputException("Invalid input");
            }
        }

        return algorithm;
    }
}
