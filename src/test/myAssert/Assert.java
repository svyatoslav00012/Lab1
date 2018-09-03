package test.myAssert;

import static test.myAssert.ResultComparsion.*;

public class Assert {

    public static void assertTrue(boolean value) {
        assert value;
    }

    public static void assertFalse(boolean value) {
        assertTrue(!value);
    }

    public static void assertEquals(double d1, double d2) {
        assert doubleEquals(d1, d2);
    }

    public static void assertEquals(double[] arr1, double[] arr2) {
        assert doubleArrayEquals(arr1, arr2);
    }

    public static void assertEquals(double[][] expected, double[][] actual) {
        assert double2DArrayEquals(expected, actual);
    }


    public static void fail(String message) {
        System.err.println(message);
        assert false;
    }
}
