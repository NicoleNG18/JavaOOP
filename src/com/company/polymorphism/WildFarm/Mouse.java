package com.company.polymorphism.WildFarm;


public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Mice are not eating that type of food!");
        } else {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return "Mouse[" + this.getAnimalName() + ", " + df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }

}

