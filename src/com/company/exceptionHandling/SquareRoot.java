package com.company.exceptionHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double output = -1;

        try {
            output = sqrt(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");
        }

        if (output != -1) {
            System.out.printf("%.2f%n",output);

        }
        System.out.println("Goodbye");

    }

    public static double sqrt(double n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(n);
    }
}

