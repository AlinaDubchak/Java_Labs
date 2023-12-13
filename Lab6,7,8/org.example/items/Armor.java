package org.example.items;

/**
 * The Armor class represents a specific type of equipment, namely armor.
 * It extends the generic Equipment class and includes additional properties specific to armor, such as material.
 */
public class Armor extends Equipment {

        /**
         * Constructs a new Armor instance with the specified name, price, weight, and material.
         *
         * @param name   The name of the armor.
         * @param price  The price of the armor.
         * @param weight The weight of the armor.
         * @throws IllegalArgumentException If the specified name is null or empty, or if weight or price is negative.
         */
        public Armor(String name, double price, double weight) {
            super(name, price, weight);

            if (weight < 0 || price < 0) {
                throw new IllegalArgumentException("Armor weight or price cannot be negative.");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Armor name cannot be null or empty.");
            }
        }
    }