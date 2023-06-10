package com.company.polymorphism.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animals=new ArrayList<>();
        List<Food> food=new ArrayList<>();

        while (!command.equals("End")) {

            String[] animalInputArr = command.split("\\s+");

            String animalType = animalInputArr[0];
            String animalName = animalInputArr[1];
            Double animalWeight = Double.parseDouble(animalInputArr[2]);
            String animalLivingRegion = animalInputArr[3];

            String[] foodInputArr = scanner.nextLine().split("\\s+");
            String foodType = foodInputArr[0];
            Integer foodQuantity = Integer.parseInt(foodInputArr[1]);
            if(foodType.equals("Meat")){
                Food meat=new Meat(foodQuantity);
                food.add(meat);
            } else{
                Food vegetable=new Vegetable(foodQuantity);
                food.add(vegetable);
            }

            switch (animalType) {

                case "Mouse":
                    Animal mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(mouse);
                    break;

                case "Tiger":
                    Animal tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(tiger);
                    break;

                case "Cat":
                    String catBreed = animalInputArr[4];
                    Animal cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                    animals.add(cat);
                    break;

                case "Zebra":
                    Animal zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(zebra);
                    break;

            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal currentAn=animals.get(i);
            Food currentFood=food.get(i);
            currentAn.makeSound();
            currentAn.eat(currentFood);
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }

}

