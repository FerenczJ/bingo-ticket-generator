package com.mrq.bingo;

import com.mrq.bingo.business.BingoTicketStripe;
import com.mrq.bingo.business.LayoutFactoryImpl;
import com.mrq.bingo.utils.BingoUtils;

public class BingoTicketGeneratorApplication {

    public static void main( String[] args ) {
        var numbers = BingoUtils.generateBingo90NumberPool();
        var layoutFactory = new LayoutFactoryImpl();
        var stripe = new BingoTicketStripe(numbers, layoutFactory.createLayout());

        System.out.println(stripe);
    }
}
