package com.mrq.bingo.business;

import lombok.Getter;

import java.util.List;

@Getter
public class BingoTicketStripe {
    private static final int STRIPE_SIZE = 6;
    private static final int MAX_ROWS = 3;
    private static final int MAX_COLUMNS = 9;

    private final BingoTicket[] stripe = new BingoTicket[STRIPE_SIZE];

    public BingoTicketStripe(List<List<Integer>> numbers, List<List<Integer>> layout) {
        for (int i = 0; i < STRIPE_SIZE; i++) {
            var ticketLayout = layout.subList(i * MAX_ROWS, i * MAX_ROWS + MAX_ROWS);
            stripe[i] = new BingoTicket(numbers, ticketLayout);
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var ticket : stripe) {
            sb.append(ticket.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
