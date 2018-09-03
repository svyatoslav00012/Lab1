package matrix.components;

import matrix.exceptions.WrongMatrixException;

import java.util.Arrays;

public class SquareMatrix {

    private double[][] matrix;
    private boolean isExpanded = false;
    private int permutations = 0;

    public SquareMatrix(SquareMatrix another) {
        matrix = new double[another.height()][another.height()];
        for (int i = 0; i < another.height(); ++i)
            matrix[i] = Arrays.copyOf(another.getRow(i), another.width());
    }

    public SquareMatrix(double[][] matrix) {
        copyToIt(matrix);
        if (!isSquare())
            throw new WrongMatrixException();
    }

    public int size() {
        return height();
    }

    public int getPermutations() {
        return permutations;
    }

    public double get(int i, int j) {
        return matrix[i][j];
    }

    public double getB(int index) {
        return matrix[index][width() - 1];
    }

    public double[] getRow(int rowIndex) {
        return matrix[rowIndex];
    }

    public double[] getRowMultilpliedByCoef(int rowIndex, double coef) {
        double[] newRow = new double[width()];
        double[] existingRow = matrix[rowIndex];
        for (int i = 0; i < newRow.length; ++i)
            newRow[i] = existingRow[i] * coef;
        return newRow;
    }

    public void swapRows(int first, int second) {
        double[] buf = matrix[first];
        matrix[first] = matrix[second];
        matrix[second] = buf;
        permutations++;
    }

    public void toExpanded(double[] b) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length + 1);
            matrix[i][matrix[i].length - 1] = b[i];
        }
        isExpanded = true;
    }

    public void print() {
        System.out.println();
        System.out.println("===");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println("===");
        System.out.println();
    }

    private boolean isSquare() {
        return !isExpanded && width() == height() || isExpanded && height() == width() - 1;
    }

    private int width() {
        return matrix.length == 0 ? 0 : matrix[0].length;
    }

    private int height() {
        return matrix.length;
    }

    private void copyToIt(double[][] another){
        int n = another.length;
        int m = another.length == 0 || another[0] == null ? 0 : another[0].length;
        matrix = new double[n][m];
        for(int i = 0; i < n; ++i)
            matrix[i] = Arrays.copyOf(another[i], m);
    }

}
