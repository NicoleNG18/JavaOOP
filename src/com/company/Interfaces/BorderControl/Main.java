package com.company.Interfaces.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Identifiable> robotsAndCitizens = new ArrayList<>();
        addRobotsAndCitizens(scanner, input, robotsAndCitizens);
        String number = scanner.nextLine();
        robotsAndCitizens.stream()
                .map(Identifiable::getId)
                .filter(e -> e.endsWith(number))
                .forEach(System.out::println);
    }

    private static void addRobotsAndCitizens(Scanner scanner, String input, List<Identifiable> robotsAndCitizens) {
        while (!input.equals("End")){

            String [] arr= input.split("\\s+");

            if(arr.length==2){

                Robot robot=new Robot(arr[0],arr[1]);
                robotsAndCitizens.add(robot);

            } else{

                Citizen citizen=new Citizen(arr[0],Integer.parseInt(arr[1]),arr[2]);
                robotsAndCitizens.add(citizen);

            }
            input = scanner.nextLine();
        }
    }
}

