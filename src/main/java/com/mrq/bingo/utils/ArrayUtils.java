package com.mrq.bingo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayUtils {
    public static void sortColumns(Integer[][] arr) {
        // sort each column
        for (var i = 0; i < arr[0].length; i++) {
            // get column
            var column = new int[arr.length];
            for (var j = 0; j < arr.length; j++) {
                column[j] = arr[j][i];
            }
            // sort column
            column = ArrayUtils.sortArray(column, 0);

            // push back to column
            for (var j = 0; j < arr.length; j++) {
                arr[j][i] = column[j];
            }
        }
    }
    public static int[] sortArray(int[] arr, int ignore) {
        var list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Set<Integer> indexesOf = new HashSet<>();
        int indexOf;
        int shift = 0;
        while ((indexOf = list.indexOf(ignore)) != -1) {
            indexesOf.add(indexOf + shift++);
            list.remove(indexOf);
        }

        Collections.sort(list);
        indexesOf.forEach(index -> list.add(index, 0));

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[][] shuffleRowsInGroup(int[][] layout, int size) {
        for (var i = 0; i < layout.length; i = i + size) {
            var r = (int) (Math.random() * size);
            var temp = layout[i];
            layout[i] = layout[i + r];
            layout[i + r] = temp;
        }

        return layout;
    }
}
