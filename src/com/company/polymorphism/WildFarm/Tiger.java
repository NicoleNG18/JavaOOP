package com.company.polymorphism.WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            System.out.println("Tigers are not eating that type of food!");
        } else {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return "Tiger[" + this.getAnimalName() + ", " + df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }
}

