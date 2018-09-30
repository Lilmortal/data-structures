package com.interview.questions.sort;

public class QuickSort implements Sort {
    // 1. Pick a pivot (here we choose the most rightest element)
    // 2. Initialize left and right index
    // 3. If left index is greater than pivot, stay, else move to the right
    // 4. If right index is smaller than pivot, stay, else move to the left
    // 5. If both left index and right index stayed, swap them
    // 6. If left index position is equal or over right index, end swapping
    // 7. Swap pivot with left index position
    // 7. From the pivot current position, split into two sorts, the left side, and the right side excluding the pivot, and repeat
    // 8. Return if left index is greater than or equal to right index as that means there is only one or less element, which by itself is sorted.
    @Override
    public Double[] sort(Double[] list) {
        return sort(list, 0, list.length - 1);
    }

    private Double[] sort(Double[] list, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return list;
        }

        int originalLeftIndex = leftIndex;
        int pivotIndex = rightIndex;

        while (leftIndex <= rightIndex) {
            if (list[leftIndex] > list[pivotIndex] && list[rightIndex] < list[pivotIndex]) {
                list = swap(list, leftIndex, rightIndex);
            }

            if (list[leftIndex] < list[pivotIndex]) {
                leftIndex++;
            }

            if (list[rightIndex] >= list[pivotIndex]) {
                rightIndex--;
            }
        }

        list = swap(list, leftIndex, pivotIndex);

        list = sort(list, originalLeftIndex, rightIndex);
        list = sort(list, leftIndex + 1, pivotIndex);

        return list;
    }

    private Double[] swap(Double[] list, int leftIndex, int rightIndex) {
        Double temp = list[leftIndex];
        list[leftIndex] = list[rightIndex];
        list[rightIndex] = temp;
        return list;
    }

    @Override
    public String getName() {
        return "Quick sort";
    }
}
