package org.example.items;

import org.example.Equipment;

/**
 * The Shield class represents a specific type of equipment, namely a shield.
 * It extends the generic Equipment class and includes additional properties specific to a shield, such as size.
 */
public class Shield extends Equipment {
    /**
     * The size of the shield.
     */
    int size;

    /**
     * Constructs a new Shield instance with the specified name, price, weight, and size.
     *
     * @param name   The name of the shield.
     * @param price  The price of the shield.
     * @param weight The weight of the shield.
     * @param size   The size of the shield.
     * @throws IllegalArgumentException If the specified size is negative.
     */
    public Shield(String name, double price, double weight, int size) {
        super(name, price, weight);

        if (size < 0) {
            throw new IllegalArgumentException("Shield size cannot be negative.");
        }
        this.size = size;
    }
}
