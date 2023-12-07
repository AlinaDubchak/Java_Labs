package org.example.items;

import org.example.Equipment;

/**
 * The Helmet class represents a specific type of equipment, namely a helmet.
 * It extends the generic Equipment class and includes additional properties specific to a helmet, such as protection level.
 */
public class Helmet extends Equipment {
    /**
     * The protection level of the helmet.
     */
    int protectionLevel;

    /**
     * Constructs a new Helmet instance with the specified name, price, weight, and protection level.
     *
     * @param name            The name of the helmet.
     * @param price           The price of the helmet.
     * @param weight          The weight of the helmet.
     * @param protectionLevel The protection level of the helmet.
     * @throws IllegalArgumentException If the specified protection level is negative.
     */
    public Helmet(String name, double price, double weight, int protectionLevel) {
        super(name, price, weight);

        if (protectionLevel < 0) {
            throw new IllegalArgumentException("Protection level of the helmet cannot be negative.");
        }

        this.protectionLevel = protectionLevel;
    }
}
