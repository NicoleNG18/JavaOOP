package com.company.polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        String[] truckInput = scanner.nextLine().split("\\s+");
        String[] busInput = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] commands = scanner.nextLine().split("\\s+");
            String typeVehicle = commands[1];

            switch (commands[0]) {

                case "Drive":

                    double kilometers = Double.parseDouble(commands[2]);

                    driveTheVehicle(car, truck, kilometers, typeVehicle, bus);

                    break;

                case "Refuel":

                    double fuel = Double.parseDouble(commands[2]);

                    if (fuel <= 0) {
                        System.out.println("Fuel must be a positive number");
                    } else {
                        refuelTheVehicle(car, truck, fuel, typeVehicle, bus);
                    }

                    break;

                case "DriveEmpty":

                    System.out.println(bus.driveEmpty(Double.parseDouble(commands[2])));

                    break;

            }
        }

        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
        System.out.printf("Bus: %.2f", bus.fuelQuantity);

    }

    private static void refuelTheVehicle(Vehicle car, Vehicle truck, double fuel, String typeVehicle, Vehicle bus) {

        if (typeVehicle.equals("Car")) {
            car.refuel(fuel);
        } else if (typeVehicle.equals("Truck")) {
            truck.refuel(fuel);
        } else {
            bus.refuel(fuel);
        }

    }

    private static void driveTheVehicle(Vehicle car, Vehicle truck, double kilometers, String typeVehicle, Vehicle bus) {

        if (typeVehicle.equals("Car")) {
            System.out.println(car.drive(kilometers));
        } else if (typeVehicle.equals("Truck")) {
            System.out.println(truck.drive(kilometers));
        } else {
            System.out.println(bus.drive(kilometers));
        }

    }
}

