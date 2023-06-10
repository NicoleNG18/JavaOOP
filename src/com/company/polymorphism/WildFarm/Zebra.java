package com.company.polymorphism.WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Zebras are not eating that type of food!");
        } else {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return "Zebra[" + this.getAnimalName() + ", " + df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }

}

