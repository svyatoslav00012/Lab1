package matrix.api;

import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;

public interface MatrixUtils {

    double[][] getInverse(double[][] matrix) throws ZeroColumnElementException, NoSolutionsException;

    double[] getSolution(double[][] matrix, double[] b) throws ZeroColumnElementException, NoSolutionsException;

    double getDeterminant(double[][] matrix) throws ZeroColumnElementException;
}
