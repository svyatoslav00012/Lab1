package test.tests;

import matrix.api.MatrixUtils;
import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;
import matrix.realization.MatrixUtilsImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static test.myAssert.Assert.*;


public class MyTest {

    private MatrixUtils utils = new MatrixUtilsImpl();

    @Test
    public void testSimpleMatrixDeterminant1() {

        double[][] simpleMatrix = {
                {5, 7},
                {2, -3}
        };

        double expectedResult = -29;
        double actualResult = 0;
        try {
            actualResult = utils.getDeterminant(simpleMatrix);
        } catch (ZeroColumnElementException e) {
            assert false;
        }
        System.out.println(actualResult);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testSimpleMatrixDeterminant2() {

        double[][] simpleMatrix = {
                {-2, 3, -1},
                {5, -1, 4},
                {4, -8, 2}
        };

        double expectedResult = -6;
        double actualResult = 0;
        try {
            actualResult = utils.getDeterminant(simpleMatrix);
        } catch (ZeroColumnElementException e) {
            assert false;
        }
        System.out.println(actualResult);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testSimpleMatrixSolution1() {

        double[][] simpleMatrix = {
                {3, -2},
                {5, 1}
        };

        double[] b = {-6, 3};

        double[] expectedResult = {0, 3};
        double[] actualResult = new double[2];
        try {
            actualResult = utils.getSolution(simpleMatrix, b);
        } catch (ZeroColumnElementException e) {
            assert false;
        } catch (NoSolutionsException e){
            assert false;
        }
        System.out.println(Arrays.toString(actualResult));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSimpleMatrixSolution2() {

        double[][] simpleMatrix = {
                {0, 1, -6, -4},
                {3, -1, -6, -4},
                {2, 3, 9, 2},
                {3, 2, 3, 8}
        };

        double[] b = {6, 2, 6, -7};

        double[] expectedResult = {0, 2, 1.0 / 3.0, -1.5};
        double[] actualResult = new double[2];
        try {
            actualResult = utils.getSolution(simpleMatrix, b);
        } catch (ZeroColumnElementException e) {
            assert false;
        } catch (NoSolutionsException e){
            assert false;
        }
        System.out.println(Arrays.toString(actualResult));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSimpleMatrixGetInverse1() {

        double[][] simpleMatrix = {
                {2, 5, 7},
                {6, 3, 4},
                {5, -2, -3}
        };

        double[][] expectedResult = {
                {1, -1, 1},
                {-38, 41, -34},
                {27, -29, 24}
        };

        double[][] actualResult = new double[3][3];
        try {
            actualResult = utils.getInverse(simpleMatrix);
        } catch (ZeroColumnElementException e) {
            assert false;
        } catch (NoSolutionsException e) {
            assert false;
        }
        for (int i = 0; i < actualResult.length; ++i) {
            for (int j = 0; j < actualResult[i].length; ++j)
                System.out.print(actualResult[i][j] + " ");
            System.out.println();
        }

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSimpleMatrixGetInverse2() {

        double[][] simpleMatrix = {
                {3, 4},
                {5, 7}
        };

        double[][] expectedResult = {
                {7, -4},
                {-5, 3}
        };

        double[][] actualResult = new double[3][3];
        try {
            actualResult = utils.getInverse(simpleMatrix);
        } catch (ZeroColumnElementException e) {
            assert false;
        } catch (NoSolutionsException e) {
            assert false;
        }
        for (int i = 0; i < actualResult.length; ++i) {
            for (int j = 0; j < actualResult[i].length; ++j)
                System.out.print(actualResult[i][j] + " ");
            System.out.println();
        }

        assertEquals(expectedResult, actualResult);
    }


}
