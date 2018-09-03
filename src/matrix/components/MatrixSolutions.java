package matrix.components;

import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;

public class MatrixSolutions {

    private EchelonMatrix matrix;
    private double[] solution;
    private int n;

    public double[] getSolution(double[][] squareMatrixArray, double[] b) throws ZeroColumnElementException, NoSolutionsException {
        SquareMatrix squareMatrix = new SquareMatrix(squareMatrixArray);
        return getSolution(squareMatrix, b);
    }

    public double[] getSolution(SquareMatrix someMatrix, double[] b) throws ZeroColumnElementException, NoSolutionsException {
        someMatrix.toExpanded(b);
        matrix = new EchelonMatrix(someMatrix);
        n = matrix.size();
        solution = new double[n];

        calculateSolution();
        return solution;
    }

    public void calculateSolution() throws ZeroColumnElementException, NoSolutionsException {
        checkCorrectSolution();
        calculateLastX();
        calculatePreLastToFirstX();
    }

    private void checkCorrectSolution() throws NoSolutionsException {
        for(int i = 0; i < n; ++i)
            if(matrix.get(i, i) == 0)
                throw new NoSolutionsException();
    }

    private void calculateLastX() {
        solution[n - 1] = matrix.getB(n - 1) / matrix.get(n - 1, n - 1);
    }

    private void calculatePreLastToFirstX() {
        for (int k = n - 2; k >= 0; --k) {
            double sum = 0;
            for (int j = k + 1; j < n; ++j)
                sum += solution[j] * matrix.get(k, j);

            solution[k] = (matrix.getB(k) - sum) / matrix.get(k, k);
        }
    }
}
