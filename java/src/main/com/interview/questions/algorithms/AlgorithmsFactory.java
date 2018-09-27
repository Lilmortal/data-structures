package com.interview.questions.algorithms;


import com.interview.questions.InvalidInputException;
import com.interview.questions.hashTable.HashTableAlgorithmsFacade;
import com.interview.questions.linkedList.LinkedListAlgorithmsFacade;
import com.interview.questions.queue.QueueAlgorithmsFacade;
import com.interview.questions.sorting.SortingAlgorithmsFacade;
import com.interview.questions.stack.StackAlgorithmsFacade;

public class AlgorithmsFactory {

    public AlgorithmsFacade getAlgorithms(String algorithms) {
        AlgorithmsFacade algorithmsFacade;

        switch (algorithms) {
            case "linked list": {
                algorithmsFacade = new LinkedListAlgorithmsFacade();
                break;
            }

            case "queue": {
                algorithmsFacade = new QueueAlgorithmsFacade();
                break;
            }

            case "stack": {
                algorithmsFacade = new StackAlgorithmsFacade();
                break;
            }

            case "hash table": {
                algorithmsFacade = new HashTableAlgorithmsFacade();
                break;
            }

            case "sorting": {
                algorithmsFacade = new SortingAlgorithmsFacade();
                break;
            }

            default: {
                throw new InvalidInputException();
            }
        }

        return algorithmsFacade;
    }
}
