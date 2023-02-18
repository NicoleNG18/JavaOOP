package com.company.abstraction.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {

    private final Map<String,LinkedHashMap<String,Long>> bag;

    public Bag() {
        this.bag = new LinkedHashMap<>();
    }

    public Map<String, LinkedHashMap<String,Long>> getBag() {
        return bag;
    }

    public void putItems(String currName, long currAmount, String typeInput) {
        bag.putIfAbsent(typeInput, new LinkedHashMap<>());

        bag.get(typeInput).putIfAbsent(currName, 0L);

        bag.get(typeInput).put(currName, bag.get(typeInput).get(currName) + currAmount);
    }

    public void printTheItems() {
        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2)
                    -> e2.getKey().compareTo(e1.getKey())).forEach(i
                    -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    public boolean checkAllTheConditions(long safeCapacity, long currAmount, String typeInput) {
        if (checkFirst(safeCapacity, currAmount, typeInput)) return true;
        return checkSecond(currAmount, typeInput);
    }

    public boolean checkSecond(long currAmount, String typeInput) {
        switch (typeInput) {
            case "Gem":
                if (!bag.containsKey(typeInput)) {

                    if (bag.containsKey("Gold")) {

                        if (currAmount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                            return true;
                        }

                    } else {
                        return true;
                    }

                } else if (bag.get(typeInput).values().stream().mapToLong(e -> e).sum() + currAmount
                        > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }

                break;

            case "Cash":
                if (!bag.containsKey(typeInput)) {

                    if (bag.containsKey("Gem")) {

                        if (currAmount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                            return true;
                        }

                    } else {
                        return true;
                    }

                } else if (bag.get(typeInput).values().stream().
                        mapToLong(e -> e).sum() + currAmount > bag.get("Gem").values().stream().
                        mapToLong(e -> e).sum()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean checkFirst(long safeCapacity, long currAmount, String typeInput) {
        if (typeInput.equals("")) {
            return true;

        } else return safeCapacity < bag.values().stream().
                map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + currAmount;
    }

}

