package com.data.structures.heap;

import com.data.structures.InvalidInputException;
import com.data.structures.tree.Tree;
import com.data.structures.tree.TreeFactory;

public class HeapResource {
    private HeapFactory heapFactory;

    public HeapResource(HeapFactory heapFactory) {
        this.heapFactory = heapFactory;
    }

    public Heap getHeap(String heap) throws InvalidInputException {
        switch (heap) {
            case "1": {
                return heapFactory.getHeap("minHeap");
            }
            case "2": {
                return heapFactory.getHeap("maxHeap");
            }
            default: {
                throw new InvalidInputException("Invalid input");
            }
        }
    }
}
