package com.company.encapsulation.PizzaLab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza = makePizza(scanner);

        addDough(scanner, pizza);

        addToppings(scanner, pizza);

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }

    private static Pizza makePizza(Scanner scanner) {
        String[] pizzaInput = scanner.nextLine().split("\\s+");

        Pizza pizza = new Pizza(pizzaInput[1], Integer.parseInt(pizzaInput[2]));

        return pizza;
    }

    private static void addDough(Scanner scanner, Pizza pizza) {
        String[] doughInput = scanner.nextLine().split("\\s+");

        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double weight = Double.parseDouble(doughInput[3]);

        Dough dough = new Dough(flourType, bakingTechnique, weight);

        pizza.setDough(dough);
    }

    private static void addToppings(Scanner scanner, Pizza pizza) {
        String toppingsInput = scanner.nextLine();

        String toppingType = toppingsInput.split("\\s")[1];
        double weight = Double.parseDouble(toppingsInput.split("\\s+")[2]);

        while (!toppingsInput.equals("END")) {
            pizza.addTopping(new Topping(toppingType, weight));
            toppingsInput = scanner.nextLine();
        }

    }

}

