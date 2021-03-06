package com.data.structures.sort;

import com.data.structures.InvalidInputException;

public class SortResource {
    private SortFactory sortFactory;

    public SortResource(SortFactory sortFactory) {
        this.sortFactory = sortFactory;
    }

    public Sort getSort(String sort) throws InvalidInputException {
        switch (sort) {
            case "1": {
                return sortFactory.getSort("insertion");
            }
            case "2": {
                return sortFactory.getSort("merge");
            }
            case "3": {
                return sortFactory.getSort("quick");
            }
            default: {
                throw new InvalidInputException("Invalid input");
            }
        }
    }
}
