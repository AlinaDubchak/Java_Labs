package org.example.items;

import org.junit.Test;

public class HelmetTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new Helmet("Negative Price Helmet", -10.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeight() {
        new Helmet("Negative Weight Helmet", 30.0, -5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new Helmet(null, 40.0, 25.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Helmet(" ", 40.0, 25.0);
    }
}