package com.mrq.bingo.business;

import com.mrq.bingo.utils.BingoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BingoTicketStripeTest {

    private BingoTicketStripe instance;

    @BeforeEach
    void setUp() {
        instance = new BingoTicketStripe(BingoUtils.generateBingo90NumberPool(), new LayoutFactoryImpl().createLayout());
    }

    @Test
    void testStripeDimension_shouldBe6x3x9() {
        assertEquals(6, instance.getStripe().length);
        assertEquals(3, instance.getStripe()[0].getTicket().length);
        assertEquals(9, instance.getStripe()[0].getTicket()[0].length);
    }

    @Test
    void testStripeComposition_numbersShouldBeBetween1And90WithoutDuplicate() {
        var count = Arrays.stream(instance.getStripe())
                .flatMap(ticket -> Arrays.stream(ticket.getTicket()))
                .flatMap(Arrays::stream)
                .filter(n -> n != 0)
                .distinct()
                .count();

        assertEquals(90, count);
    }

    @Test
    void testStripeGeneration_10kStripeShouldBeGeneratedWithinASecond() {
        var start = System.currentTimeMillis();
        for (var i = 0; i < 10000; i++) {
            new BingoTicketStripe(BingoUtils.generateBingo90NumberPool(), new LayoutFactoryImpl().createLayout());
        }
        var end = System.currentTimeMillis();
        var duration = end - start;
        System.out.println("10.000 Stripe is generated under: " + duration + "ms");
        assertEquals(true, duration < 1000);
    }

    @Test
    void testStripeToString_shouldReturn6TicketString() {
        var result = instance.toString().split("\n\n");
        assertEquals(6, result.length);
    }
}