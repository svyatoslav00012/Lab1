package test.testUtils;

import javafx.util.Pair;
import matrix.api.MatrixUtils;
import matrix.exceptions.NoSolutionsException;
import matrix.exceptions.ZeroColumnElementException;
import matrix.realization.MatrixUtilsImpl;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static test.myAssert.Assert.assertEquals;
import static test.testUtils.FileUtils.*;

public class Test1VUtils {

    private MatrixUtils utils = new MatrixUtilsImpl();

    public void testMatrixSolution(int matrixNumber, boolean hasSolution){

        Pair<double[][], double[]> p = tryToReadExpandedMatrixFromFile(matrixNumber);
        double[][] matrix = p.getKey();
        double[] b = p.getValue();

        double[] expected = getExpectedSolution(matrixNumber);

        try {
            writeActualResults(matrixNumber);
            double[] actual = utils.getSolution(matrix, b);
            assertEquals(expected, actual);
        } catch (ZeroColumnElementException e) {
            if(expected.length > 0){
                System.out.println("error");
                assert false;
            }
        } catch (NoSolutionsException e){
            assert !hasSolution;
        }
    }

    public void testMatrixDeterminant(int matrixNumber){
        Pair<double[][], double[]> p = tryToReadExpandedMatrixFromFile(matrixNumber);
        double[][] matrix = p.getKey();
        double[] b = p.getValue();

        double expected = getExpectedDeterminant(matrixNumber);

        try {
            writeActualResults(matrixNumber);
            double actual = utils.getDeterminant(matrix);
            assertEquals(expected, actual);
        } catch (ZeroColumnElementException e) {
            System.out.println("error");
            assert false;
        }
    }

    private void writeActualResults(int matrixNumber) throws ZeroColumnElementException {
        Pair<double[][], double[]> expanded = tryToReadExpandedMatrixFromFile(matrixNumber);
        double[][] matrix = expanded.getKey();
        double[] b = expanded.getValue();

        double[] solution = new double[0];
        try{
            solution = utils.getSolution(matrix, b);
        } catch (NoSolutionsException e){}
        double determinant = utils.getDeterminant(matrix);

        File file = get1VAnswerFile(matrixNumber);
        try {
            writeToFile(file, solution, determinant);
        } catch (Exception e){}
    }

    private void writeToFile(File file, double[] solution, double determinant) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        writer.write(solution.length);
        writer.newLine();
        for(int i = 0; i < solution.length; ++i)
            writer.write(solution[i]+ " ");
        writer.newLine();
        writer.write(determinant+"");
    }

    private double getExpectedDeterminant(int matrixNumber){
        double[] solNdet = getExpected(matrixNumber);
        return solNdet[solNdet.length - 1];
    }

    private double[] getExpectedSolution(int matrixNumber){
        double[] solNdet = getExpected(matrixNumber);
        return Arrays.copyOf(solNdet, solNdet.length - 1);
    }

    //returns solution array + last elem is determinant
    private double[] getExpected(int matrixNumber){
        try {
            return readExpectedAns(matrixNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double[] readExpectedAns(int matrixNumber) throws FileNotFoundException {
        File expected = get1VExpectedFile(matrixNumber);
        Scanner in = new Scanner(new FileInputStream(expected));
        int n = in.nextInt();
        double[] ans = new double[n + 1];
        for(int i = 0; i < n; ++i)
            ans[i] = in.nextDouble();
        //determinant
        ans[n] = in.nextDouble();
        return ans;
    }

    private Pair<double[][], double[]> tryToReadExpandedMatrixFromFile(int matrixIndex){
        try {
            File task = get1VTaskFile(matrixIndex);
            return readExpandedMatrixFromFile(task);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Pair<double[][], double[]> readExpandedMatrixFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(file));
        int n = in.nextInt();

        double[][] matrix = new double[n][n];
        double[] b = new double[n];

        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                matrix[i][j] = in.nextDouble();
            b[i] = in.nextDouble();
        }
        return new Pair<>(matrix, b);
    }

}
