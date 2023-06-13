package com.company.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();

        List <Birthable> birthableObjects = new ArrayList<>();

        while (!inputData.equals("End")) {

            String[] inputParts = inputData.split("\\s+");

            String typeCreature = inputParts[0];
            String name=inputParts[1];

            switch (typeCreature) {
                case "Robot":

                    continue;

                case "Pet":

                    addPet(birthableObjects, inputParts, name);

                    break;
                case "Citizen":

                    addCitizen(birthableObjects, inputParts, name);
                    break;
            }

            inputData = scanner.nextLine();
        }

        String year = scanner.nextLine();

        output(birthableObjects, year);

    }

    private static void output(List<Birthable> birthableObjects, String year) {

        birthableObjects.stream()
                .map(Birthable::getBirthDate)
                .filter(e->e.split("/")[2].equals(year))
                .forEach(System.out::println);

    }

    private static void addCitizen(List<Birthable> birthableList, String[] inputParts, String name) {
        int age=Integer.parseInt(inputParts[2]);
        String id= inputParts[3];
        String birthDate= inputParts[4];

        Birthable citizen=new Citizen(name,age,id,birthDate);
        birthableList.add(citizen);
    }

    private static void addPet(List<Birthable> birthableList, String[] inputParts, String name) {

        String birthDate= inputParts[2];

        Birthable pet = new Pet(name, birthDate);
        birthableList.add(pet);

    }
}

