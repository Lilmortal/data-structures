package com.interview.questions.sorting;

import com.interview.questions.InvalidInputException;

import java.util.Arrays;

public class SortResource {
    private SortAlgorithm sortAlgorithm;

    public Double[] getSortedUserInput(String input) {
        Double[] unsortedList = Arrays.stream(input.split(" ")).map(Double::parseDouble).toArray(Double[]::new);
        return sortAlgorithm.sort(unsortedList);
    }

    public String getSortingAlgorithmName() {
        return sortAlgorithm.getName();
    }

    public void setSortingAlgorithm(String sortingAlgorithm) {
        SortAlgorithmFactory sortAlgorithmFactory = new SortAlgorithmFactory();

        switch (sortingAlgorithm) {
            case "1": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("insertion");
                break;
            }
            case "2": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("merge");
                break;
            }
            case "3": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("quick");
                break;
            }
            default: {
                throw new InvalidInputException("Invalid input.");
            }
        }
    }
}
