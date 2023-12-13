package org.example.items;

/**
 * The Helmet class represents a specific type of equipment, namely a helmet.
 * It extends the generic Equipment class and includes additional properties specific to a helmet, such as protection level.
 */
public class Helmet extends Equipment {

    /**
     * Constructs a new Helmet instance with the specified name, price, weight, and protection level.
     *
     * @param name            The name of the helmet.
     * @param price           The price of the helmet.
     * @param weight          The weight of the helmet.
     * @throws IllegalArgumentException If the specified protection level is negative.
     */
    public Helmet(String name, double price, double weight) {
        super(name, price, weight);

        if (weight < 0|| price<0) {
            throw new IllegalArgumentException("Helmet weight or price cannot be negative.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Helmet name cannot be null or empty.");
        }
    }
}
