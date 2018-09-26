package com.interview.questions.algorithms;

import com.interview.questions.InvalidInputException;

public class AlgorithmsResource {
    public AlgorithmsFacade getFacade(String input) {
        AlgorithmsFactory algorithmsFactory = new AlgorithmsFactory();
        AlgorithmsFacade algorithmsFacade = null;

        switch (input) {
            case "1": {
                algorithmsFacade = algorithmsFactory.getAlgorithms("linked list");
                break;
            }

            case "2": {
                algorithmsFacade = algorithmsFactory.getAlgorithms("queue");
                break;
            }

            case "3": {
                algorithmsFacade = algorithmsFactory.getAlgorithms("stack");
                break;
            }

            case "4": {
                algorithmsFacade = algorithmsFactory.getAlgorithms("hash table");
                break;
            }

            case "5": {
                algorithmsFacade = algorithmsFactory.getAlgorithms("sorting");
                break;
            }

            default: {
                throw new InvalidInputException();
            }
        }

        return algorithmsFacade;
    }
}
