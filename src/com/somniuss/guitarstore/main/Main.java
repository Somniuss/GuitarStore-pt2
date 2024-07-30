package com.somniuss.guitarstore.main;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.controller.impl.AddInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.UpdateInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.DeleteInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.FindInstrumentCommand;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Command addInstrumentCommand = new AddInstrumentCommand();
        Command updateInstrumentCommand = new UpdateInstrumentCommand();
        Command deleteInstrumentCommand = new DeleteInstrumentCommand();
        Command findInstrumentCommand = new FindInstrumentCommand();

        while (true) {
            System.out.println("\nGuitar Store Application Menu:");
            System.out.println("1. Add Instrument");
            System.out.println("2. Update Instrument");
            System.out.println("3. Delete Instrument");
            System.out.println("4. Find Instrument by ID");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Instrument
                    System.out.println("Enter instrument details:");
                    System.out.println("Type (ElectricGuitar/BassGuitar):");
                    String type = scanner.nextLine();
                    System.out.println("Brand:");
                    String brand = scanner.nextLine();
                    System.out.println("Model:");
                    String model = scanner.nextLine();
                    System.out.println("Price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    String additionalDetails = "";
                    if (type.equalsIgnoreCase("BassGuitar")) {
                        System.out.println("Electronics:");
                        additionalDetails = scanner.nextLine();
                    } else if (type.equalsIgnoreCase("ElectricGuitar")) {
                        System.out.println("Body Shape:");
                        String bodyShape = scanner.nextLine();
                        System.out.println("Tremolo System:");
                        String tremoloSystem = scanner.nextLine();
                        additionalDetails = bodyShape + "," + tremoloSystem;
                    }

                    // Prepare request in the expected format for AddInstrumentCommand
                    String addRequest = type + "\n" + brand + "\n" + model + "\n" + price + "\n" + additionalDetails;
                    System.out.println(addInstrumentCommand.execute(addRequest));
                    break;

                case 2: // Update Instrument
                    System.out.println("Enter instrument details to update:");
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Type (ElectricGuitar/BassGuitar):");
                    String updateType = scanner.nextLine();
                    System.out.println("Brand:");
                    String updateBrand = scanner.nextLine();
                    System.out.println("Model:");
                    String updateModel = scanner.nextLine();
                    System.out.println("Price:");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    String updateAdditionalDetails = "";
                    if (updateType.equalsIgnoreCase("BassGuitar")) {
                        System.out.println("Electronics:");
                        updateAdditionalDetails = scanner.nextLine();
                    } else if (updateType.equalsIgnoreCase("ElectricGuitar")) {
                        System.out.println("Body Shape:");
                        String updateBodyShape = scanner.nextLine();
                        System.out.println("Tremolo System:");
                        String updateTremoloSystem = scanner.nextLine();
                        updateAdditionalDetails = updateBodyShape + "," + updateTremoloSystem;
                    }

                    // Prepare request in the expected format for UpdateInstrumentCommand
                    String updateRequest = id + "\n" + updateType + "\n" + updateBrand + "\n" + updateModel + "\n" + updatePrice + "\n" + updateAdditionalDetails;
                    System.out.println(updateInstrumentCommand.execute(updateRequest));
                    break;

                case 3: // Delete Instrument
                    System.out.print("Enter ID of the instrument to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println(deleteInstrumentCommand.execute(String.valueOf(deleteId)));
                    break;

                case 4: // Find Instrument by ID
                    System.out.print("Enter ID of the instrument to find: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println(findInstrumentCommand.execute(String.valueOf(findId)));
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
