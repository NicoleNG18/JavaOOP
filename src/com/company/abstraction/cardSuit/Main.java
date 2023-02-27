package com.company.abstraction.cardSuit;

import com.company.abstraction.cardSuit.thrid.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, CardSuit.valueOf(suit).getValue()+
               CardSuit.CardRank.valueOf(rank).getValue());

    }
}

