package org.example.items;

import org.example.Equipment;

/**
 * The Sword class represents a specific type of equipment, namely a sword.
 * It extends the generic Equipment class and includes additional properties specific to a sword, such as length.
 */
public class Sword extends Equipment {
    /**
     * The length of the sword.
     */
    int length;

    /**
     * Constructs a new Sword instance with the specified name, price, weight, and length.
     *
     * @param name   The name of the sword.
     * @param price  The price of the sword.
     * @param weight The weight of the sword.
     * @param length The length of the sword.
     * @throws IllegalArgumentException If the specified length is negative.
     */
    public Sword(String name, double price, double weight, int length) {
        super(name, price, weight);

        if (length < 0) {
            throw new IllegalArgumentException("Sword length cannot be negative.");
        }
        this.length = length;
    }
}
