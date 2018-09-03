package test.testUtils;

import matrix.api.MatrixUtils;
import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;
import matrix.realization.MatrixUtilsImpl;

import java.io.*;
import java.util.Scanner;

import static test.myAssert.Assert.assertEquals;
import static test.myAssert.Assert.fail;
import static test.testUtils.FileUtils.*;

public class Test2VUtils {

    public void testInverseMatrix(int matrixNumber) {
        double[][] matrix = tryToReadTaskFromFile(matrixNumber);

        double[][] expected = tryToReadExpectedInverseMatrix(matrixNumber);

        try {
            double[][] actual = calculateWriteAndReturnActualInverseMatrix(matrixNumber, matrix);
            assertEquals(expected, actual);
        } catch (ZeroColumnElementException e) {
            fail("ZeroColumnElementException variant: 2 matirx: " + matrixNumber);
        } catch (NoSolutionsException e) {
            fail("NoSolutionsException variant: 2 matrix : " + matrixNumber);
        }
    }

    private double[][] calculateWriteAndReturnActualInverseMatrix(int matrixNumber, double[][] matrix) throws ZeroColumnElementException, NoSolutionsException {
        MatrixUtils utils = new MatrixUtilsImpl();
        double[][] inverse = utils.getInverse(matrix);

        File file = get2VAnswerFile(matrixNumber);
        try {
            writeActualInverseMatrixToFile(file, inverse);
        } catch (Exception e) {
        }
        return inverse;
    }

    private void writeActualInverseMatrixToFile(File file, double[][] inverse) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        writer.write(inverse.length);
        writer.newLine();
        for (int i = 0; i < inverse.length; ++i) {
            for (int j = 0; j < inverse[i].length; ++j)
                writer.write(inverse[i][j] + " ");
            writer.newLine();
        }
    }

    private double[][] tryToReadExpectedInverseMatrix(int matrixNumber) {
        try {
            File expected = get2VExpectedFile(matrixNumber);
            return readSquareMatrixFromFile(expected);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double[][] tryToReadTaskFromFile(int matrixIndex) {
        try {
            File task = get2VTaskFile(matrixIndex);
            return readSquareMatrixFromFile(task);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double[][] readSquareMatrixFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(file));
        int n = in.nextInt();

        double[][] matrix = new double[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                matrix[i][j] = in.nextDouble();
        return matrix;
    }

}
