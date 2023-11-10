package Java_Labs.Lab4;
import java.util.Arrays;
import java.util.Comparator;

public class FurnitureSorter {
    public static void main(String[] args) {
        // Creating an array from "Furniture" class objects
        Furniture[] furnitureArray = new Furniture[5];


        furnitureArray[0] = new Furniture("Стіл", 120, 80, 70, 100);
        furnitureArray[1] = new Furniture("Диван", 200, 90, 80, 500);
        furnitureArray[2] = new Furniture("Ліжко", 180, 200, 60, 800);
        furnitureArray[3] = new Furniture("Шафа", 100, 60, 200, 300);
        furnitureArray[4] = new Furniture("Стілець", 40, 40, 80, 50);

        // Sorting the array in ascending order by the "weight" field
        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getWeight));

        System.out.println("Сортування за зростанням за вагою:");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Sort the array in descending order by the "cost" field
        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getPrice).reversed());

        System.out.println("\nСортування за спаданням за вартістю:");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }
    }
}

class Furniture {
    private final String name;
    private final int length;
    private final int width;
    private final int height;
    private final int weight;
    private final int price;

    public Furniture(String name, int length, int width, int height, int weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.price = calculatePrice();
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    private int calculatePrice() {
        return length * width + height + weight;
    }

    @Override
    public String toString() {
        return "Меблі: " + name + ", Вага: " + weight + " кг, Вартість: " + price + " грн";
    }
}
