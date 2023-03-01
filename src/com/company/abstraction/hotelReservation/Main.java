package com.company.abstraction.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input=scanner.nextLine().split("\\s+");

        double pricePerDay=Double.parseDouble(input[0]);
        int numOfDays=Integer.parseInt(input[1]);
        String season=input[2];
        String discType=input[3];

        PriceCalculator calculateThePrice=new PriceCalculator(pricePerDay,numOfDays,
                Season.valueOf(season),DiscountType.valueOf(discType));

        System.out.printf("%.2f",calculateThePrice.returnThePrice());

    }
}

