package com.data.structures.sort;

import java.util.Arrays;

public class MergeSort implements Sort {
    @Override
    public Double[] sort(Double[] list) {
        if (list.length > 1) {
            int half = list.length / 2;
            Double[] left = sort(Arrays.copyOfRange(list, 0, half));
            Double[] right = sort(Arrays.copyOfRange(list, half, list.length));

            return merge(left, right);
        }
        return list;
    }

    @Override
    public String getName() {
        return "Merge sort";
    }

    private Double[] merge(Double[] start, Double[] end) {
        int lengthOfBothArrays = start.length + end.length;
        Double[] sortedList = new Double[lengthOfBothArrays];
        int startIndex = 0;
        int endIndex = 0;

        int index = 0;
        while (startIndex <= start.length - 1 && endIndex <= end.length - 1) {
            if (start[startIndex] < end[endIndex]) {
                sortedList[index] = start[startIndex];
                startIndex++;
            } else {
                sortedList[index] = end[endIndex];
                endIndex++;
            }
            index++;
        }

        if (startIndex > start.length - 1) {
            while (endIndex <= end.length - 1) {
                sortedList[index] = end[endIndex];
                endIndex++;
                index++;
            }
        }

        if (endIndex > end.length - 1) {
            while (startIndex <= start.length - 1) {
                sortedList[index] = start[startIndex];
                startIndex++;
                index++;
            }
        }

        return sortedList;
    }
}
