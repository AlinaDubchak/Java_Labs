package org.example;

import org.example.items.Equipment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The KnightEquipment class represents a collection of equipment items for a knight.
 * It provides methods to add equipment, display the hierarchy, calculate total cost,
 * sort by weight, and find equipment within a specified price range.
 */
class Knight {
//    List<Equipment> equipmentList = new Equipment_List();
    ArrayList<Equipment> equipmentList = new ArrayList<>();
    /**
     * Adds an equipment item to the knight's equipment.
     *
     * @param equipment The equipment item to be added.
     */
    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    /**
     * Displays the hierarchy of the knight's equipment.
     */
    public void displayHierarchy() {
        System.out.println("Knight's Equipment:" + "\n");
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment);
        }
    }

    /**
     * Calculates and returns the total cost of all equipment items.
     *
     * @return The total cost of all equipment items.
     */
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Equipment equipment : equipmentList) {
            totalCost += equipment.price;
        }
        return totalCost;
    }

    /**
     * Sorts the equipment items by weight in ascending order.
     */
    public void sortByWeight() {
        equipmentList.sort(Comparator.comparingDouble(equipment -> equipment.weight));
    }

    /**
     * Finds and returns equipment items within the specified price range.
     *
     * @param minPrice The minimum price of the equipment range.
     * @param maxPrice The maximum price of the equipment range.
     * @return An ArrayList containing equipment items within the specified price range.
     * @throws IllegalArgumentException If the minPrice is greater than maxPrice.
     * @throws RuntimeException         If no equipment is found in the specified price range.
     */
    public ArrayList<Equipment> findEquipmentInPriceRange(double minPrice, double maxPrice) {
        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Invalid price range: minPrice should be less than or equal to maxPrice.");
        }

        ArrayList<Equipment> result = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            if (equipment.price >= minPrice && equipment.price <= maxPrice) {
                result.add(equipment);
            }
        }

        if (result.isEmpty()) {
            throw new RuntimeException("No equipment found in the specified price range.");
        }

        return result;
    }
}
