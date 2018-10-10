package com.data.structures.algorithm;

import com.data.structures.InvalidInputException;
import com.data.structures.hashTable.HashTableAlgorithm;
import com.data.structures.linkedList.LinkedListAlgorithm;
import com.data.structures.queue.QueueAlgorithm;
import com.data.structures.sort.SortFactory;
import com.data.structures.sort.SortIntroAlgorithm;
import com.data.structures.sort.SortResource;
import com.data.structures.stack.StackAlgorithm;
import com.data.structures.tree.TreeFactory;
import com.data.structures.tree.TreeIntroAlgorithm;
import com.data.structures.tree.TreeResource;

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
