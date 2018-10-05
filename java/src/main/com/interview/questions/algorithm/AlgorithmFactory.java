package com.interview.questions.algorithm;


import com.interview.questions.InvalidInputException;
import com.interview.questions.hashTable.HashTableAlgorithm;
import com.interview.questions.linkedList.LinkedListAlgorithm;
import com.interview.questions.queue.QueueAlgorithm;
import com.interview.questions.sort.SortFactory;
import com.interview.questions.sort.SortIntroAlgorithm;
import com.interview.questions.sort.SortResource;
import com.interview.questions.stack.StackAlgorithm;
import com.interview.questions.tree.TreeAlgorithm;
import com.interview.questions.tree.TreeFactory;
import com.interview.questions.tree.TreeIntroAlgorithm;
import com.interview.questions.tree.TreeResource;

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
                SortFactory sortFactory = new SortFactory();
                SortResource sortResource = new SortResource(sortFactory);
                return new SortIntroAlgorithm(sortResource);
            }

            case "tree": {
                TreeFactory treeFactory = new TreeFactory();
                TreeResource treeResource = new TreeResource(treeFactory);
                return new TreeIntroAlgorithm(treeResource);
            }

            default: {
                throw new InvalidInputException();
            }
        }
    }
}
