package test.tests;

import org.junit.jupiter.api.Test;
import test.testUtils.Test1VUtils;

public class Test1V {

    Test1VUtils test1VUtils = new Test1VUtils();

    @Test
    public void test1Var1MatrixSolution() {
        test1VUtils.testMatrixSolution(1, true);
    }

    @Test
    public void test1Var1MatrixDeterminant() {
        test1VUtils.testMatrixDeterminant(1);
    }

    @Test
    public void test1Var2MatrixSolution() {
        test1VUtils.testMatrixSolution(2, true);
    }

    @Test
    public void test1Var2MatrixDeterminant() {
        test1VUtils.testMatrixDeterminant(2);
    }

    @Test
    public void test1Var3MatrixSolution() {
        test1VUtils.testMatrixSolution(3, true);
    }

    @Test
    public void test1Var3MatrixDeterminant() {
        test1VUtils.testMatrixDeterminant(3);
    }

    @Test
    public void test1Var4MatrixSolution() {
        test1VUtils.testMatrixSolution(4, false);
    }

    @Test
    public void test1Var4MatrixDeterminant() {
        test1VUtils.testMatrixDeterminant(4);
    }

}
