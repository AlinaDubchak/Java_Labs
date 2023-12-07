package org.example.items;

import org.example.Equipment;

/**
 * The Armor class represents a specific type of equipment, namely armor.
 * It extends the generic Equipment class and includes additional properties specific to armor, such as material.
 */
public class Armor extends Equipment {
    /**
     * The material of the armor.
     */
    String material;

    /**
     * Constructs a new Armor instance with the specified name, price, weight, and material.
     *
     * @param name     The name of the armor.
     * @param price    The price of the armor.
     * @param weight   The weight of the armor.
     * @param material The material of the armor.
     * @throws IllegalArgumentException If the specified material is null or empty.
     */
    public Armor(String name, double price, double weight, String material) {
        super(name, price, weight);

        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Armor material cannot be null or empty.");
        }

        this.material = material;
    }
}
