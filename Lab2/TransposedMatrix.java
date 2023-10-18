package Java_Labs.Lab2;

//1306
// C5 = B^T
// C7 = long
// Знайти середнє значення елементів кожного рядка матриці
//

public class TransposedMatrix {
    public long[][] transpose(long[][] matrix) {

        int numRows = matrix.length;
        if (numRows == 0) {
            throw new IllegalArgumentException("Input matrix is empty");
        }
        int numCols = matrix[0].length;

        long[][] transposedMatrix = new long[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            if (matrix[i] == null || matrix[i].length == 0) {
                throw new IllegalArgumentException("Row " + i + " is null or empty");
            }
            for (int j = 0; j < numCols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public void findRowAverages(long[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            long rowSum = 0;
            int rowCount = matrix[i].length;


            for (int j = 0; j < rowCount; j++) {
                rowSum += matrix[i][j];
            }

            double rowAverage = rowSum / rowCount;
            String result = String.format("%.3f", rowAverage).replace(",", ".");;
            System.out.println("The average value of the elements in row " + i + ": " + result);
        }
    }

}