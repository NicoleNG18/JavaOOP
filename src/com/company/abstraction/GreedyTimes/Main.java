package com.company.abstraction.GreedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long safeCapacity = Long.parseLong(scanner.nextLine());
        String[] safeItems = scanner.nextLine().split("\\s+");

        Bag bag = new Bag();

        for (int i = 0; i < safeItems.length; i += 2) {
            String currName = safeItems[i];
            long currAmount = Long.parseLong(safeItems[i + 1]);

            String typeInput = getTypeInput(currName);

            if (bag.checkAllTheConditions(safeCapacity, currAmount, typeInput)) continue;

            bag.putItems(currName, currAmount, typeInput);

        }

        bag.printTheItems();
    }



    private static String getTypeInput(String currName) {
        String typeInput = "";
        if (currName.length() == 3) {
            typeInput = "Cash";
        } else if (currName.toLowerCase().endsWith("gem")) {
            typeInput = "Gem";
        } else if (currName.toLowerCase(Locale.ROOT).equals("gold")) {
            typeInput = "Gold";
        }
        return typeInput;
    }
}
