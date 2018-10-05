package com.interview.questions.algorithm;


import com.interview.questions.InvalidInputException;
import com.interview.questions.hashTable.HashTableAlgorithm;
import com.interview.questions.linkedList.LinkedListAlgorithm;
import com.interview.questions.queue.QueueAlgorithm;
import com.interview.questions.sort.SortIntroAlgorithm;
import com.interview.questions.sort.SortResource;
import com.interview.questions.stack.StackAlgorithm;
import com.interview.questions.tree.TreeAlgorithm;
import com.interview.questions.tree.TreeIntroAlgorithm;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithmName) throws InvalidInputException {
        switch (algorithmName) {
            case "linked list": {
                return new LinkedListAlgorithm();
            }

            case "queue": {
                return new QueueAlgorithm();
            }

            case "stack": {
                return new StackAlgorithm();
            }

            case "hash table": {
                return new HashTableAlgorithm();
            }

            case "sorting": {
                SortResource sortResource = new SortResource();
                return new SortIntroAlgorithm(sortResource);
            }

            case "tree": {
                return new TreeIntroAlgorithm();
            }

            default: {
                throw new InvalidInputException();
            }
        }
    }
}
