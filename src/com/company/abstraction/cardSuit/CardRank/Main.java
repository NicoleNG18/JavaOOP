package com.company.abstraction.cardSuit.CardRank;

import com.company.abstraction.cardSuit.thrid.CardSuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        for (var c: CardSuit.CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",c.getValue(),c);
        }

    }
}

