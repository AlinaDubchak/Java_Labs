package Java_Labs.Lab2;

public class Main {
    public static void main(String[] args) {
        try {
          //  long[][] matrix = new long[][]{{1,4,6,7},{3,7,2,7}};

            int numRows = 3;
            int numCols = 3;
            RandomMatrix randomMatrix = new RandomMatrix();
            long[][] matrix = randomMatrix.generateRandomMatrix(numRows, numCols);

            System.out.println("Initial matrix");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            TransposedMatrix matrix1 = new TransposedMatrix();
            long[][] transposedMatrix = matrix1.transpose(matrix);

            System.out.println("Transposed matrix");

            for (int i = 0; i < transposedMatrix.length; i++) {
                for (int j = 0; j < transposedMatrix[i].length; j++) {
                    System.out.print(transposedMatrix[i][j] + " ");
                }
                System.out.println();
            }

             TransposedMatrix.average(transposedMatrix);

        } catch (Exception ex) {
            System.err.println("ERR, please change input. The problem is: \n"
                    + ex.getMessage());
        }
    }


}