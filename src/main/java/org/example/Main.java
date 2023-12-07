package org.example;

import org.example.items.Armor;
import org.example.items.Shield;
import org.example.items.Sword;
import org.example.items.Helmet;

import java.util.ArrayList;

/**
 * The Main class serves as the entry point for the knight equipment demonstration.
 * It showcases the usage of various equipment items, their organization in KnightEquipment,
 * and the execution of operations such as displaying hierarchy, calculating total cost,
 * sorting by weight, and finding equipment in a specific price range.
 *
 * <p>Usage:
 * - Create instances of Sword, Shield, Armor, and Helmet.
 * - Add these equipment items to KnightEquipment.
 * - Display the hierarchy of equipment.
 * - Calculate and display the total cost of equipment.
 * - Sort equipment items by weight and display the sorted list.
 * - Find and display equipment items in a specific price range.
 *
 * <p>The code includes exception handling to catch and print any unexpected errors.
 *
 * @author Your Name
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
            Sword sword = new Sword("Excalibur", 150.0, 5.0, 40);
            Shield shield = new Shield("Iron Shield", 50.0, 10.0, 30);
            Armor armor = new Armor("Steel Armor", 200.0, 15.0, "Steel");
            Helmet helmet = new Helmet("Steel Helmet", 100.0, 8.0, 2);

            // Create an instance of KnightEquipment
            KnightEquipment knightEquipment = new KnightEquipment();

            // Add equipment items to KnightEquipment
            knightEquipment.addEquipment(sword);
            knightEquipment.addEquipment(shield);
            knightEquipment.addEquipment(armor);
            knightEquipment.addEquipment(helmet);

            // Display the hierarchy of equipment
            knightEquipment.displayHierarchy();

            // Calculate and display the total cost of equipment
            System.out.println("\nTotal cost of equipment: " + knightEquipment.calculateTotalCost() + "\n");

            // Sort equipment items by weight and display the sorted list
            knightEquipment.sortByWeight();
            System.out.println("Equipment sorted by weight: \n");
            for (Equipment equipment : knightEquipment.equipmentList) {
                System.out.println(equipment);
            }

            // Find and display equipment items in a specific price range
            double minPrice = 50.0;
            double maxPrice = 150.0;
            ArrayList<Equipment> result = knightEquipment.findEquipmentInPriceRange(minPrice, maxPrice);
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