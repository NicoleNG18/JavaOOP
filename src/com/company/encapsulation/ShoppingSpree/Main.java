package com.company.encapsulation.ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputPeople = splitTheInput(scanner.nextLine(), ";");
        String[] inputProducts = splitTheInput(scanner.nextLine(), ";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        fillTheStructures(inputPeople, inputProducts, people, products);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] help = command.split("\\s+");
            try {
                people.get(help[0]).buyProduct(products.get(help[1]));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());

            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Person> p : people.entrySet()) {
            if (p.getValue().getProducts().isEmpty()) {
                System.out.printf("%s – Nothing bought%n", p.getKey());
            } else {
                String boughtPr = p.getValue().getProducts().stream().map(Product::getName)
                        .collect(Collectors.joining(", ")).toString();
                System.out.printf("%s - %s%n", p.getKey(), boughtPr);
            }
        }
    }

    private static String[] splitTheInput(String scanner, String regex) {
        return scanner.split(regex);
    }

    private static void fillTheStructures(String[] inputPeople, String[] inputProducts, Map<String, Person> people, Map<String, Product> products) {
        addPeople(inputPeople, people);
        addProducts(inputProducts, products);
    }

    private static void addProducts(String[] inputProducts, Map<String, Product> products) {
        for (int i = 0; i < inputProducts.length; i++) {
            String[] help = splitTheInput(inputProducts[i], "=");

            products.put(help[0], new Product(help[0], Double.parseDouble(help[1])));
        }
    }

    private static void addPeople(String[] inputPeople, Map<String, Person> people) {
        for (int i = 0; i < inputPeople.length; i++) {
            String[] help = splitTheInput(inputPeople[i], "=");

            people.put(help[0], new Person(help[0], Double.parseDouble(help[1])));
        }
    }
}

