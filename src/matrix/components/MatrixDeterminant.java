package matrix.components;

import matrix.exceptions.WrongMatrixException;
import matrix.exceptions.ZeroColumnElementException;

public class MatrixDeterminant {

    private EchelonMatrix matrix;

    public double getDeterminant(double[][] squareMatrixArray) throws WrongMatrixException, ZeroColumnElementException {
        matrix = new EchelonMatrix(squareMatrixArray);
        double diagonalProduct = countDiagonalProduct();
        return Math.pow(-1, matrix.getPermutations()) * diagonalProduct;
    }

    private double countDiagonalProduct() {
        double diagonalProduct = matrix.get(0, 0);
        for (int i = 1; i < matrix.size(); ++i)
            diagonalProduct *= matrix.get(i, i);
        return diagonalProduct;
    }
}
