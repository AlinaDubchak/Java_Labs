package org.example.items;

import org.junit.Test;

public class SwordTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new Sword("Negative Price Sword", -10.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeight() {
        new Sword("Negative Weight Sword", 30.0, -5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new Sword(null, 40.0, 25.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Sword(" ", 40.0, 25.0);
    }
}