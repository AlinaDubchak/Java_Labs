package org.example.items;

import org.junit.Test;

public class ArmorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new Armor("Negative Price Armor", -10.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeight() {
        new Armor("Negative Weight Armor", 30.0, -5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new Armor(null, 40.0, 25.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Armor(" ", 40.0, 25.0);
    }
}