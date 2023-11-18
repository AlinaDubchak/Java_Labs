package Java_Labs.Lab4;
package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The FurnitureSorter class demonstrates sorting an array of Furniture objects based on weight and price.
 */
class FurnitureSorter {

    /**
     * The main method initializes an array of Furniture objects, sorts it by weight in ascending order,
     * and then sorts it by price in descending order.
     *
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Creating an array from "Furniture" class objects
        Furniture[] furnitureArray = new Furniture[5];

        // Initializing Furniture objects in the array
        furnitureArray[0] = new Furniture("Table", 120, 70, 74, 24);
        furnitureArray[1] = new Furniture("Sofa", 120, 134, 95, 50);
        furnitureArray[2] = new Furniture("Bed", 200, 140, 60, 30);
        furnitureArray[3] = new Furniture("Wardrobe", 100, 60, 200, 230);
        furnitureArray[4] = new Furniture("Chair", 40, 60, 102, 10);

        // Sorting the array in ascending order by the "weight" field
        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getWeight));

        System.out.println("Sort by height by weight:");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Sort the array in descending order by the "cost" field
        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getPrice).reversed());

        System.out.println("\nSort by price in descending order:");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }
    }
}

/**
 * The Furniture class represents furniture objects with properties such as name, dimensions, weight, and price.
 */
public class Furniture {

    private final String name;
    private final int length;
    private final int width;
    private final int height;
    private final int weight;
    private final int price;

    /**
     * Constructs a Furniture object with the specified parameters.
     *
     * @param name   The name of the furniture.
     * @param length The length of the furniture.
     * @param width  The width of the furniture.
     * @param height The height of the furniture.
     * @param weight The weight of the furniture.
     */
    public Furniture(String name, int length, int width, int height, int weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.price = calculatePrice();
    }

    /**
     * Gets the weight of the furniture.
     *
     * @return The weight of the furniture.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the price of the furniture.
     *
     * @return The price of the furniture.
     */
    public int getPrice() {
        return price;
    }

    // Private method to calculate the price based on dimensions and weight
    private int calculatePrice() {
        return length * width + height + weight;
    }

    /**
     * Returns a string representation of the Furniture object.
     *
     * @return A string containing information about the furniture.
     */
    @Override
    public String toString() {
        return "Furniture: " + name + ", Weight: " + weight + " кг, Price: " + price + " грн";
    }
}