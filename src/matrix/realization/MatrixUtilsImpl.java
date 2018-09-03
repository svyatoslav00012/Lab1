package matrix.realization;

import matrix.api.MatrixUtils;
import matrix.components.InverseMatrix;
import matrix.components.MatrixDeterminant;
import matrix.components.MatrixSolutions;
import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;

public class MatrixUtilsImpl implements MatrixUtils {

    private MatrixSolutions matrixSolutions = new MatrixSolutions();
    private MatrixDeterminant matrixDeterminant = new MatrixDeterminant();
    private InverseMatrix inverseMatrix = new InverseMatrix();

    @Override
    public double[][] getInverse(double[][] matrix) throws ZeroColumnElementException, NoSolutionsException {
        return inverseMatrix.getInverseMatrix(matrix);
    }

    @Override
    public double[] getSolution(double[][] matrix, double[] b) throws ZeroColumnElementException, NoSolutionsException {
        return matrixSolutions.getSolution(matrix, b);
    }

    @Override
    public double getDeterminant(double[][] matrix) throws ZeroColumnElementException {
        return matrixDeterminant.getDeterminant(matrix);
    }
}
