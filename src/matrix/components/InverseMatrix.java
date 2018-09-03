package matrix.components;

import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;

public class InverseMatrix {

    private double[][] inverseMatrixArray;
    private MatrixSolutions solutions = new MatrixSolutions();
    private SquareMatrix matrix;
    private int n;

    public double[][] getInverseMatrix(double[][] squareMatrixArray) throws ZeroColumnElementException, NoSolutionsException {
        matrix = new SquareMatrix(squareMatrixArray);

        n = matrix.size();
        inverseMatrixArray = new double[n][n];

        /*
        solving the system...

        A * x1 = e1
        A * x2 = e2
        ...
        A * x3 = e3

         */
        for (int column = 0; column < n; ++column) {
            calculateInverseMatrixColumn(column);
        }
        return inverseMatrixArray;
    }

    private void calculateInverseMatrixColumn(int columnIndex) throws ZeroColumnElementException, NoSolutionsException {
        SquareMatrix currentMatrix = new SquareMatrix(matrix);
        double[] b = getEColumn(columnIndex);
        double[] solution = solutions.getSolution(currentMatrix, b);
        for (int row = 0; row < n; ++row)
            inverseMatrixArray[row][columnIndex] = solution[row];
    }

    //returns column number @index of E matrix
    private double[] getEColumn(int index) {
        double[] column = new double[n];
        column[index] = 1;
        return column;
    }
}
