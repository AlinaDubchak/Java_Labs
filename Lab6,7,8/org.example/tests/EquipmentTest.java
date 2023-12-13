package org.example.items;

import org.junit.Test;
import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void testEquipmentConstructor() {
        Equipment equipment = new Equipment("Sword", 30.0, 5.0);
        assertEquals("Sword", equipment.name);
        assertEquals(30.0, equipment.price, 0.001);
        assertEquals(5.0, equipment.weight, 0.001);
    }

    @Test
    public void testEquipmentToString() {
        Equipment equipment = new Equipment("Shield", 20.0, 8.0);
        String expectedString = "Equipment{name='Shield', price=20.0, weight=8.0}\n";
        assertEquals(expectedString, equipment.toString());
    }
}