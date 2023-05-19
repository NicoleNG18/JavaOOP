package com.company.encapsulation.ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = parseInput(scanner);

        double width = parseInput(scanner);

        double height = parseInput(scanner);

        Box box = new Box(length, width, height);

        printTheOutput(box);

    }

    private static double parseInput(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }

    private static void printTheOutput(Box box) {
        print("Surface Area - %.2f", box.calculateSurfaceArea());
        print("Lateral Surface Area - %.2f", box.calculateLateralSurfaceArea());
        print("Volume - %.2f", box.calculateVolume());
    }

    private static void print(String format, double box) {
        System.out.println(String.format(format, box));
    }
}

