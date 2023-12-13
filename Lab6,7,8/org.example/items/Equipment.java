package org.example.items;

/**
 * The Equipment class represents a generic piece of equipment with a name, price, and weight.
 */
public class Equipment {
    public String name;
    public double price;
    public double weight;

    /**
     * Constructs a new Equipment instance with the specified name, price, and weight.
     *
     * @param name   The name of the equipment.
     * @param price  The price of the equipment.
     * @param weight The weight of the equipment.
     */
    public Equipment(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    /**
     * Returns a string representation of the Equipment object.
     *
     * @return A string containing the name, price, and weight of the equipment.
     */
    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}' + "\n";
    }
}