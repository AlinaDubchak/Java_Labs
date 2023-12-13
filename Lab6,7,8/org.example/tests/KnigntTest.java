package org.example;

import org.example.items.Equipment;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight knight;

    @Before
    public void setUp() {
        knight = new Knight();
        knight.addEquipment(new Equipment("Sword", 30.0, 5.0));
        knight.addEquipment(new Equipment("Shield", 20.0, 8.0));
        knight.addEquipment(new Equipment("Helmet", 15.0, 3.0));
    }

    @Test
    public void testFindEquipmentInPriceRange_NoEquipmentFound() {


        // Set up the price range where no equipment should be found
        double minPrice = 200.0;
        double maxPrice = 300.0;

        // Use assertThrows to verify that a RuntimeException is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            knight.findEquipmentInPriceRange(minPrice, maxPrice);
        });

        // Check the exception message
        assertEquals("No equipment found in the specified price range.", exception.getMessage());
    }

    @Test
    public void testCalculateTotalCost() {
        double totalCost = knight.calculateTotalCost();
        assertEquals(65.0, totalCost, 0.001);
    }

    @Test
    public void testCalculateTotalCostWithEmptyEquipment() {
        knight = new Knight(); // Creating a new Knight with no equipment
        double totalCost = knight.calculateTotalCost();
        assertEquals(0.0, totalCost, 0.001);
    }

    @Test
    public void testSortByWeight() {
        knight.sortByWeight();
        ArrayList<Equipment> sortedList = knight.equipmentList;

        assertEquals("Helmet", sortedList.get(0).name);
        assertEquals("Sword", sortedList.get(1).name);
        assertEquals("Shield", sortedList.get(2).name);
    }

    @Test
    public void testSortByWeightWithEqualWeights() {
        knight.addEquipment(new Equipment("Axe", 25.0, 5.0));
        knight.sortByWeight();
        ArrayList<Equipment> sortedList = knight.equipmentList;

        assertEquals("Helmet", sortedList.get(0).name);
        assertTrue(Arrays.asList("Sword", "Axe").contains(sortedList.get(1).name));
        assertEquals("Axe", sortedList.get(2).name);
    }

    @Test
    public void testFindEquipmentInPriceRange() {
        ArrayList<Equipment> result = knight.findEquipmentInPriceRange(10.0, 25.0);

        assertEquals(2, result.size());
        assertEquals("Shield", result.get(0).name);
        assertEquals("Helmet", result.get(1).name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindInvalidPriceRange() {
        knight.findEquipmentInPriceRange(30.0, 20.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindInvalidPriceRangeMaxMin() {
        knight.findEquipmentInPriceRange(50.0, 20.0);
    }
}
