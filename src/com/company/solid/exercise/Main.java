package com.company.solid.exercise;

import com.company.solid.products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product chips = new Chips(100);
        Product chocolate = new Chocolate(100);
        Product lemonade=new Lemonade(200);
        Product coke=new Coke(150);

        List<Product> products = new ArrayList<>();
        products.add(chocolate);
        products.add(chips);
        products.add(lemonade);
        products.add(coke);

        Printer printer=new Printer();
        CaloriesCalculator caloriesCalculator=new CaloriesCalculator();
        QuantityCalculator quantityCalculator=new QuantityCalculator();

        printer.printSum(caloriesCalculator.sum(products));
        printer.printAverage(caloriesCalculator.average(products));
        printer.printKilograms(quantityCalculator.getKilograms(products));
    }
}

