package com.company.inheritance.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral=new RandomArrayList();
        ral.add(15);
        ral.add("Pesho");
        ral.add(12.6);
        System.out.println(ral.getRandomElement());
    }
}

