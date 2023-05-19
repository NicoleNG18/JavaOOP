package com.company.encapsulation;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name == null || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                , name, age, this.productPerDay());
    }

    private double calculateProductPerDay() {
        if (age >= 0 && age <= 5) {
            return 2;
        } else if (age >= 6 && age <= 11) {
            return 1;
        }
        return 0.75;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }
}
