package com.mrq.bingo.business;

import com.mrq.bingo.utils.ArrayUtils;
import lombok.Getter;
import java.util.List;

@Getter
public class BingoTicket {

    private static final int FREE_SPACE = 0;
    private static final int MAX_ROWS = 3;
    private static final int MAX_COLUMNS = 9;
    private static final int MAX_FREE_SPACE_IN_A_ROW = 4;

    private final Integer[][] ticket = new Integer[MAX_ROWS][MAX_COLUMNS];

    public BingoTicket(List<List<Integer>> numbers, List<List<Integer>> layout) {
        applyLayout(layout);
        fillWithNumbers(numbers);
        ArrayUtils.sortColumns(ticket);
    }

    private void applyLayout(List<List<Integer>> layout) {
        for(var i = 0; i < MAX_ROWS; i++) {
            for(var freeSpaceIndex: layout.get(i)) {
                ticket[i][freeSpaceIndex] = FREE_SPACE;
            }
        }
    }

    private void fillWithNumbers(List<List<Integer>> numbers) {
        for (var i = 0; i < MAX_ROWS; i++) {
            for (var j = 0; j < MAX_COLUMNS; j++) {
                // if the cell is uninitialized
                if(ticket[i][j] == null){
                    var list = numbers.get(j);
                    var index = (int) (Math.random() * (list.size() - 1));
                    ticket[i][j] = list.remove(index);
                }
            }
        }
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        for (var i = 0; i < MAX_ROWS; i++) {
            result.append("[ ");
            for (var j = 0; j < MAX_COLUMNS; j++) {
                var str = "";
                if(ticket[i][j] == FREE_SPACE) {
                    str = j == 0 ? "_" : "__";
                } else {
                    str = ticket[i][j].toString();
                }
                result.append(str).append(" ");
            }
            result.append("]\n");
        }

        return result.toString();
    }
}