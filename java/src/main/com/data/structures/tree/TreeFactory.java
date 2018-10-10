package com.data.structures.tree;

import com.data.structures.InvalidInputException;
import com.data.structures.tree.heap.MaxHeap;
import com.data.structures.tree.heap.MinHeap;

public class TreeFactory {
    public Tree getTree(String tree) throws InvalidInputException {
        switch (tree) {
            case "minHeap": {
                return new MinHeap();
            }
            case "maxHeap": {
                return new MaxHeap();
            }
            case "binarySearch": {
                return new BinarySearchTree();
            }
            case "redBlack": {
                return new RedBlackTree();
            }
            case "avl": {
                return new AVL();
            }
            default:
                throw new InvalidInputException("Invalid input");
        }
    }
}