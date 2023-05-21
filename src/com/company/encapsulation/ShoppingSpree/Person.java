package com.company.encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalStateException(String.format("%s can't afford %s", this.getName(), product.getName()));
        } else {
            products.add(product);
            money -= product.getCost();
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }
}

