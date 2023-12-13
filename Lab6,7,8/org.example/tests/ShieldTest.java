package org.example.items;

import org.junit.Test;

public class ShieldTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new Shield("Negative Price Shield", -10.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeight() {
        new Shield("Negative Weight Shield", 30.0, -5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new Shield(null, 40.0, 25.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Shield(" ", 40.0, 25.0);
    }
}