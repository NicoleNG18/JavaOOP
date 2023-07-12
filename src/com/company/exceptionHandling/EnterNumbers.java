package com.company.exceptionHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    public static int START_OF_RANGE = 1;

    public static final int END_OF_RANGE = 100;

    public static final Scanner SCANNER = new Scanner(System.in);

    public static List<Integer> numbers=new ArrayList<>();

    public static void main(String[] args) {

        while (numbers.size() < 10) {

            try {
                readNumber(START_OF_RANGE, END_OF_RANGE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void readNumber(int startOfRange, int endOfRange) {

        Optional<Integer> num;

        try {
            num = Optional.of(Integer.parseInt(SCANNER.nextLine()));
        } catch (NumberFormatException ignored) {
            throw new IllegalStateException("Invalid Number!");
        }

        if (num.get() <= startOfRange || num.get() >= endOfRange) {
            throw new IllegalArgumentException("Your number is not in range " + startOfRange + " - 100!");
        } else{
            numbers.add(num.get());
            START_OF_RANGE=num.get();
        }

    }
}

