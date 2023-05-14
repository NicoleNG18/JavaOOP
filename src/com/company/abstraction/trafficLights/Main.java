package com.company.abstraction.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            List<String> nextColors = new ArrayList<>();

            for (String currColor : colors) {

                System.out.print((Color.valueOf(currColor).getNextColor()) + " ");
                nextColors.add(String.valueOf(Color.valueOf(currColor).getNextColor()));
            }

            System.out.println();
            colors=nextColors.toArray(new String[0]);
        }
    }
}
