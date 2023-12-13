package org.example.items;

/**
 * The Shield class represents a specific type of equipment, namely a shield.
 * It extends the generic Equipment class and includes additional properties specific to a shield, such as size.
 */
public class Shield extends Equipment {

    /**
     * Constructs a new Shield instance with the specified name, price, weight, and size.
     *
     * @param name   The name of the shield.
     * @param price  The price of the shield.
     * @param weight The weight of the shield.
     * @throws IllegalArgumentException If the specified size is negative.
     */
    public Shield(String name, double price, double weight) {
        super(name, price, weight);

        if (weight < 0|| price<0) {
            throw new IllegalArgumentException("Shield weight cannot be negative.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Shield name cannot be null or empty.");
        }
    }
}
