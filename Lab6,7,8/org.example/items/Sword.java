package org.example.items;

/**
 * The Sword class represents a specific type of equipment, namely a sword.
 * It extends the generic Equipment class and includes additional properties specific to a sword, such as length.
 */
public class Sword extends Equipment {

    /**
     * Constructs a new Sword instance with the specified name, price, weight, and length.
     *
     * @param name   The name of the sword.
     * @param price  The price of the sword.
     * @param weight The weight of the sword.
     * @throws IllegalArgumentException If the specified length is negative.
     */
    public Sword(String name, double price, double weight) {
        super(name, price, weight);

        if (weight < 0 || price <0) {
            throw new IllegalArgumentException("Sword weight or price cannot be negative.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Sword name cannot be null or empty.");
        }
    }
}
