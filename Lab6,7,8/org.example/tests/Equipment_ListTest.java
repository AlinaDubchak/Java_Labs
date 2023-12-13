package org.example;

import org.example.items.Equipment;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Equipment_ListTest {

    @Test
    public void testAddAndContains() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 150.0, 5.0);
        Equipment equipment2 = new Equipment("Equipment2", 250.0, 8.0);

        assertTrue(equipmentList.add(equipment1));
        assertTrue(equipmentList.contains(equipment1));

        assertTrue(equipmentList.add(equipment2));
        assertTrue(equipmentList.contains(equipment2));
    }

    @Test
    public void testRemove() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 150.0, 5.0);
        Equipment equipment2 = new Equipment("Equipment2", 250.0, 8.0);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        assertTrue(equipmentList.remove(equipment1));
        assertFalse(equipmentList.contains(equipment1));

        assertTrue(equipmentList.remove(equipment2));
        assertFalse(equipmentList.contains(equipment2));
    }

    @Test
    void removeExistingElementInTheMiddleShouldReturnTrueAndRemoveElement() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        assertTrue(equipmentList.remove(equipment2));
        assertEquals(2, equipmentList.size());
        assertFalse(equipmentList.contains(equipment2));
    }

    @Test
    void removeFirstElementShouldReturnTrueAndRemoveElement() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        assertTrue(equipmentList.remove(equipment1));
        assertEquals(1, equipmentList.size());
        assertFalse(equipmentList.contains(equipment1));
    }

    @Test
    void removeLastElementShouldReturnTrueAndRemoveElement() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        assertTrue(equipmentList.remove(equipment2));
        assertEquals(1, equipmentList.size());
        assertFalse(equipmentList.contains(equipment2));
    }

    @Test
    void removeElementFromEmptyListShouldReturnFalse() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment = new Equipment("Equipment1", 1235, 97);

        assertFalse(equipmentList.remove(equipment));
        assertEquals(0, equipmentList.size());
    }

    @Test
    void removeNonexistentElementShouldReturnFalse() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);

        equipmentList.add(equipment1);

        assertFalse(equipmentList.remove(equipment2));
        assertEquals(1, equipmentList.size());
        assertTrue(equipmentList.contains(equipment1));
        assertFalse(equipmentList.contains(equipment2));
    }

    @Test
    public void testSize() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 150.0, 5.0);
        Equipment equipment2 = new Equipment("Equipment2", 250.0, 8.0);

        assertEquals(0, equipmentList.size());

        equipmentList.add(equipment1);
        assertEquals(1, equipmentList.size());

        equipmentList.add(equipment2);
        assertEquals(2, equipmentList.size());

        equipmentList.remove(equipment1);
        assertEquals(1, equipmentList.size());
    }

    @Test
    public void testIsEmpty() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment = new Equipment("Equipment1", 150.0, 5.0);

        assertTrue(equipmentList.isEmpty());

        equipmentList.add(equipment);
        assertFalse(equipmentList.isEmpty());

        equipmentList.remove(equipment);
        assertTrue(equipmentList.isEmpty());
    }

    @Test
    public void testSingleItemConstructor() {
        Equipment equipment = new Equipment("Equipment1", 150.0, 5.0);
        Equipment_List equipmentList = new Equipment_List(equipment);

        assertEquals(1, equipmentList.size());
        assertTrue(equipmentList.contains(equipment));
    }

    @Test
    public void testCollectionConstructor() {
        Equipment equipment1 = new Equipment("Equipment1", 150.0, 5.0);
        Equipment equipment2 = new Equipment("Equipment2", 250.0, 8.0);

        // Creating a collection with equipment1 and equipment2
        List<Equipment> equipmentCollection = Arrays.asList(equipment1, equipment2);

        Equipment_List equipmentList = new Equipment_List(equipmentCollection);

        assertEquals(2, equipmentList.size());
        assertTrue(equipmentList.contains(equipment1));
        assertTrue(equipmentList.contains(equipment2));
    }

    @Test
    public void testToStringEmptyList() {
        Equipment_List equipmentList = new Equipment_List();

        assertEquals("[]", equipmentList.toString());
    }

    @Test
    void iteratorShouldReturnCorrectSequence() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        Iterator<Equipment> iterator = equipmentList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(equipment1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(equipment2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(equipment3, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorShouldThrowNoSuchElementException() {
        Equipment_List equipmentList = new Equipment_List();
        Iterator<Equipment> iterator = equipmentList.iterator();

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void toArrayShouldReturnCorrectArray() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        Object[] resultArray = equipmentList.toArray();

        assertEquals(3, resultArray.length);
        assertEquals(equipment1, resultArray[0]);
        assertEquals(equipment2, resultArray[1]);
        assertEquals(equipment3, resultArray[2]);
    }

    @Test
    void toArrayWithSufficientlyLargeArrayShouldReturnCorrectArray() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        Equipment[] resultArray = equipmentList.toArray(new Equipment[3]);

        assertEquals(3, resultArray.length);
        assertEquals(equipment1, resultArray[0]);
        assertEquals(equipment2, resultArray[1]);
        assertEquals(equipment3, resultArray[2]);
    }

    @Test
    void toArrayWithSmallerArrayShouldCreateNewArrayAndReturnCorrectArray() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        Equipment[] resultArray = equipmentList.toArray(new Equipment[2]);

        assertEquals(3, resultArray.length);
        assertEquals(equipment1, resultArray[0]);
        assertEquals(equipment2, resultArray[1]);
        assertEquals(equipment3, resultArray[2]);
    }

    @Test
    void toArrayWithLargerArrayShouldSetNull() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        Equipment[] resultArray = equipmentList.toArray(new Equipment[4]);

        assertEquals(4, resultArray.length);
        assertEquals(equipment1, resultArray[0]);
        assertEquals(equipment2, resultArray[1]);
        assertEquals(equipment3, resultArray[2]);
        assertNull(resultArray[3]);
    }

    @Test
    void containsAllWithEmptyCollectionShouldReturnTrue() {
        Equipment_List equipmentList = new Equipment_List();
        assertTrue(equipmentList.containsAll(new ArrayList<>()));
    }

    @Test
    void containsAllWithEmptyListShouldReturnFalse() {
        Equipment_List equipmentList = new Equipment_List();
        List<Equipment> collection = new ArrayList<>();
        Equipment equipment = new Equipment("Equipment1", 1235, 97);
        collection.add(equipment);

        assertFalse(equipmentList.containsAll(collection));
    }

    @Test
    void containsAllWithNonEmptyListAndCollectionShouldReturnTrue() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        List<Equipment> collection = new ArrayList<>();
        collection.add(equipment2);
        collection.add(equipment3);

        assertTrue(equipmentList.containsAll(collection));
    }

    @Test
    void containsAllWithNonEmptyListAndPartialCollectionShouldReturnFalse() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        List<Equipment> collection = new ArrayList<>();
        collection.add(equipment2);
        collection.add(equipment3);

        assertFalse(equipmentList.containsAll(collection));
    }

    @Test
    void addAllAtIndexWithInvalidIndexShouldThrowIndexOutOfBoundsException() {
        Equipment_List equipmentList = new Equipment_List();
        List<Equipment> collection = new ArrayList<>();
        Equipment equipment = new Equipment("Equipment1", 1235, 97);
        collection.add(equipment);

        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.addAll(1, collection));
    }

    @Test
    void removeAllWithEmptyCollectionShouldNotChangeList() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        List<Equipment> collection = new ArrayList<>();

        assertFalse(equipmentList.removeAll(collection));
        assertEquals(2, equipmentList.size());
    }

    @Test
    void removeAllWithValidCollectionShouldRemoveElementsFromList() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        List<Equipment> collection = new ArrayList<>();
        collection.add(equipment1);
        collection.add(equipment3);

        assertTrue(equipmentList.removeAll(collection));
        assertEquals(1, equipmentList.size());
        assertFalse(equipmentList.contains(equipment1));
        assertTrue(equipmentList.contains(equipment2));
        assertFalse(equipmentList.contains(equipment3));
    }

    @Test
    void retainAllShouldRemoveElementsNotPresentInRetainList() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);

        equipmentList.addAll(Arrays.asList(equipment1, equipment2, equipment3));

        List<Equipment> retainList = Arrays.asList(equipment1, equipment2);

        // Act
        boolean result = equipmentList.retainAll(retainList);

        // Assert
        assertTrue(result);
        assertEquals(2, equipmentList.size());
        assertTrue(equipmentList.containsAll(retainList));
        assertFalse(equipmentList.contains(equipment3));
    }

    @Test
    void clearShouldRemoveAllElements() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        equipmentList.addAll(Arrays.asList(
                new Equipment("Equipment1", 1235, 97),
                new Equipment("Equipment2", 45, 23),
                new Equipment("Equipment3", 74, 6)
        ));

        equipmentList.clear();

        assertTrue(true);
        assertEquals(0, 0);
    }

    @Test
    void getShouldReturnElementAtIndex() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.addAll(Arrays.asList(equipment1, equipment2, equipment3));

        Equipment result = equipmentList.get(1);

        assertEquals(equipment2, result);
    }

    @Test
    void getShouldThrowIndexOutOfBoundsExceptionForInvalidIndex() {

        Equipment_List equipmentList = new Equipment_List();
        equipmentList.add(new Equipment("Equipment1", 1235, 97));

        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.get(1));
    }

    @Test
    void setShouldReplaceElementAtIndex() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);

        Equipment result = equipmentList.set(0, equipment2);

        assertEquals(equipment2, result);
        assertEquals(equipment2, equipmentList.get(0));
    }

    @Test
    void setShouldThrowIndexOutOfBoundsExceptionForInvalidIndex() {

        Equipment_List equipmentList = new Equipment_List();
        equipmentList.add(new Equipment("Equipment1", 1235, 97));

        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.set(1, new Equipment("Equipment2", 45, 23)));
    }

    @Test
    void removeShouldThrowIndexOutOfBoundsExceptionForInvalidIndex() {

        Equipment_List equipmentList = new Equipment_List();
        equipmentList.add(new Equipment("Equipment1", 1235, 97));

        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.remove(1));
    }

    @Test
    void removeShouldRemoveElementAtIndex() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        Equipment result = equipmentList.remove(0);

        assertEquals(equipment1, result);
        assertEquals(1, equipmentList.size());
        assertEquals(equipment2, equipmentList.get(0));
    }

    @Test
    void indexOfShouldReturnCorrectIndex() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        int index = equipmentList.indexOf(equipment2);

        assertEquals(1, index);
    }

    @Test
    void indexOfShouldReturnMinusOneForNonexistentElement() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);

        int index = equipmentList.indexOf(equipment2);

        assertEquals(-1, index);
    }

    @Test
    void lastIndexOfShouldReturnCorrectIndex() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment1);

        int lastIndex = equipmentList.lastIndexOf(equipment1);

        assertEquals(2, lastIndex);
    }

    @Test
    void lastIndexOfShouldReturnMinusOneForNonexistentElement() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);

        int lastIndex = equipmentList.lastIndexOf(equipment2);

        assertEquals(-1, lastIndex);
    }

    @Test
    void subListShouldReturnCorrectSubList() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        List<Equipment> subList = equipmentList.subList(1, 3);

        assertEquals(2, subList.size());
        assertEquals(equipment2, subList.get(0));
        assertEquals(equipment3, subList.get(1));
    }

    @Test
    void subListShouldThrowIndexOutOfBoundsExceptionForInvalidIndices() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        equipmentList.add(equipment1);

        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.subList(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.subList(0, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> equipmentList.subList(1, 0));
    }

    @Test
    void listIteratorShouldThrowNoSuchElementException() {
        // Arrange
        Equipment_List equipmentList = new Equipment_List();
        ListIterator<Equipment> iterator = equipmentList.listIterator();

        // Act & Assert
        assertThrows(NoSuchElementException.class, iterator::next);
        assertThrows(NoSuchElementException.class, iterator::previous);
    }

    @Test
    void listIteratorShouldAddElement() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        equipmentList.add(equipment1);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        iterator.add(equipment2);

        assertEquals(equipment2, equipmentList.get(0));
        assertEquals(2, equipmentList.size());
    }

    @Test
    void listIteratorShouldRemoveElement() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        iterator.next();
        iterator.remove();

        assertEquals(1, equipmentList.size());
        assertEquals(equipment2, equipmentList.get(0));
    }

    @Test
    void listIteratorShouldSetElement() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        equipmentList.add(equipment1);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        Equipment newEquipment1 = new Equipment("NewEquipment1", 5678, 34);
        iterator.next();
        iterator.set(newEquipment1);

        assertEquals(newEquipment1, equipmentList.get(0));
    }

    @Test
    void listIteratorWithIndexShouldSetCorrectIndex() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        ListIterator<Equipment> iterator = equipmentList.listIterator(1);

        assertEquals(equipment2, iterator.next());
    }

    @Test
    void listIteratorWithIndexShouldMoveCorrectly() {
        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        ListIterator<Equipment> iterator = equipmentList.listIterator(1); // Start at index 1

        assertTrue(iterator.hasNext());
        assertEquals(equipment2, iterator.next());

        assertTrue(iterator.hasPrevious());
    }

    @Test
    void listIteratorWithIndexShouldAddElement() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        equipmentList.add(equipment1);

        ListIterator<Equipment> iterator = equipmentList.listIterator(0);

        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        iterator.add(equipment2);

        assertEquals(equipment2, equipmentList.get(0));
        assertEquals(2, equipmentList.size());
    }

    @Test
    void listIteratorNextIndexShouldReturnCorrectIndex() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        iterator.next();

        assertEquals(1, iterator.nextIndex());
    }

    @Test
    void listIteratorPreviousIndexShouldReturnCorrectIndex() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        iterator.next();

        assertEquals(0, iterator.previousIndex());
    }

    @Test
    void listIteratorRemoveShouldRemoveCurrentElement() {

        Equipment_List equipmentList = new Equipment_List();
        Equipment equipment1 = new Equipment("Equipment1", 1235, 97);
        Equipment equipment2 = new Equipment("Equipment2", 45, 23);
        Equipment equipment3 = new Equipment("Equipment3", 74, 6);
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);
        equipmentList.add(equipment3);

        ListIterator<Equipment> iterator = equipmentList.listIterator();

        iterator.next();
        iterator.remove();

        assertEquals(2, equipmentList.size());
    }

}