package com.data.structures.heap;

import com.data.structures.ExitException;
import com.data.structures.InvalidInputException;
import com.data.structures.algorithm.Algorithm;
import com.data.structures.tree.TreeAlgorithm;

import java.io.BufferedReader;

public class HeapIntroAlgorithm extends Algorithm {
    private HeapResource heapResource;

    public HeapIntroAlgorithm(HeapResource heapResource) {
        this.heapResource = heapResource;
    }

    @Override
    protected void printInstructions() {
        System.out.println("Which heap algorithm you want to test, type the number:");
        System.out.println("1. Min heap");
        System.out.println("2. Max heap");
    }

    @Override
    protected String execute(String input, BufferedReader br) throws InvalidInputException {
        Heap heap = heapResource.getHeap(input);

        // TODO: Notify user if it is heap, can only remove()
        try {
            HeapAlgorithm heapAlgorithm = new HeapAlgorithm(heap);
            heapAlgorithm.run(br);
        } catch (ExitException e) {
            // Do nothing, it is exited here
        }

        return null;
    }
}
