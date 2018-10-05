package com.interview.questions.algorithm;


import com.interview.questions.InvalidInputException;
import com.interview.questions.hashTable.HashTableAlgorithm;
import com.interview.questions.linkedList.LinkedListAlgorithm;
import com.interview.questions.queue.QueueAlgorithm;
import com.interview.questions.sort.SortIntroAlgorithm;
import com.interview.questions.sort.SortResource;
import com.interview.questions.stack.StackAlgorithm;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithmName) throws InvalidInputException {
        Algorithm algorithm;

        switch (algorithmName) {
            case "linked list": {
                algorithm = new LinkedListAlgorithm();
                break;
            }

            case "queue": {
                algorithm = new QueueAlgorithm();
                break;
            }

            case "stack": {
                algorithm = new StackAlgorithm();
                break;
            }

            case "hash table": {
                algorithm = new HashTableAlgorithm();
                break;
            }

            case "sorting": {
                SortResource sortResource = new SortResource();
                algorithm = new SortIntroAlgorithm(sortResource);
                break;
            }

            default: {
                throw new InvalidInputException();
            }
        }

        return algorithm;
    }
}
