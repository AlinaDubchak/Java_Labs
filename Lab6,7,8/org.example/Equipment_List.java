package org.example;

import org.example.items.Equipment;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class Equipment_List implements List<Equipment> {
    private Node<Equipment> head;
    private int size;

    private static class Node<Equipment> {
        Equipment data;
        Node<Equipment> next;

        public Node(Equipment data) {
            this.data = data;
            this.next = null;
        }
    }

    public Equipment_List() {
        this.head = null;
        this.size = 0;
    }

    public Equipment_List(Equipment equipment) {
        this.head = new Node<>(equipment);
        this.size = 1;
    }

    public Equipment_List(Collection<? extends Equipment> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        Node<Equipment> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<Equipment> current = head;

        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }
    @Override
    public @NotNull Iterator<Equipment> iterator() {
        return new Iterator<>() {
            private Node<Equipment> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Equipment next() {
                if (!hasNext()) throw new NoSuchElementException();

                Equipment data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object @NotNull [] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<Equipment> current = head;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    @Override
    public <T> T @NotNull [] toArray(@NotNull T @NotNull [] a) {
        if (a.length < size) {
            // If the array is too small, create a new array of the same type with the correct size
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        } else if (a.length > size) {
            // If the array is larger than needed, set the element at the size index to null
            a[size] = null;
        }

        int index = 0;
        Node<Equipment> current = head;

        while (current != null) {
            a[index++] = (T) current.data;
            current = current.next;
        }

        return a;
    }

    @Override
    public boolean add(Equipment e) {
        Node<Equipment> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<Equipment> current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<Equipment> current = head;
        Node<Equipment> previous = null;

        while (current != null) {
            if (current.data.equals(o)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Equipment> c) {
        boolean isAdded = false;
        for (Equipment e : c) {
            add(e);
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Equipment> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        boolean isAdded = false;

        for (Equipment e : c) {
            add(index++, e);
            isAdded = true;
        }

        return isAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;

        for (Object o : c) {
            if (remove(o)) {
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        boolean isRemoved = false;

        Node<Equipment> current = head;
        Node<Equipment> previous = null;

        while (current != null) {
            if (!c.contains(current.data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                isRemoved = true;
            }
            previous = current;
            current = current.next;
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Equipment get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<Equipment> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            currentIndex++;
            current = current.next;
        }

        return null;
    }

    @Override
    public Equipment set(int index, Equipment element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<Equipment> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                current.data = element;
                return element;
            }
            currentIndex++;
            current = current.next;
        }

        return null;
    }

    @Override
    public void add(int index, Equipment element) {
        if (size == 0) {
            add(element);
            return;
        }

        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<Equipment> newNode = new Node<>(element);
        Node<Equipment> current = head;
        Node<Equipment> previous = null;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                if (previous == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    previous.next = newNode;
                    newNode.next = current;
                }
                size++;  // Збільшення розміру списку
                return;
            }
            currentIndex++;
            previous = current;
            current = current.next;
        }
    }


    @Override
    public Equipment remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<Equipment> current = head;
        Node<Equipment> previous = null;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.data;
            }
            currentIndex++;
            previous = current;
            current = current.next;
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node<Equipment> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (current.data.equals(o)) {
                return currentIndex;
            }
            currentIndex++;
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<Equipment> current = head;
        int currentIndex = 0;
        int lastIndex = -1;

        while (current != null) {
            if (current.data.equals(o)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }

        return lastIndex;
    }

    @NotNull
    @Override
    public ListIterator<Equipment> listIterator() {
        return new ListIterator<>() {
            private Node<Equipment> current = head;
            private Node<Equipment> lastReturned = null;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Equipment next() {
                if (!hasNext()) throw new NoSuchElementException();

                lastReturned = current;
                current = current.next;
                currentIndex++;
                return lastReturned.data;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public Equipment previous() {
                if (!hasPrevious()) throw new NoSuchElementException();

                if (current == null) {
                    current = head;
                } else {
                    current = current.next;
                }
                lastReturned = current;
                currentIndex--;
                return lastReturned.data;
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();

                if (lastReturned == head) {
                    head = head.next;
                } else {
                    Node<Equipment> previous = head;
                    while (previous.next != lastReturned) {
                        previous = previous.next;
                    }
                    previous.next = lastReturned.next;
                }
                size--;
                lastReturned = null;
            }

            @Override
            public void set(Equipment equipment) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.data = equipment;
            }

            @Override
            public void add(Equipment equipment) {
                Node<Equipment> newNode = new Node<>(equipment);
                if (lastReturned == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    newNode.next = lastReturned.next;
                    lastReturned.next = newNode;
                }
                size++;
                currentIndex++;
                lastReturned = null;
            }
        };
    }

    @Override
    public @NotNull ListIterator<Equipment> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return new ListIterator<>() {
            private Node<Equipment> current = head;
            private Node<Equipment> lastReturned = null;
            private int currentIndex = 0;

            {
                // Advance to the specified index
                while (currentIndex < index) {
                    if (current == null) {
                        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                    }
                    current = current.next;
                    currentIndex++;
                }
            }

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Equipment next() {
                if (!hasNext()) throw new NoSuchElementException();

                Node<Equipment> lastReturned = current;
                current = current.next;
                currentIndex++;
                return lastReturned.data;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0 && currentIndex <= size;
            }

            @Override
            public Equipment previous() {
                if (!hasPrevious()) throw new NoSuchElementException();

                Node<Equipment> lastReturned = current;
                Node<Equipment> previous = null;

                while (current != null && currentIndex > 0) {
                    previous = current;
                    current = current.next;
                    currentIndex--;
                }

                lastReturned = previous;
                return lastReturned.data;
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();

                if (lastReturned == head) {
                    head = head.next;
                } else {
                    Node<Equipment> previous = head;
                    while (previous.next != lastReturned) {
                        previous = previous.next;
                    }
                    previous.next = lastReturned.next;
                }
                size--;
                currentIndex--;
                lastReturned = null;
            }

            @Override
            public void set(Equipment equipment) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.data = equipment;
            }
            @Override
            public void add(Equipment equipment) {
                Node<Equipment> newNode = new Node<>(equipment);

                if (lastReturned == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    newNode.next = lastReturned.next;
                    lastReturned.next = newNode;
                }
                size++;
                currentIndex++;
                lastReturned = null;}
        };
        }

    @Override
    public @NotNull List<Equipment> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        Equipment_List subList = new Equipment_List();
        Node<Equipment> current = head;
        int currentIndex = 0;

        while (currentIndex < toIndex) {
            if (currentIndex >= fromIndex) {
                subList.add(current.data);
            }
            current = current.next;
            currentIndex++;
        }

        return subList;
    }
}
