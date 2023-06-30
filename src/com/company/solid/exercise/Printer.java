package com.company.solid.exercise;

public class Printer {


    public Printer() {
        super();
    }

    public void printSum(double sum) {
        System.out.printf(Formats.SUM_FORMAT + "%n", sum);
    }

    public void printAverage(double average) {
        System.out.printf(Formats.AVERAGE_FORMAT + "%n", average);
    }

    public void printKilograms(double kilograms) {
        System.out.printf(Formats.KILOGRAMS_FORMAT + "%n", kilograms);
    }

}

