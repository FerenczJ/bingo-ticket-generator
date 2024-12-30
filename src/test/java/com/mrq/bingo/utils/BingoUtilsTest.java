package com.mrq.bingo.utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BingoUtilsTest {
    @Test
    void testGenerateBingo90NumberPool_shouldContain90Numbers() {
        assertEquals(90, BingoUtils.generateBingo90NumberPool().stream().flatMap(List::stream).distinct().count());
    }
}