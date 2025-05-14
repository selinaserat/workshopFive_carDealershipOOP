package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface() {
        init();
    }

    public void display() {

        System.out.println("\n" +  Ansi.ANSI_BRIGHT_MAGENTA + Ansi.BOLD +
                "****************************************" + "\n" +
                "*                                      *" + "\n" +
                "*   WELCOME TO THE DEALERSHIP PROGRAM  *" + "\n" +
                "*                                      *" + "\n" +
                "****************************************"
                + Ansi.RESET);
        int mainMenuCommand;

        do {
            System.out.println("\n1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("\nCommand: ");
            mainMenuCommand = scanner.nextInt();


            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, try again");
            }
        } while (mainMenuCommand != 0);
    }


    private void processGetByPriceRequest() {
        System.out.println("\n--------Display vehicles by price--------\n");
        System.out.print("Min: ");
        double min = scanner.nextDouble();

        System.out.print("Max: ");
        double max = scanner.nextDouble();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        // ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(startingPrice, endingPrice);
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByPrice(min, max);

        // Display vehicles with for loop
        displayVehicles(filteredVehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("\n--------Display vehicles by make and model--------\n");
        scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");

        String model = scanner.nextLine();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMakeModel(make, model);
        displayVehicles(filteredVehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("\n--------Display vehicles by year--------\n");
        System.out.print("Min: ");
        int min = scanner.nextInt();

        System.out.print("Max: ");
        int max = scanner.nextInt();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByYear(min, max);

        displayVehicles(filteredVehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("\n--------Display vehicles by color--------\n");
        scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByColor(color);
        displayVehicles(filteredVehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("\n--------Display vehicles by mileage--------\n");
        System.out.print("Min: ");
        int min = scanner.nextInt();

        System.out.print("Max: ");
        int max = scanner.nextInt();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMileage(min, max);

        displayVehicles(filteredVehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("\n--------Display vehicles by type--------\n");
        scanner.nextLine();
        System.out.print("Car, truck, SUV, or van? ");
        String type = scanner.nextLine();

        System.out.println("vin, year, make, model, type, color, odometer, price");

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByType(type);

        displayVehicles(filteredVehicles);
    }

    private void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("\n---------Printing all vehicles-----------\n");

        System.out.println("vin, year, make, model, type, color, odometer, price");

        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest(){
        System.out.println("\n---------Add a vehicle----------\n");
        scanner.nextLine();

        System.out.print("VIN: ");
        int vin;
        try{
            vin = Integer.parseInt(scanner.nextLine());
            if(vin <= 0) {
                System.out.println("VIN must be a positive number");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("VIN must be a number");
            return;
        }

        System.out.print("Year: ");
        int year;
        try{
            year = Integer.parseInt(scanner.nextLine());
            if(year <= 0) {
                System.out.println("Year must be a positive number");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Year must be a number");
            return;
        }

        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer;
        try{
            odometer = Integer.parseInt(scanner.nextLine());
            if(odometer <= 0) {
                System.out.println("odometer must be a positive number");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("odometer must be a number");
            return;
        }

        System.out.print("Price: ");
        double price;
        try{
            price = Double.parseDouble(scanner.nextLine());
            if(price <= 0) {
                System.out.println("Price must be a positive number");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Price must be a number");
            return;
        }

        Vehicle addVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(addVehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle successfully added");
    }

    private void processRemoveVehicleRequest(){
        System.out.println("\n---------Remove a vehicle----------\n");
        scanner.nextLine();

        System.out.print("VIN: ");
        int vin;

        try{
            vin = Integer.parseInt(scanner.nextLine());
            if(vin <= 0) {
                System.out.println("VIN must be a positive number");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("VIN must be a number");
            return;
        }

        for(Vehicle vehicle : dealership.getAllVehicles()){
            if(vehicle.getVin() == vin){
                dealership.removeVehicle(vehicle);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Vehicle successfully removed");
                return;
            }
        }

        System.out.println("VIN number not found, try again");
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle: vehicles){
            System.out.print(vehicle);
        }
    }

}