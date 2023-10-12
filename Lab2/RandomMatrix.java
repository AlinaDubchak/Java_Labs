package Java_Labs.Lab2;
import java.util.Random;

public class RandomMatrix {
    public long[][] generateRandomMatrix(int numRows, int numCols) {
        Random random = new Random();
        long[][] matrix = new long[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = random.nextLong();
            }
        }

        return matrix;
    }
}
