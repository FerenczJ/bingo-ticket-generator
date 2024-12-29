package com.mrq.bingo.business;

import com.mrq.bingo.utils.BingoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BingoTicketTest {

    private BingoTicket instance;

    @BeforeEach
    void setUp() {
        instance = new BingoTicket(BingoUtils.generateBingo90NumberPool(), new LayoutFactoryImpl().createLayout());
    }

    @Test
    void testTicketDimension_shouldBe3x9() {
        assertEquals(3, instance.getTicket().length);
        assertEquals(9, instance.getTicket()[0].length);
    }

    @Test
    void testTicketComposition_eachRowShouldContain5NumberAnd4Blank() {
        for(var row: instance.getTicket()){
            var result = Arrays.stream(row).collect(Collectors.partitioningBy(n -> n == 0));
            assertEquals(5, result.get(false).size());
            assertEquals(4, result.get(true).size());
        }
    }

    @Test
    void testTicketComposition_eachColumnShouldContainLessThan3Blank() {
        for (int i = 0; i < 9; i++) {
            var column = new Integer[3];
            for (int j = 0; j < 3; j++) {
                column[j] = instance.getTicket()[j][i];
            }
            var result = Arrays.stream(column).collect(Collectors.partitioningBy(n -> n == 0));
            assertTrue(result.get(true).size() < 3);
        }
    }

    @Test
    void testTicketComposition_eachColumnShouldBeOrderedAscendingSkippedBlanks() {
        for (int i = 0; i < 9; i++) {
            var column = new Integer[3];
            for (int j = 0; j < 3; j++) {
                column[j] = instance.getTicket()[j][i];
            }
            // ignore zeros
            column = Arrays.stream(column)
                        .filter(n -> n != 0)
                        .toArray(Integer[]::new);

            var sorted = Arrays.copyOf(column, column.length);
            Arrays.sort(sorted);
            assertArrayEquals(sorted, column);
        }
    }

    @Test
    void testStripeToString_shouldReturn6TicketString() {
        var result = instance.toString().split("\n");
        assertEquals(3, result.length);
    }
}