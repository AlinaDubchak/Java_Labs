package org.example;

import org.example.items.*;

import java.util.ArrayList;

/**
 * The Main class serves as the entry point for the knight equipment demonstration.
 * It showcases the usage of various equipment items, their organization in KnightEquipment,
 * and the execution of operations such as displaying hierarchy, calculating total cost,
 * sorting by weight, and finding equipment in a specific price range.
 *
 * <p>Usage:
 * - Create instances of Sword, Shield, Armor, and Helmet.
 * - Add these equipment items to Knight.
 * - Display the hierarchy of equipment.
 * - Calculate and display the total cost of equipment.
 * - Sort equipment items by weight and display the sorted list.
 * - Find and display equipment items in a specific price range.
 *
 * <p>The code includes exception handling to catch and print any unexpected errors.
 *
 * @author Alina Dubchak
 * @version 1.0
 * @since 2023-12-07
 */
public class Main {

    /**
     * The main method demonstrates the usage of knight equipment.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            // Create instances of equipment items
            Sword sword = new Sword("Excalibur", 150.0, 5.0);
            Shield shield = new Shield("Iron Shield", 50.0, 10.0);
            Armor armor = new Armor("Steel Armor", 200.0, 15.0);
            Helmet helmet = new Helmet("Steel Helmet", 100.0, 8.0);

            // Create an instance of KnightEquipment
            Knight knight = new Knight();

            // Add equipment items to KnightEquipment
            knight.addEquipment(sword);
            knight.addEquipment(shield);
            knight.addEquipment(armor);
            knight.addEquipment(helmet);

            // Display the hierarchy of equipment
            knight.displayHierarchy();

            // Calculate and display the total cost of equipment
            System.out.println("\nTotal cost of equipment: " + knight.calculateTotalCost() + "\n");

            // Sort equipment items by weight and display the sorted list
            knight.sortByWeight();
            System.out.println("Equipment sorted by weight: \n");
            for (Equipment equipment : knight.equipmentList) {
                System.out.println(equipment);
            }

            // Find and display equipment items in a specific price range
            double minPrice = 50.0;
            double maxPrice = 150.0;
            ArrayList<Equipment> result = knight.findEquipmentInPriceRange(minPrice, maxPrice);
            System.out.println("\nEquipment in the price range [" + minPrice + ", " + maxPrice + "]: \n");
            for (Equipment equipment : result) {
                System.out.println(equipment);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}