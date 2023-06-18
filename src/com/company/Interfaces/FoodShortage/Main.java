package com.company.Interfaces.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPeople=Integer.parseInt(scanner.nextLine());

        Map<String,Buyer> people=new LinkedHashMap<>();

        while (countOfPeople-->0){

            String [] inputParts=scanner.nextLine().split("\\s+");

            String name=inputParts[0];
            int age=Integer.parseInt(inputParts[1]);

            if(inputParts.length==3){
                addRebel(people, inputParts, name, age);
            } else if(inputParts.length==4){
                addCitizen(people, inputParts, name, age);
            }


        }

        String buyer=scanner.nextLine();

        while (!buyer.equals("End")){

            if(people.containsKey(buyer)){
                people.get(buyer).buyFood();
            }

            buyer=scanner.nextLine();
        }

        int sumFood=people.values().stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(sumFood);
    }

    private static void addRebel(Map<String, Buyer> people, String[] inputParts, String name, int age) {
        String group= inputParts[2];
        Buyer rebel=new Rebel(name, age,group);
        people.put(name,rebel);
    }

    private static void addCitizen(Map<String, Buyer> people, String[] inputParts, String name, int age) {
        String id= inputParts[2];
        String birthDate= inputParts[3];
        Buyer citizen=new Citizen(name, age,id,birthDate);
        people.put(name,citizen);
    }
}

