package com.mrq.bingo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    // generate test for sortColumns
    @Test
    void sortColumns_shouldKeepSorted() {
        // create a 2D array
        Integer[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // call the method
        ArrayUtils.sortColumns(arr, 0);

        // assert the result
        assertArrayEquals(new Integer[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, arr);
    }

    @Test
    void sortColumns_shouldSkipZeros() {
        // create a 2D array
        Integer[][] arr = {
                {7, 0, 0},
                {0, 0, 9},
                {1, 2, 6}
        };

        // call the method
        ArrayUtils.sortColumns(arr, 0);

        // assert the result
        assertArrayEquals(new Integer[][]{
                {1, 0, 0},
                {0, 0, 6},
                {7, 2, 9}
        }, arr);
    }

    @Test
    void sortArray_shouldSortArray() {
        // create an array
        int[] arr = {3, 1, 2, 4};

        // call the method
        var result = ArrayUtils.sortArray(arr, 0);

        // assert the result
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void sortArray_shouldSkipZeros() {
        // create an array
        int[] arr = {0, 1, 0, 4, 2, 3, 0};

        // call the method
        var result = ArrayUtils.sortArray(arr, 0);

        // assert the result
        assertArrayEquals(new int[]{0, 1, 0, 2, 3, 4, 0}, result);
    }
}