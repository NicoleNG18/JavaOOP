package com.company.inheritance.Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfAnimal = scanner.nextLine();

        while (!typeOfAnimal.equals("Beast!")) {
            String[] animalProperties = scanner.nextLine().split("\\s+");

            String name = animalProperties[0];
            int age = Integer.parseInt(animalProperties[1]);
            String gender = animalProperties[2];
            try {
                switch (typeOfAnimal) {
                    case "Dog" -> {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                    }
                    case "Kitten" -> {
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                    }
                    case "Cat" -> {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                    }
                    case "Frog" -> {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                    }
                    case "Tomcat" -> {
                        Tomcat tom = new Tomcat(name, age);
                        System.out.println(tom);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            typeOfAnimal = scanner.nextLine();
        }
    }
}

