package com.company.polymorphism.WildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return "Cat[" + this.getAnimalName() + ", " + this.getBreed() + ", " + df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }


}

