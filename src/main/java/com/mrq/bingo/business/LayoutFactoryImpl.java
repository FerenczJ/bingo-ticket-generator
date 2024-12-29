package com.mrq.bingo.business;

import com.mrq.bingo.utils.ArrayUtils;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class LayoutFactoryImpl implements LayoutFactory {
    private static final int[][] INITIAL_LAYOUT = {
            {0, 2, 4, 6},
            {1, 3, 5, 7},
            {0, 2, 4, 8},

            {0, 2, 4, 6},
            {1, 3, 5, 7},
            {1, 3, 6, 8},

            {0, 2, 4, 6},
            {1, 3, 5, 7},
            {0, 4, 6, 8},

            {0, 2, 4, 6},
            {1, 3, 5, 7},
            {1, 3, 7, 8},

            {0, 2, 4, 6},
            {1, 3, 5, 7},
            {0, 5, 7, 8},

            {0, 2, 4, 6},
            {1, 3, 5, 8},
            {2, 5, 7, 8}
    };

    @Override
    public List<List<Integer>> createLayout() {
        var layout = ArrayUtils.shuffleRowsInGroup(Arrays.copyOf(INITIAL_LAYOUT, INITIAL_LAYOUT.length), 3);

        // convert array to list
        return Arrays.stream(layout)
                .collect(ArrayList::new, (list, arr) -> list.add(Arrays.stream(arr).boxed().toList()), List::addAll);
    }
}
