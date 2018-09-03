package matrix.components;

import matrix.exceptions.WrongMatrixException;
import matrix.exceptions.ZeroColumnElementException;

public class EchelonMatrix extends SquareMatrix {

    private int n;

    public EchelonMatrix(SquareMatrix another) throws ZeroColumnElementException, WrongMatrixException {
        super(another);
        this.n = size();
        toRowEchelonView();
    }

    public EchelonMatrix(double[][] matrix) throws ZeroColumnElementException, WrongMatrixException {
        super(matrix);
        this.n = size();
        toRowEchelonView();
    }

    private void toRowEchelonView() throws ZeroColumnElementException {
        for (int level = 0; level < n - 1; ++level)
            handleSubMatrix(level);
    }

    private void handleSubMatrix(int level) throws ZeroColumnElementException {
        int rowWithMaxElem = getRowIndexWithMaxFirstElemInSubMatrix(level);
        int firstRow = level;
        if (rowWithMaxElem != firstRow)
            swapRows(firstRow, rowWithMaxElem);
        sumRowsWithFirst(level);
    }

    private void sumRowsWithFirst(int level) {
        for (int i = level + 1; i < n; ++i)
            simplifyToRows(level, i);
    }

    private void simplifyToRows(int level, int secondRowIndex) {
        double firstRowFirstElem = get(level, level);
        double secondRowFirstElem = get(secondRowIndex, level);
        double coef = secondRowFirstElem / firstRowFirstElem;
        double[] newRow = getRowMultilpliedByCoef(level, -coef);
        addRowsSaveToSecond(newRow, getRow(secondRowIndex));
    }

    private void addRowsSaveToSecond(double[] row1, double[] row2) {
        for (int i = 0; i < row1.length; ++i)
            row2[i] += row1[i];
    }

    private int getRowIndexWithMaxFirstElemInSubMatrix(int level) throws ZeroColumnElementException {
        int maxIndex = level;
        double maxModEl = Math.abs(get(level, level));

        for (int i = level + 1; i < n; ++i) {
            double curModEl = Math.abs(get(i, level));
            if (curModEl > maxModEl) {
                maxModEl = curModEl;
                maxIndex = i;
            }
        }

        if (maxModEl == 0)
            throw new ZeroColumnElementException();

        return maxIndex;
    }

}
