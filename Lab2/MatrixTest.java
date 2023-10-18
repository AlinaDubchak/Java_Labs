package Java_Labs.Lab2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MatrixTest {
    private TransposedMatrix matrixTranspose;

    @Before
    public void setUp() {
        matrixTranspose = new TransposedMatrix();
    }

    @Test
    public void testTransposeRegularMatrix() {
        long[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}};
        long[][] expectedTransposed = {{1, 4}, {2, 5}, {3, 6}};
        long[][] result = matrixTranspose.transpose(inputMatrix);
        assertArrayEquals(expectedTransposed, result);
    }

    @Test
    public void testTransposeEmptyMatrix() {
        long[][] emptyMatrix = new long[0][0];
        try {
            matrixTranspose.transpose(emptyMatrix);
            fail("IllegalArgumentException should have been thrown for an empty matrix");
        } catch (IllegalArgumentException e) {
            assertEquals("Input matrix is empty", e.getMessage());
        }
    }

    @Test
    public void testTransposeMatrixWithNullRow() {
        long[][] matrixWithNullRow = {{1, 2, 3}, null, {4, 5, 6}};
        try {
            matrixTranspose.transpose(matrixWithNullRow);
            fail("IllegalArgumentException should have been thrown for a null row");
        } catch (IllegalArgumentException e) {
            assertEquals("Row 1 is null or empty", e.getMessage());
        }
    }

    @Test
    public void testTransposeMatrixWithEmptyRow() {
        long[][] matrixWithEmptyRow = {{1, 2, 3}, {}, {4, 5, 6}};
        try {
            matrixTranspose.transpose(matrixWithEmptyRow);
            fail("IllegalArgumentException should have been thrown for an empty row");
        } catch (IllegalArgumentException e) {
            assertEquals("Row 1 is null or empty", e.getMessage());
        }
    }

    @Test
    public void testTransposeSquareMatrix() {
        long[][] squareMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long[][] expectedTransposedSquare = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        long[][] resultSquare = matrixTranspose.transpose(squareMatrix);
        assertArrayEquals(expectedTransposedSquare, resultSquare);
    }

    @Test
    public void testFindRowAverages() {
        TransposedMatrix matrixProcessor = new TransposedMatrix();
        long[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        matrixProcessor.findRowAverages(matrix);

        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        double[] expectedAverages = {2.000, 5.000, 8.000};

        for (int i = 0; i < matrix.length; i++) {
            String[] tokens = outputLines[i].split(": ");
            String averageString = tokens[1];
            double actualAverage = Double.parseDouble(averageString);

            assertEquals(expectedAverages[i], actualAverage, 0.001);
        }
    }
}
