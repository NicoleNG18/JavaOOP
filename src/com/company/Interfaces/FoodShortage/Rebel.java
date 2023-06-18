package com.company.Interfaces.FoodShortage;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        setName(name);
        setAge(age);
        setGroup(group);
        setFood(0);
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFood(int food) {
        this.food = food;
    }
}

