package com.mrq.bingo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BingoUtils {
    // we need a modifiable list
    private static final BiFunction<Integer, Integer, List<Integer>> rangeGenerator = (min, max) ->
            IntStream.rangeClosed(min, max).boxed().collect(Collectors.toCollection(ArrayList::new));;

    public static List<List<Integer>> generateBingo90NumberPool(){
        var result = new ArrayList<List<Integer>>();
        result.add(rangeGenerator.apply(1, 9));
        for (var i = 1; i < 8; i++) {
            result.add(rangeGenerator.apply(i * 10, i * 10 + 9));
        }
        result.add(rangeGenerator.apply(80, 90));

        return result;
    }
}
