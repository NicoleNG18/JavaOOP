package com.company.exceptionHandling;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Range: [" + range[0] + "..." + range[1] + "]");

        boolean isInRange = false;

        String input = scanner.nextLine();

        while (!isInRange) {

            Optional<Integer> number = Optional.empty();

            try {
                number =Optional.of(Integer.parseInt(input));
            } catch (Exception ignored) {
            }

            if(number.isEmpty() || number.get()<range[0] || number.get()>range[1]){
                System.out.println("Invalid number: " + input);
                input = scanner.nextLine();
            } else{
                System.out.println("Valid number: " + input);
                isInRange=true;
            }

        }
    }
}

