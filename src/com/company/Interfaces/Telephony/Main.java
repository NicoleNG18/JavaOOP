package com.company.Interfaces.Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers= getData(scanner);
        List<String> urls= getData(scanner);

        Smartphone smartphone=new Smartphone(numbers,urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }

    private static List<String> getData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
    }
}

