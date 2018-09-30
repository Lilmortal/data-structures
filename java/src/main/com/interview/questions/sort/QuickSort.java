package com.interview.questions.sort;

public class QuickSort implements Sort {
    // 1. Pick a pivot (here we choose the most rightest element)
    // 2. Initialize left and right index
    // 3. If left index is greater than pivot, stay, else move to the right
    // 4. If right index is smaller than pivot, stay, else move to the left
    // 5. If both left index and right index stayed, swap them
    // 6. If left index position is equal or over right index, end swapping
    // 7. Swap pivot with left index position
    // 8. From the pivot current position, split into two sorts, the left side, and the right side excluding the pivot, and repeat
    // 9. Return if left index is greater than or equal to right index as that means there is only one or less element, which by itself is sorted.

    // e.g. 9 12 9 2 17 1 6
    // Swap 1 with 9
    // 1 12 9 2 17 9 6
    // Swap 12 with 2
    // 1 2 9 12 17 9 6
    // Swap 6 which is the pivot with left element 9
    // 1 2 | 6 | 12 17 9 9
    // on the left side:
    // 1 is sorted
    // 2 is sorted
    // on the right side
    // Swap pivot element 9 with 12
    // 9 17 9 12
    // Swap 9 with 17
    // 9 9 17 12
    // Swap pivot element 17 with 12
    // 9 9 12 17
    // 9 9 is sorted
    // 12 17 is sorted
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
        // Initial right index should not be the pivot
        rightIndex = rightIndex - 1;

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
