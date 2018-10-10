package com.data.structures.heap;

import com.data.structures.InvalidInputException;
import com.data.structures.tree.AVL;
import com.data.structures.tree.BinarySearchTree;
import com.data.structures.tree.RedBlackTree;
import com.data.structures.tree.Tree;

public class HeapFactory {
    public Heap getHeap(String heap) throws InvalidInputException {
        switch (heap) {
            case "minHeap": {
                return new MinHeap();
            }
            case "maxHeap": {
                return new MaxHeap();
            }
            default:
                throw new InvalidInputException("Invalid input");
        }
    }
}
